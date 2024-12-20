package com.jobportal.jobs;

public class FullTimeJob extends Job {
    private int salary;
    private int postedBy; // User ID of the person who posted the job

    public FullTimeJob(int jobId, String title, String industry, String companyName, int salary, int postedBy) {
        super(jobId, title, industry, companyName);
        this.salary = salary;
        this.postedBy = postedBy;
    }

    public int getSalary() {
        return salary;
    }

    public int getPostedBy() {
        return postedBy;
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Full-Time Job Details:");
        System.out.println("Job ID: " + getJobId());
        System.out.println("Title: " + getTitle());
        System.out.println("Industry: " + getIndustry());
        System.out.println("Company: " + getCompanyName());
        System.out.println("Salary: $" + salary);
        System.out.println("Posted By (User ID): " + postedBy);
    }
}
