# Talent Recruitment Management Portal

A full-stack web application for managing job postings, candidate applications, and recruitment workflows.

## Tech Stack
* **Backend:** Java 17, Spring Boot, Spring Data JPA
* **Frontend:** HTML5, CSS3, JavaScript, Thymeleaf
* **Database:** MySQL
* **Build Tool:** Maven

## Features
* **Job Posting Management:** Create, read, edit, and soft-delete/deactivate job postings.
* **Candidate Management:** Register candidates and associate them with open jobs.
* **Recruitment Status Tracking:** Track and transition candidates through stages (`APPLIED`, `SCREENING`, `INTERVIEW_SCHEDULED`, `OFFER_EXTENDED`, `HIRED`, `REJECTED`).
* **MySQL Persistence:** Automatically creates schema using Spring Data JPA.

## ⚙️ Setup & Execution

1. **Database Setup:**
   * Create a MySQL database:
     ```sql
     CREATE DATABASE recruitment_db;
     ```

2. **Configure Database Credentials:**
   * Update `src/main/resources/application.properties`:
     ```properties
     spring.datasource.username=YOUR_MYSQL_USERNAME
     spring.datasource.password=YOUR_MYSQL_PASSWORD
     ```

3. **Run Application:**
   * Using Maven terminal:
     ```bash
     mvn spring-boot:run
     ```
   * Access application in web browser at: `http://localhost:8080/jobs`
