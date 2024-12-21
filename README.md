# Job Portal System

A **Job Portal System** that connects job seekers and employers. This system allows job seekers to search and apply for jobs, while employers can post job openings and manage applications.

## Features
- **User Roles**: Job Seekers and Employers
- **Sign Up & Login**: Secure authentication for users
- **Job Seeker Functionalities**:
  - Browse and search job listings
  - Apply for jobs
- **Employer Functionalities**:
  - Post job openings
  - View and manage job applications
- **Database Integration**: MySQL is used to store user data, job postings, and applications.

---

## Technologies Used
- **Programming Language**: Java
- **Database**: MySQL
- **Development Tools**:
  - IntelliJ IDEA / Eclipse
  - MySQL Workbench or command-line for database management
  - JDBC (Java Database Connectivity) for database integration

---

## Database Setup
1. **Create the database and tables**:
   Execute the following SQL commands to set up the required tables:

   ```sql
   CREATE DATABASE job_portal;

   USE job_portal;

   CREATE TABLE users (
       id INT AUTO_INCREMENT PRIMARY KEY,
       name VARCHAR(100),
       email VARCHAR(100) UNIQUE,
       password VARCHAR(100),
       role ENUM('job_seeker', 'employer') NOT NULL
   );

   CREATE TABLE jobs (
       id INT AUTO_INCREMENT PRIMARY KEY,
       title VARCHAR(255),
       description TEXT,
       employer_id INT,
       FOREIGN KEY (employer_id) REFERENCES users(id)
   );

   CREATE TABLE applications (
       id INT AUTO_INCREMENT PRIMARY KEY,
       job_id INT,
       job_seeker_id INT,
       status ENUM('pending', 'accepted', 'rejected') DEFAULT 'pending',
       FOREIGN KEY (job_id) REFERENCES jobs(id),
       FOREIGN KEY (job_seeker_id) REFERENCES users(id)
   );

## Instructions for Running the Program
To run this application on your local machine, you need the following:

### Prerequisites
1. **Java Development Kit (JDK)**: Version 8 or higher
2. **MySQL Server**: Installed and running
3. **Database Schema**:
   - Create a database named `job_portal`.
   - Tables:
     - `users`: Stores user information.
     - `jobs`: Stores job postings.
     - `applications`: Stores applications submitted by job seekers.
4. **MySQL Connector/J**: Add the MySQL JDBC driver to your project.

---

### Steps:
1. **Clone this repository:**
    ```bash
    git clone <repository_url>
    cd <repository_directory>
    
Navigate to the project directory:

    ```bash
    cd jobportalsystem_dbms

2. **Set Up the Project:**

- Open the project in your IDE (e.g., IntelliJ IDEA or Eclipse).
- Ensure the MySQL Connector/J JAR file is added to your project's dependencies. 

3. **Set Up the MySQL Database:**

- Start your MySQL server.
- Use MySQL Workbench or a terminal to execute the SQL scripts provided in the Database Setup section.
    
4. **Open the project folder in your preferred code editor.
   File Structure:**
   ```bash
   Job Portal System/src/com/jobportal/
   ├── accounts/
   │   ├── AccountsManager.java
   │   ├── Employer.java
   │   ├── JobSeeker.java
   │   └── User.java
   ├── dao/
   │   ├── ApplicationDAO.java
   │   ├── JobDAO.java
   │   └── UserDAO.java
   ├── db/
   │   ├── JobPortalSystemDB.java
   │   ├── init.sql
   │   └── schema.png
   ├── jobs/
   │   ├── Application.java
   │   ├── FullTimeJob.java
   │   ├── Job.java
   │   ├── JobList.java
   │   └── PartTimeJob.java
   ├── main/
   │   └── JobPortalSystem.java
   └── utils/
   │   └── Utils.java
   └── mysql-connector-j-9.1.0.jar

5. **Compile the program:**
   - Navigate to the src directory containing the code.
   - Run the following command to compile all Java files:
   ```bash
   javac com/jobportal/**/*.java

6. **Run the program:**
   ```bash
   java com.jobportal.system.JobPortalSystem

7. Follow the on-screen instructions to interact with the system:
- Create an account as a Job Seeker or an Employer.
- Employers can post jobs, and job seekers can view and apply for them.

---

# Thank you!
  
  
