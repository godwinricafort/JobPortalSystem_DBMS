package com.jobportal.db;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class JobPortalSystemDB {
    private static final String URL = "jdbc:mysql://localhost:3306/";
    private static final String DBNAME = "JobPortalSystemDB";
    private static String USER = "root";       // Default MySQL username
    private static String PASSWORD = "password"; // Default MySQL password
    private static final String INIT_FILE = "C:\\Users\\Godwin Miles\\Desktop\\Job Portal System\\src\\com\\jobportal\\db\\init.sql"; // Path to init.sql
    private static Connection connection = null;
    private static Scanner scanner = new Scanner(System.in);

    // Get connection to the database
    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = attemptConnection(URL + DBNAME, USER, PASSWORD);
            } catch (SQLException e) {
                System.out.println("Error: Unable to connect to the database.");
                retryConnection();
            }
        }
        return connection;
    }

    // Attempt connection with provided credentials
    private static Connection attemptConnection(String fullUrl, String user, String password) throws SQLException {
        try {
            Connection conn = DriverManager.getConnection(fullUrl, user, password);
            System.out.println("Connected to the database: " + DBNAME);
            return conn;
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1049:
                    // Error code for "Unknown database"
                    System.out.println("Database not found. Creating database...");
                    createDatabaseAndTables(user, password);
                    return DriverManager.getConnection(fullUrl, user, password);
                case 1045:
                    // Error code for "Access denied"
                    System.out.println("Error: Incorrect MySQL username or password.");
                    throw e;
                default:
                    throw e;
            }
        }
    }

    // Create database and initialize tables
    private static void createDatabaseAndTables(String user, String password) {
        try (Connection conn = DriverManager.getConnection(URL, user, password);
             Statement stmt = conn.createStatement()) {

            stmt.execute("CREATE DATABASE IF NOT EXISTS " + DBNAME);
            System.out.println("Database '" + DBNAME + "' created or already exists.");

            // Connect to the database and initialize schema
            try (Connection dbConn = DriverManager.getConnection(URL + DBNAME, user, password)) {
                executeSQLFile(dbConn, INIT_FILE);
                System.out.println("Database tables initialized successfully.");
            }
        } catch (SQLException e) {
            System.out.println("Error: Unable to create the database or initialize tables.");
            e.printStackTrace();
        }
    }

    // Execute SQL commands from init.sql
    private static void executeSQLFile(Connection conn, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            StringBuilder sql = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty() && !line.startsWith("--")) { // Skip comments
                    sql.append(line);
                    if (line.endsWith(";")) { // Execute when a statement ends
                        try (Statement stmt = conn.createStatement()) {
                            stmt.execute(sql.toString());
                        }
                        sql.setLength(0); // Clear buffer
                    }
                }
            }
            System.out.println("SQL file executed successfully.");
        } catch (IOException e) {
            System.out.println("Error: Unable to read the SQL file.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error: Unable to execute SQL commands.");
            e.printStackTrace();
        }
    }

    // Retry connection in case of failure
    public static void retryConnection() {
        while (true) {
            System.out.println("\nRetrying connection. Please enter your MySQL credentials:");
            System.out.print("Enter MySQL Username (default: root): ");
            String username = scanner.nextLine().trim();
            if (!username.isEmpty()) USER = username;

            System.out.print("Enter MySQL Password: ");
            String password = scanner.nextLine().trim();
            PASSWORD = password;

            try {
                connection = attemptConnection(URL + DBNAME, USER, PASSWORD);
                System.out.println("Connection successful!");
                break;
            } catch (SQLException e) {
                System.out.println("Connection failed. Please try again.");
            }
        }
    }

    // Close the database connection
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                System.out.println("Error closing the database connection.");
                e.printStackTrace();
            }
        }
    }
}
