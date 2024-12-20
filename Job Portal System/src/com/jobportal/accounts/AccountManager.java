package com.jobportal.accounts;

import com.jobportal.dao.UserDAO;

public class AccountManager {
    private static UserDAO userDAO = new UserDAO();

    // Register a new user
    public static void signUp(User user) {
        // Check if the email already exists in the database
        User existingUser = userDAO.getUserByEmail(user.getEmail());
        if (existingUser != null) {
            System.out.println("\nThis email already exists. Please use a different email.");
            return;
        }

        // Add the new user to the database
        boolean isAdded = userDAO.addUser(user);
        if (isAdded) {
            System.out.println("\nSign-up successful! Welcome, " + user.getName() + "!");
        } else {
            System.out.println("\nAn error occurred during sign-up. Please try again.");
        }
    }

    // Log in an existing user
    public static User login(String email, String password) {
        // Fetch the user from the database by email
        User user = userDAO.getUserByEmail(email);

        // Validate the password
        if (user != null && user.getPassword().equals(password)) {
            System.out.println("\nLogin successful! Welcome back, " + user.getName() + "!");
            return user;
        }

        System.out.println("\nInvalid email or password. Please try again.");
        return null; // Invalid credentials
    }
}