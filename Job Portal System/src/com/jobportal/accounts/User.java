package com.jobportal.accounts;

import com.jobportal.db.JobPortalSystemDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class User {
    private String username; // Maps to the username field in the database
    private String password;
    private String fullName; // Maps to the full_name field in the database
    private String contactEmail; // Maps to the contact_email field in the database

    public User(String username, String password, String fullName, String contactEmail) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.contactEmail = contactEmail;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    // Save user to the database
    public boolean saveToDatabase(String role) {
        String query = "INSERT INTO Users (username, password, role, full_name, contact_email) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = JobPortalSystemDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, this.username);
            stmt.setString(2, this.password);
            stmt.setString(3, role); // Role is either "JobSeeker" or "Employer"
            stmt.setString(4, this.fullName);
            stmt.setString(5, this.contactEmail);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve user from the database
    public static User getUserByUsername(String username) {
        String query = "SELECT * FROM Users WHERE username = ?";
        try (Connection connection = JobPortalSystemDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String password = rs.getString("password");
                String role = rs.getString("role");
                String fullName = rs.getString("full_name");
                String contactEmail = rs.getString("contact_email");

                // Create the appropriate user type (JobSeeker or Employer)
                if ("Employer".equalsIgnoreCase(role)) {
                    return new Employer(username, password, fullName, contactEmail);
                } else if ("JobSeeker".equalsIgnoreCase(role)) {
                    return new JobSeeker(username, password, fullName, contactEmail);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // User not found
    }

    // Delete user from the database
    public boolean deleteFromDatabase() {
        String query = "DELETE FROM Users WHERE username = ?";
        try (Connection connection = JobPortalSystemDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, this.username);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
