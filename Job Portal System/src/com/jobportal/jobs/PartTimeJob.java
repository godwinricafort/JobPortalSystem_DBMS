package com.jobportal.jobs;

public class PartTimeJob extends Job {
    private double hourlyRate;

    public PartTimeJob(String title, String industry, String companyName, double hourlyRate) {
        super(title, industry, companyName);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void displayJobDetails() {
        System.out.println("Job Title: " + getTitle());
        System.out.println("Industry: " + getIndustry());
        System.out.println("Company: " + getCompanyName());
        System.out.println("Hourly Rate: $" + hourlyRate);
    }
}
