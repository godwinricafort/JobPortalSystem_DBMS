package com.jobportal.jobs;

public abstract class Job {
    private int jobId; // Unique identifier for the job in the database
    private String title;
    private String industry;
    private String companyName;

    public Job(int jobId, String title, String industry, String companyName) {
        this.jobId = jobId;
        this.title = title;
        this.industry = industry;
        this.companyName = companyName;
    }

    public int getJobId() {
        return jobId;
    }

    public String getTitle() {
        return title;
    }

    public String getIndustry() {
        return industry;
    }

    public String getCompanyName() {
        return companyName;
    }

    public abstract void displayJobDetails();
}
