package com.jobportal.accounts;

import com.jobportal.jobs.*;
import com.jobportal.utils.Utils;
import com.jobportal.dao.JobDAO;
import com.jobportal.dao.ApplicationDAO;

import java.util.List;
import java.util.Scanner;

public class JobSeeker extends User {
    private Scanner scanner = new Scanner(System.in);
    private JobDAO jobDAO = new JobDAO(); // Database access object for jobs
    private ApplicationDAO applicationDAO = new ApplicationDAO(); // DAO for applications

    public JobSeeker(String name, String email, String password) {
        super(name, email, password);
    }

    public void browseAndApply() {
        while (true) {
            Utils.delay(500);
            Utils.clearScreen();
            Utils.headerDesign();

            System.out.println("\n=== Job Seeker Menu ===");
            System.out.println("\n[1] Browse Jobs");
            System.out.println("[2] Apply for a Job");
            System.out.println("[3] Log Out");
            System.out.print("\nChoose an option: ");

            int choice = getValidInput();
            switch (choice) {
                case 1:
                    browseJobs();
                    break;
                case 2:
                    applyForJob();
                    break;
                case 3:
                    System.out.println("\nLogging out...");
                    return;
                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        }
    }

    private void browseJobs() {
        Utils.delay(500);
        Utils.clearScreen();
        Utils.headerDesign();

        System.out.println("\n=== Browse Jobs ===");
        
        // Fetch jobs from the database using JobDAO
        List<Job> jobs = jobDAO.getAllJobs();

        if (jobs.isEmpty()) {
            System.out.println("No jobs available at the moment.");
        } else {
            for (int i = 0; i < jobs.size(); i++) {
                System.out.println((i + 1) + ". " + jobs.get(i)); // Display jobs
            }
        }
    }

    private void applyForJob() {
        // Display jobs to choose from
        List<Job> jobs = jobDAO.getAllJobs();
        if (jobs.isEmpty()) {
            System.out.println("No jobs available to apply for.");
            return;
        }

        System.out.println("\n=== Available Jobs ===");
        for (int i = 0; i < jobs.size(); i++) {
            System.out.println((i + 1) + ". " + jobs.get(i)); // Display jobs
        }

        System.out.print("Enter the job number you want to apply for: ");
        int jobIndex = getValidInput() - 1;

        if (jobIndex >= 0 && jobIndex < jobs.size()) {
            Job selectedJob = jobs.get(jobIndex);
            
            // Create an application for the selected job
            Application application = new Application(this.getEmail(), selectedJob.getJobId());
            boolean isApplied = applicationDAO.addApplication(application);

            if (isApplied) {
                System.out.println("You successfully applied for: " + selectedJob.getTitle() + " at " + selectedJob.getCompanyName());
            } else {
                System.out.println("An error occurred while applying for the job. Please try again.");
            }
        } else {
            System.out.println("Invalid job number.");
        }
    }

    private int getValidInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return -1;
        }
    }
}
