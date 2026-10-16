# Student Task Manager

A simple, structured web application built to master Spring Boot, Spring Data JPA, SQL, standard REST APIs, and a disciplined phase-based Git workflow.

## Table of Contents
- Project Overview
- Key Features
- Architecture
- Tech Stack
- Database Design
- API Documentation
- Phase Development Summary
- Setup and Installation Instructions
- Project Verification

## Project Overview
Student Task Manager is a full-stack, layered web application built for tracking academic and study tasks. Developed step-by-step across 10 structured phases, the project demonstrates a clean flow from frontend user interactions down to database persistence, with zero reliance on heavy external UI frameworks.

## Key Features
- Create, view, update, and delete study tasks (Full CRUD scope).
- Toggle task completion states between PENDING and COMPLETED.
- Minimalist, responsive user interface built using semantic HTML5 and custom CSS3.
- Native browser-to-backend communication via clean HTTP requests.
- Input boundary validation and centralized exception handling for robust REST API responses.
- Unit and integration test coverage across service and controller layers.

## Architecture
The application follows a standard layered architecture:
- Frontend: HTML5 & CSS3 Interface for user interaction.
- Controller Layer: Handles HTTP requests, path parameters, request bodies, and API responses.
- Service Layer: Encapsulates application and business logic, transactions, and validation rules.
- Repository Layer: Handles object persistence and SQL interaction via Spring Data JPA.
- Database Layer: SQL database storing persistent task records.

## Tech Stack
- Backend: Java, Spring Boot, Spring Data JPA, Maven
- Database: SQL Database (MySQL / PostgreSQL / H2)
- Frontend: HTML5, CSS3
- Testing: JUnit 5, Mockito, Spring Boot Test
- Version Control: Git, GitHub (Phase-Based Workflow)

## Database Design
Task Entity (Task table):
- id: Long (Primary Key, Auto-generated)
- title: String (Short task title)
- description: String (Detailed task explanation)
- deadline: Date/Time (Target completion date)
- status: Enum (PENDING, COMPLETED)

## API Documentation
Base Path: /api/tasks

- GET /api/tasks : Retrieve list of all tasks
- GET /api/tasks/{id} : Retrieve details for a specific task
- POST /api/tasks : Create a new task
- PUT /api/tasks/{id} : Update task details (title, description, deadline)
- DELETE /api/tasks/{id} : Delete a task record
- PATCH /api/tasks/{id}/status : Dedicated endpoint to toggle task status

## Phase Development Summary
The project was constructed across 10 distinct phases using logical commits and Pull Requests:
- Phase 1: Project + GitHub Setup
- Phase 2: Task Domain Model
- Phase 3: JPA Repository
- Phase 4: Service Layer Implementation
- Phase 5: REST Controller Expose
- Phase 6: HTML Frontend Interface
- Phase 7: Custom CSS Styling
- Phase 8: Frontend-to-Backend Integration
- Phase 9: Validation & Error Handling
- Phase 10: Unit/Integration Testing, Repository Cleanup, and Release Tagging

## Setup and Installation Instructions

Prerequisites:
- Java JDK 17+
- Maven 3.8+
- Relational Database (MySQL / H2)

Steps:
1. Clone the repository:
   git clone https://github.com/PratapSakthivel/STUDENT-TASK-MANAGER.git
   cd STUDENT-TASK-MANAGER

2. Configure Database:
   Update src/main/resources/application.properties with your database credentials:
   spring.datasource.url=jdbc:mysql://localhost:3306/task_manager_db
   spring.datasource.username=YOUR_DB_USER
   spring.datasource.password=YOUR_DB_PASSWORD
   spring.jpa.hibernate.ddl-auto=update

3. Build and Run:
   mvn clean install
   mvn spring-boot:run

4. Access the Application:
   Open your browser and navigate to http://localhost:8080.

## Project Verification
To run unit and integration test suites:
mvn test

---
*Completed as a phase-based engineering project.*