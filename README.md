# 💰 Expense Tracker REST API

A RESTful Expense Tracker API built using **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. This project enables users to manage their daily expenses through well-designed REST APIs while following clean architecture principles and industry best practices.

The application demonstrates concepts such as layered architecture, DTO pattern, validation, exception handling, and interactive API documentation using Swagger.

---

# 🚀 Features

* ➕ Create a new expense
* 📋 Retrieve all expenses
* 🔍 Retrieve an expense by ID
* 📝 Update an existing expense
* ❌ Delete an expense
* 🏷️ Search expenses by category
* 📌 Search expenses by title
* 📅 Search expenses by date
* ✅ Input validation using Bean Validation
* 🚨 Global exception handling with custom exceptions
* 🔄 DTO pattern with Mapper for clean API responses
* 📖 Interactive API documentation using Swagger UI
* 🗄️ Automatic table creation using Hibernate
* 🔗 MySQL database integration
* 🏗️ Clean layered architecture (Controller → Service → Repository)

---

# 🛠️ Tech Stack

* Java 21
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL
* Maven
* Swagger / OpenAPI
* Postman
* Git & GitHub
* VS Code

---

# 📁 Project Structure

```text
src
└── main
    ├── java
    │   └── com.divija.expensetracker
    │       ├── config
    │       ├── controller
    │       ├── dto
    │       ├── entity
    │       ├── exception
    │       ├── mapper
    │       ├── repository
    │       ├── service
    │       └── ExpenseTrackerApplication.java
    │
    └── resources
        └── application.properties
```

---

# 🏛️ Architecture

```text
                 HTTP Request
                       │
                       ▼
               ExpenseDTO (@Valid)
                       │
                       ▼
                ExpenseController
                       │
                       ▼
                 ExpenseMapper
                 DTO ↔ Entity
                       │
                       ▼
                 ExpenseService
                Business Logic
                       │
                       ▼
              ExpenseRepository
                       │
                       ▼
                  Hibernate
                       │
                       ▼
                     MySQL
```

---

# ⚙️ Database Configuration

Create the database:

```sql
CREATE DATABASE expense_tracker;
```

Configure your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

> Replace `YOUR_PASSWORD` with your own MySQL password before running the project.

---

# 📌 API Endpoints

| Method | Endpoint                        | Description            |
| ------ | ------------------------------- | ---------------------- |
| POST   | `/expenses`                     | Create a new expense   |
| GET    | `/expenses`                     | Retrieve all expenses  |
| GET    | `/expenses/{id}`                | Retrieve expense by ID |
| PUT    | `/expenses/{id}`                | Update an expense      |
| DELETE | `/expenses/{id}`                | Delete an expense      |
| GET    | `/expenses/category/{category}` | Search by category     |
| GET    | `/expenses/title/{title}`       | Search by title        |
| GET    | `/expenses/date/{date}`         | Search by date         |

---

# 📖 Swagger API Documentation

Once the application is running, open:

```text
http://localhost:8081/swagger-ui/index.html
```

Swagger provides interactive API documentation where every endpoint can be tested directly from the browser without using Postman.

---

# ▶️ Running the Project

Clone the repository:

```bash
git clone https://github.com/your-username/Expense-Tracker-REST-API.git
```

Navigate into the project:

```bash
cd Expense-Tracker-REST-API
```

Run the application:

```bash
./mvnw spring-boot:run
```

or run the main application class from your IDE.

---

# 📚 Concepts Practiced

* Spring Boot
* RESTful API Development
* Layered Architecture
* Dependency Injection
* Spring Data JPA
* Hibernate ORM
* MySQL Integration
* Bean Validation
* Global Exception Handling
* DTO Pattern
* Object Mapping
* Java Streams
* ResponseEntity
* Swagger / OpenAPI Documentation
* Maven
* Git & GitHub

---

# 🎯 Project Status

| Feature                   | Status     |
| ------------------------- | ---------- |
| Spring Boot Setup         | ✅          |
| MySQL Integration         | ✅          |
| Layered Architecture      | ✅          |
| Repository Layer          | ✅          |
| Service Layer             | ✅          |
| Controller Layer          | ✅          |
| CRUD Operations           | ✅          |
| Search by Category        | ✅          |
| Search by Title           | ✅          |
| Search by Date            | ✅          |
| Bean Validation           | ✅          |
| Global Exception Handling | ✅          |
| DTO Pattern               | ✅          |
| Object Mapper             | ✅          |
| Swagger Documentation     | ✅          |
| Pagination                | 🚧 Planned |
| Sorting                   | 🚧 Planned |

---

# 👩‍💻 Author

**Divija P**

Built as part of my Spring Boot backend learning journey to strengthen my understanding of REST API development, Spring Boot architecture, and backend engineering concepts while preparing for technical interviews.

---

⭐ If you found this project helpful, feel free to star the repository!
