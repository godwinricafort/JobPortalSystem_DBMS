package com.jobportal.main;

import com.jobportal.accounts.*;
import com.jobportal.jobs.*;
import com.jobportal.utils.Utils;
import java.util.Scanner;

public class JobPortalSystem {
    private static Scanner scanner = new Scanner(System.in);
    private static JobList jobList = new JobList();

    public static void main(String[] args) {
        
        while (true) {
            Utils.delay(500);
            Utils.clearScreen();
            Utils.headerDesign();

            System.out.println("\n=== MAIN MENU ===");
            System.out.println("\n[1] Log In");
            System.out.println("[2] Sign Up");
            System.out.println("[3] Exit");
            System.out.print("\nChoose an option: ");

            int choice = getValidInput();

            Utils.delay(500);
            Utils.clearScreen();
            Utils.headerDesign();
            switch (choice) {
                case 1:
                    handleLogin();
                    break;
                case 2:
                    handleSignUp();
                    break;
                case 3:
                    System.out.println("\nThank you for using the Job Portal System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleLogin() {
        System.out.println("\n=== LOG IN ===");
        System.out.print("\nEnter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        User user = AccountManager.login(email, password);
        if (user != null) {
            if (user instanceof JobSeeker) {
                ((JobSeeker) user).browseAndApply(jobList);
            } else if (user instanceof Employer) {
                ((Employer) user).performActions(jobList);
            }
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    private static void handleSignUp() {
        System.out.println("\n=== SIGN UP ===");
        System.out.println("\n[1] Job Seeker");
        System.out.println("[2] Employer");
        System.out.print("\nChoose account type: ");

        int choice = getValidInput();
        switch (choice) {
            case 1:
                signUpJobSeeker();
                break;
            case 2:
                signUpEmployer();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void signUpJobSeeker() {
        Utils.delay(500);
        Utils.clearScreen();
        Utils.headerDesign();

        System.out.println("\n=== JOB SEEKER MENU ===\n");
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        JobSeeker jobSeeker = new JobSeeker(name, email, password);
        AccountManager.signUp(jobSeeker);
    }

    private static void signUpEmployer() {
        Utils.delay(500);
        Utils.clearScreen();
        Utils.headerDesign();

        System.out.println("\n=== EMPLOYER MENU ===");
        System.out.print("\nEnter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        Employer employer = new Employer(name, email, password);
        AccountManager.signUp(employer);
    }

    private static int getValidInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }
}
