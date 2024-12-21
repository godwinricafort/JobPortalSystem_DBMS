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
   CREATE DATABASE JobPortalSystemDB;

   USE JobPortalSystemDB;

   CREATE TABLE Users (
     user_id INT AUTO_INCREMENT PRIMARY KEY, 
     username VARCHAR(50) NOT NULL UNIQUE,   
     password VARCHAR(100) NOT NULL,         
     role ENUM('JobSeeker', 'Employer') NOT NULL, 
     full_name VARCHAR(100),                 
     contact_email VARCHAR(100)              
   );

   CREATE TABLE Jobs (
     job_id INT AUTO_INCREMENT PRIMARY KEY,  
     title VARCHAR(100) NOT NULL, 
     industry VARCHAR(50),
     company_name VARCHAR(100) NOT NULL,                       
     salary INT, 
     job_type ENUM('Full-Time', 'Part-Time') NOT NULL, 
     posted_by INT NOT NULL,                 
     FOREIGN KEY (posted_by) REFERENCES Users(user_id) 
   );

   CREATE TABLE Applications (
     application_id INT AUTO_INCREMENT PRIMARY KEY, 
     job_id INT NOT NULL,                           
     applicant_id INT NOT NULL,                     
     application_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP, 
     status ENUM('Pending', 'Accepted', 'Rejected') DEFAULT 'Pending',
     FOREIGN KEY (job_id) REFERENCES Jobs(job_id),   
     FOREIGN KEY (applicant_id) REFERENCES Users(user_id) 
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
  
  
