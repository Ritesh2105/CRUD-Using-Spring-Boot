# CRUD-Using-Spring-Boot
A basic Spring Boot REST API demonstrating CRUD operations (GET, POST, PUT, DELETE, PATCH) with in-memory user management. Designed as a foundation for adding OAuth2 security, database integration (MySQL/MongoDB), Swagger docs, and Docker. Ideal for beginners or anyone seeking a clean, extendable API starter.

# Spring Boot CRUD API Starter

A simple Spring Boot RESTful API demonstrating basic CRUD operations with GET, POST, PUT, DELETE, and PATCH endpoints.

This project is designed as a foundation to build upon with more advanced features like OAuth2 security, database integration (MySQL or MongoDB), Swagger API documentation, and Dockerization.

---

## Features

- In-memory User management with basic CRUD operations
- REST endpoints for:
  - Create User (`POST /api/users`)
  - Read Users (`GET /api/users`)
  - Read User by ID (`GET /api/users/{id}`)
  - Update User (`PUT /api/users/{id}`)
  - Partial Update User (`PATCH /api/users/{id}`)
  - Delete User (`DELETE /api/users/{id}`)
- Clean and simple code structure with Controller, Model, and Service layers
- Easy to extend and integrate with databases and security features

---

## Technologies Used

- Java 17+ (or your preferred version)
- Spring Boot (latest stable version)
- Maven
- Spring Web
- Spring Boot DevTools (for development convenience)

---

## Getting Started

### Prerequisites

- Java JDK 17 or higher installed
- Maven installed
- (Optional) Postman or curl for API testing

### Setup

1. **Clone the repository**

```bash
git clone https://github.com/yourusername/spring-boot-crud-api-starter.git
cd spring-boot-crud-api-starter
