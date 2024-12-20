package com.jobportal.dao;

import com.jobportal.jobs.Application;
import com.jobportal.db.JobPortalSystemDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationDAO {
    private Connection connection;

    public ApplicationDAO() {
        this.connection = JobPortalSystemDB.getConnection(); // Get DB connection
    }

    public boolean addApplication(Application application) {
        String query = "INSERT INTO Applications (job_id, job_seeker_email) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, application.getJobId());
            stmt.setString(2, application.getJobSeekerEmail());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
