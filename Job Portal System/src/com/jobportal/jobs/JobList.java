package com.jobportal.jobs;

import com.jobportal.dao.JobDAO;
import java.util.List;

public class JobList {
    private JobDAO jobDAO = new JobDAO();

    public void displayJobs() {
        List<Job> jobs = jobDAO.getAllJobs();

        System.out.println("\n=== POSTED JOBS ===\n");
        if (jobs.isEmpty()) {
            System.out.println("No jobs available.");
            return;
        }

        for (int i = 0; i < jobs.size(); i++) {
            Job job = jobs.get(i);
            String jobType = (job instanceof FullTimeJob) ? "Full-Time" :
                             (job instanceof PartTimeJob) ? "Part-Time" : "Unknown";
            System.out.println("[" + (i + 1) + "] " + job.getTitle() + " at " + job.getCompanyName() + " (" + jobType + ")");
        }
    }

    public void addJob(Job job, int postedBy) {
        if (jobDAO.addJob(job, postedBy)) {
            System.out.println("\nJob added successfully!");
        } else {
            System.out.println("\nFailed to add job.");
        }
    }

    public Job getJob(int index) {
        List<Job> jobs = jobDAO.getAllJobs();
        if (index < 0 || index >= jobs.size()) {
            System.out.println("\nInvalid job index.");
            return null;
        }
        return jobs.get(index);
    }
}
