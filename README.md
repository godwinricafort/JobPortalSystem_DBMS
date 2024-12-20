# Job Portal System

## 1. Project Overview
The **Job Portal System** is a console-based application designed to connect job seekers with potential employers. It provides an intuitive interface for users to either post jobs or apply for them, streamlining the job-hunting and recruitment process. The system promotes inclusivity and accessibility by allowing users to register, log in, and interact with the platform as either a **Job Seeker** or an **Employer**.

### Key Features:
- **Account Management**: Users can sign up as either job seekers or employers and log in to their respective dashboards.
- **Job Posting**: Employers can post full-time or part-time jobs, specifying the job title, industry, company name, and salary range.
- **Job Application**: Job seekers can view available jobs and apply for positions of interest.
- **Dynamic Job List**: Jobs are categorized as full-time or part-time and displayed in an organized list.
- **Error Handling**: Invalid inputs are managed effectively to ensure a smooth user experience.

---

## 2. Application of Object-Oriented Programming Principles

This project effectively demonstrates the four core principles of Object-Oriented Programming (OOP). The table below summarizes how each principle is applied in the project, the related classes, and a brief explanation:

| **OOP Principle** | **Classes Involved**                      | **Explanation**                                                                                                                                     |
|--------------------|-------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------|
| **Encapsulation** | `User`, `Job`, `JobSeeker`, `Employer`    | Encapsulation is implemented by making fields private and providing public getter and setter methods to control access to sensitive data.           |
| **Inheritance**    | `User` → `JobSeeker`, `Employer` <br> `Job` → `FullTimeJob`, `PartTimeJob` | Inheritance promotes code reuse and hierarchy. Subclasses inherit shared properties and behaviors from parent classes like `User` and `Job`.         |
| **Polymorphism**   | `Job`, `FullTimeJob`, `PartTimeJob`       | Polymorphism allows the `JobList` class to treat `FullTimeJob` and `PartTimeJob` objects as `Job` types. Methods like `displayJobs()` behave differently for each subclass. |
| **Abstraction**    | `User`, `Job`                            | Abstract concepts are modeled in base classes such as `User` and `Job`. These classes define shared fields and methods for their respective subclasses, simplifying the design. |

### Explanation of Key OOP Features:
- **Encapsulation**: Protects the integrity of the data by restricting direct access. For example, the `password` field in the `User` class is private and accessed only via its getters and setters.
- **Inheritance**: Allows specialized classes like `JobSeeker` and `Employer` to inherit common fields (`name`, `email`, `password`) and methods from the `User` class, reducing redundancy.
- **Polymorphism**: Enables the program to dynamically determine the type of job (full-time or part-time) at runtime. The `displayJobs()` method in `JobList` uses polymorphism to distinguish between `FullTimeJob` and `PartTimeJob` objects.
- **Abstraction**: Simplifies the program structure by defining abstract properties and behaviors in base classes (`User` and `Job`) and allowing subclasses to implement specific functionality.

---

## 3. Sustainable Development Goal Integration
This project aligns with **United Nations Sustainable Development Goal 8 (SDG 8)**: *Promote sustained, inclusive, and sustainable economic growth, full and productive employment, and decent work for all*.

### How SDG 8 is Integrated:
1. **Inclusive Employment Opportunities**: 
   - The platform bridges the gap between job seekers and employers, fostering an inclusive job market.
   - Users can easily post or apply for jobs regardless of their background.

2. **Decent Work Promotion**:
   - Employers are encouraged to post jobs with fair salaries.
   - The distinction between full-time and part-time jobs helps users make informed decisions based on their circumstances.

3. **Sustainable Economic Growth**:
   - By simplifying recruitment and job search processes, the system contributes to a more efficient labor market, enhancing productivity and economic growth.

---

## 4. Instructions for Running the Program
Follow these steps to run the Job Portal System program on your local machine:

### Prerequisites:
- Ensure you have **Java Development Kit (JDK)** installed (version 8 or later).
- A code editor such as **Visual Studio Code** or **IntelliJ IDEA** is recommended.
- A terminal or command prompt to execute the program.

### Steps:
1. Clone this repository:
   ```bash
   git clone <repository_url>
   cd <repository_directory>

2. Open the project folder in your preferred code editor.
   File Structure:
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
   
3. Compile the program:
   - Navigate to the src directory containing the code.
   - Run the following command to compile all Java files:
   ```bash
   javac com/jobportal/**/*.java

4. Run the program:
   ```bash
   java com.jobportal.system.JobPortalSystem

5. Follow the on-screen instructions to interact with the system:
   - Create an account as a Job Seeker or an Employer.
   - Employers can post jobs, and job seekers can view and apply for them.
  
  
