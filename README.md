# 📝 Task Management Project

A Java Spring Boot project exposing a **REST API** to manage tasks — following clean architecture principles using DTOs, service layers, and future-ready features like role-based access control and user management.

---

## ✅ Project Stages

### **🔹 Stage 1: Basic Task CRUD**

* One table: `tasks`
* Fields: `id`, `description`, `date`
* Full **Create**, **Read**, **Update**, and **Delete** operations via REST endpoints
* Technologies:

  * Spring Boot
  * Spring Data JPA
  * PostgreSQL

---

### **🔹 Stage 2: Task Status via Enum**

* Added an `enum` type `TaskStatus` with values:

  * `INITIATION`, `PLANNING`, `EXECUTION`, `DONE`
* Enum is mapped to the database using `@Enumerated(EnumType.STRING)`

---

### **🔹 Stage 3: User Assignment**

* A new `User` entity is introduced
* Each task is assigned to a user: **"Who should do what"**
* Basic relation: `OneToMany` or `ManyToOne` between `Task` and `User`

---

## 🧱 Architecture Overview

Follows a **layered architecture** with separation of concerns:

| Layer           | Responsibility                                      |
| --------------- | --------------------------------------------------- |
| **Entity**      | JPA classes mapped to DB tables (`@Entity`)         |
| **Model**       | DTOs (Data Transfer Objects) for REST communication |
| **Repository**  | Interfaces extending `JpaRepository` for DB access  |
| **Service**     | Business logic layer, task/user processing          |
| **Transformer** | Converters between `Entity` ↔ `Model`               |
| **Controller**  | REST endpoints for frontend/API interaction         |

---

## 🔐 Future Stage: Security, Frontend  & Access Control

Planned features include:
* Frontend with React:

    * A responsive user interface for managing tasks
    * Integration with the Spring Boot REST API
    * Pages for login, task dashboard, and user roles

* Role-based access control (RBAC):

  * Roles: `ADMIN`, `USER`, `MANAGER`, etc.
  * Define who can create/delete/assign tasks
* Secure endpoints using:

  * Spring Security
  * JWT (JSON Web Tokens) or Session-based auth
* Add **Company** entity for multi-tenant support

  * Link tasks and users to specific companies

---

## 🛍️ Development Philosophy

This project follows a **top-down approach** — starting from the use cases and business needs, then designing supporting layers (entities, services, DB).

Not a bottom-up approach (code-first), but rather focused on functionality, clarity, and extensibility :)

---

## 🔧 Tech Stack

* Java 17+
* Spring Boot
* Spring Data JPA
* PostgreSQL
* Lombok
* Jackson
* Postman (for testing)

---

## 🚀 Getting Started

1. Clone the repo
2. Configure DB in `application.properties`
3. Run the application
4. Use Postman or frontend to interact with APIs
