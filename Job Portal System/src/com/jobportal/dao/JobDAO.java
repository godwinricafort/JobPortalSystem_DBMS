package com.jobportal.dao;

import com.jobportal.jobs.*;
import com.jobportal.db.JobPortalSystemDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JobDAO {

    // Add a generic Job to the database (handles FullTimeJob and PartTimeJob)
    public boolean addJob(Job job, int postedBy) {
        String query = "INSERT INTO Jobs (title, industry, company_name, salary, job_type, posted_by) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = JobPortalSystemDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setString(1, job.getTitle());
            stmt.setString(2, job.getIndustry());
            stmt.setString(3, job.getCompanyName());

            if (job instanceof FullTimeJob) {
                stmt.setDouble(4, ((FullTimeJob) job).getSalary());
                stmt.setString(5, "Full-Time");
            } else if (job instanceof PartTimeJob) {
                stmt.setDouble(4, ((PartTimeJob) job).getHourlyRate());
                stmt.setString(5, "Part-Time");
            } else {
                throw new IllegalArgumentException("Unknown job type");
            }

            stmt.setInt(6, postedBy);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Retrieve all jobs (Full-Time and Part-Time)
    public List<Job> getAllJobs() {
        List<Job> jobs = new ArrayList<>();
        String query = "SELECT * FROM Jobs";

        try (Connection connection = JobPortalSystemDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Job job = mapResultSetToJob(rs);
                if (job != null) {
                    jobs.add(job);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobs;
    }

    // Retrieve only Part-Time jobs
    public List<PartTimeJob> getPartTimeJobs() {
        List<PartTimeJob> jobs = new ArrayList<>();
        String query = "SELECT * FROM Jobs WHERE job_type = 'Part-Time'";

        try (Connection connection = JobPortalSystemDB.getConnection();
             PreparedStatement stmt = connection.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Job job = mapResultSetToJob(rs);
                if (job instanceof PartTimeJob) {
                    jobs.add((PartTimeJob) job);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return jobs;
    }

    // Helper method to map a ResultSet row to a Job object
    private Job mapResultSetToJob(ResultSet rs) throws SQLException {
        String title = rs.getString("title");
        String industry = rs.getString("industry");
        String companyName = rs.getString("company_name");
        double salaryOrRate = rs.getDouble("salary");
        String jobType = rs.getString("job_type");

        if ("Full-Time".equalsIgnoreCase(jobType)) {
            return new FullTimeJob(title, industry, companyName, salaryOrRate);
        } else if ("Part-Time".equalsIgnoreCase(jobType)) {
            return new PartTimeJob(title, industry, companyName, salaryOrRate);
        }
        return null; // Unknown job type
    }
}
