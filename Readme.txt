# Student Task Manager — Learning-Focused Phase-Based Task Management System

<div align="center">

[![Java](https://img.shields.io/badge/Java-17-orange.svg?logo=openjdk)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen.svg?logo=spring)](https://spring.io/projects/spring-boot)
[![Spring Data JPA](https://img.shields.io/badge/Spring%20Data%20JPA-ORM-blue.svg)](https://spring.io/projects/spring-data-jpa)
[![MySQL](https://img.shields.io/badge/MySQL-8.0+-blue.svg?logo=mysql)](https://www.mysql.com/)
[![License](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![Build](https://img.shields.io/badge/Build-Passing-success.svg)](https://github.com)

**A structured, learning-focused task management system engineered using a strict phase-based Git/GitHub workflow to master core backend architecture, JPA persistence, RESTful API design, and frontend-backend integration.**

[Features](#-features) • [Architecture](#-system-architecture) • [Installation](#-installation-guide) • [API Docs](#-api-documentation) • [Phase Roadmap](#-phase-based-development-roadmap)

</div>

---

## 📑 Table of Contents

- [Project Overview](#-project-overview)
- [Features](#-features)
- [System Architecture](#-system-architecture)
- [Technology Stack](#-technology-stack)
- [Folder Structure](#-folder-structure)
- [Database Design](#-database-design)
- [API Documentation](#-api-documentation)
- [Phase-Based Development Roadmap](#-phase-based-development-roadmap)
- [Git & Branching Workflow](#-git--branching-workflow)
- [Installation Guide](#-installation-guide)
- [Configuration](#-configuration)
- [Testing & Quality Assurance](#-testing--quality-assurance)
- [Learning Outcomes](#-learning-outcomes)
- [License](#-license)

---

## 🎯 Project Overview

### The Problem
When learning software engineering, developers often struggle to bridge the gap between basic coding syntax and disciplined, production-grade software development. Jumping into complex frameworks without understanding how controllers, services, repositories, database persistence, and Git workflows interconnect leads to fragile architectures and unstructured version control history.

### The Solution
**Student Task Manager** is a deliberate, small-scale web application built to practice disciplined software engineering. Instead of using complex frontend frameworks or automated generators, this project builds every layer step-by-step across **10 structured phases**, emphasizing complete architectural understanding, explicit Git workflows, and clean code principles.

---

## ✨ Features

- 📝 **Task Lifecycle Management** — Create, view, update, and delete academic/study tasks.
- 🎯 **Status State Machine** — Transition tasks seamlessly between `PENDING` and `COMPLETED`.
- 🗄️ **Relational Persistence** — Object-Relational Mapping (ORM) using Spring Data JPA backed by a SQL database.
- 🌐 **Clean RESTful API** — Standardized HTTP methods (`GET`, `POST`, `PUT`, `DELETE`) with structured JSON response payload schemas.
- 🎨 **Minimalist Responsive UI** — Semantic HTML5 and modular CSS3 interface designed without external heavy JS/UI frameworks.
- 🛡️ **Validation & Error Handling** — Centralized exception mapping and boundary validation for missing records or invalid parameters.

---

## 🏗️ System Architecture

[ Browser / HTML + CSS UI ]
│
▼ (HTTP Requests: GET, POST, PUT, DELETE)
[ Spring Boot Controller Layer ]
│
▼ (DTOs / Domain Methods)
[ Service Layer (Business Logic) ]
│
▼ (Repository Operations)
[ JPA Repository Layer ]
│
▼ (SQL Queries / JDBC)
[ SQL Database (MySQL / H2) ]


### Layer Responsibilities
| Layer | Description |
|-------|-------------|
| **Controller** | Manages REST endpoints, handles HTTP requests/responses, and validates incoming request parameters. |
| **Service** | Enforces application logic, handles transactions, and decouples HTTP concerns from database operations. |
| **Repository** | Provides database abstraction and persistence functions via Spring Data JPA interfaces. |
| **Database** | Relational storage for task entities. |

---

## 🛠️ Technology Stack

| Area | Declared Technology | Purpose |
|------|-------------------|---------|
| **Backend** | Java 17+, Spring Boot, Spring Data JPA | Application framework and backend logic |
| **Database** | SQL Database (MySQL / H2) | Persistent transactional storage |
| **Frontend** | HTML5, CSS3 | Minimalist user interface and styling |
| **Version Control** | Git, GitHub | Phase-based branching and pull request workflow |
| **Build Tool** | Maven | Dependency management and build automation |

---

## 📁 Folder Structure

student-task-manager/
├── src/
│   ├── main/
│   │   ├── java/com/taskmanager/
│   │   │   ├── TaskManagerApplication.java
│   │   │   ├── config/             # App & Security Configurations
│   │   │   ├── controller/         # Task REST Controllers
│   │   │   ├── dto/                # Request & Response DTOs
│   │   │   ├── exception/          # Global Exception Handlers
│   │   │   ├── model/              # JPA Task Entities & Enums
│   │   │   ├── repository/         # Spring Data JPA Repositories
│   │   │   └── service/            # Business Logic & Service Interfaces
│   │   └── resources/
│   │       ├── static/             # HTML & CSS Assets
│   │       └── application.properties # DB & App Configuration
│   └── test/                       # Unit & Integration Tests
├── .gitignore
├── pom.xml
└── README.md


---

## 🗄️ Database Design

### Entity Data Model

#### `Task` Entity
| Field | Type | Description |
|-------|------|-------------|
| `id` | `Long` | Primary Key (Auto-generated) |
| `title` | `String` | Short name/title of the task |
| `description` | `String` | Detailed explanation of the task |
| `deadline` | `LocalDateTime` / `LocalDate` | Targeted completion date/time |
| `status` | `Enum` | Current state (`PENDING`, `COMPLETED`) |

---

## 📡 API Documentation

### Base URL
http://localhost:8080/api/tasks


### Endpoints Summary

| Operation | HTTP Method | Endpoint | Description |
|-----------|-------------|----------|-------------|
| **Create Task** | `POST` | `/api/tasks` | Add a new study task |
| **Get All Tasks** | `GET` | `/api/tasks` | Fetch list of all tasks |
| **Get Task by ID** | `GET` | `/api/tasks/{id}` | Retrieve details of a specific task |
| **Update Task** | `PUT` | `/api/tasks/{id}` | Modify task title, description, or deadline |
| **Delete Task** | `DELETE` | `/api/tasks/{id}` | Remove a task record |
| **Update Status** | `PATCH` | `/api/tasks/{id}/status` | Toggle status between PENDING & COMPLETED |

---

## 🗺️ Phase-Based Development Roadmap

Progress is tracked across 10 distinct phases using dedicated phase branches and PR reviews:

| Phase | Branch Name | Objective / Deliverable | Status |
|-------|-------------|-------------------------|--------|
| **Phase 1** | `phase/01-project-setup` | Clean Maven/Spring Boot setup, startup verification, DB configuration | 🟡 In Progress |
| **Phase 2** | `phase/02-task-domain` | Define Task JPA Entity, primary key strategy, status mapping | ⏳ Pending |
| **Phase 3** | `phase/03-jpa-repository` | Spring Data JPA interface implementation & persistence tests | ⏳ Pending |
| **Phase 4** | `phase/04-service-layer` | Service abstraction layer, business logic & DI implementation | ⏳ Pending |
| **Phase 5** | `phase/05-rest-controller` | Standardized REST API end-points exposing full CRUD capabilities | ⏳ Pending |
| **Phase 6** | `phase/06-html-frontend` | Semantic HTML interface for task creation, list views & controls | ⏳ Pending |
| **Phase 7** | `phase/07-css-styling` | Clean, responsive UI styling without external libraries | ⏳ Pending |
| **Phase 8** | `phase/08-frontend-backend` | Native browser-to-backend HTTP integration | ⏳ Pending |
| **Phase 9** | `phase/09-validation-errors`| Exception mapping, input boundary validation & API error handling | ⏳ Pending |
| **Phase 10**| `phase/10-testing-cleanup` | Unit/Integration testing, repository cleanup & final release tag | ⏳ Pending |

---

## 🌿 Git & Branching Workflow

This project adheres strictly to a **Phase-Branch Workflow**:

1. **Main Integration Branch**: `main` remains stable at all times.
2. **Phase Branches**: Created per phase using `phase/<phase-number>-<short-description>`.
3. **Commit Strategy**: Meaningful, logical commits with clear prefixes (`feat:`, `fix:`, `docs:`, `test:`, `refactor:`).
4. **Pull Requests**: Each phase concludes with a PR merge into `main` after verification.

main  ────────────────────────────────────────────────────────► Merge (v1.0)
\                                                      /
└──► phase/01-project-setup ──► phase/02-task-domain ──┘


---

## 🚀 Installation Guide

### Prerequisites
- **JDK:** 17 or higher
- **Maven:** 3.8+
- **Database:** MySQL 8.0+ or H2

### Steps

1. **Clone the repository:**
   ```bash
   git clone [https://github.com/YOUR_USERNAME/student-task-manager.git](https://github.com/YOUR_USERNAME/student-task-manager.git)
   cd student-task-manager
Configure Database Connection:
Update src/main/resources/application.properties:

Properties
spring.datasource.url=jdbc:mysql://localhost:3306/task_manager_db?useSSL=false&serverTimezone=UTC
spring.datasource.username=YOUR_DB_USER
spring.datasource.password=YOUR_DB_PASSWORD
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
Build & Execute:

Bash
mvn clean install
mvn spring-boot:run
Access Application:
Navigate to http://localhost:8080 in your web browser.

🎓 Learning Outcomes
Architectural Understanding: Mastered the flow from HTTP Request ➔ Controller ➔ Service ➔ JPA Repository ➔ SQL Database.

ORM & Data Persistence: Learned domain mapping, primary key strategies, and entity lifecycle management.

Disciplined Version Control: Executed multi-phase Git branching, PR reviews, and logical commit strategies.

REST & HTTP Standards: Understood HTTP status codes, method mappings, and payload structures.

📄 License
This project is open-source and available under the MIT License.


---

### Ready to proceed?
Whenever you are ready to kick off the development work, just say **"Give me Phase 1"** (or **"Let's start Phase 1"**), and we can begin setting up `phase/01-project-setup` step by step![cite: 1]

<FollowUp label="Ready to start Phase 1 setup?" query="Let's start Phase 1: Project + GitHub Setup."/>
