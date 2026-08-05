# 💰 Expense Tracker REST API

A RESTful Expense Tracker API built using **Spring Boot**, **Spring Data JPA**, **Hibernate**, and **MySQL**. This project allows users to manage their daily expenses through REST APIs and demonstrates a clean layered architecture following industry best practices.

---

## 🚀 Features

- ➕ Add a new expense
- 📋 Retrieve all expenses
- 🗄️ Automatic table creation using Hibernate
- 🔗 MySQL database integration
- 🏗️ Layered Architecture (Controller → Service → Repository)
- 🧪 API testing using Postman

> 🚧 Upcoming Features
>
> - Get Expense by ID
> - Update Expense
> - Delete Expense
> - Input Validation
> - Global Exception Handling
> - Swagger API Documentation
> - DTO Pattern
> - Logging

---

## 🛠️ Tech Stack

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- Maven
- Postman
- Git & GitHub
- VS Code

---

## 📁 Project Structure

```
src
└── main
    ├── java
    │   └── com.divija.expensetracker
    │       ├── controller
    │       ├── entity
    │       ├── repository
    │       ├── service
    │       └── ExpenseTrackerApiApplication.java
    │
    └── resources
        └── application.properties
```

---

## 🏛️ Architecture

```
                HTTP Request
                      │
                      ▼
             ExpenseController
                      │
                      ▼
              ExpenseService
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

## ⚙️ Database Configuration

Create a MySQL database:

```sql
CREATE DATABASE expense_tracker;
```

Configure the following in `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/expense_tracker
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

> Replace `YOUR_PASSWORD` with your local MySQL password.

---

## 📌 API Endpoints

### Create Expense

**POST**

```
/expenses
```

Sample Request

```json
{
    "title": "Pizza",
    "amount": 450,
    "category": "Food",
    "date": "2026-08-05",
    "description": "Dinner with friends"
}
```

---

### Get All Expenses

**GET**

```
/expenses
```

Sample Response

```json
[
  {
    "id": 1,
    "title": "Pizza",
    "amount": 450.0,
    "category": "Food",
    "date": "2026-08-05",
    "description": "Dinner with friends"
  }
]
```

---

## ▶️ Running the Project

Clone the repository:

```bash
git clone https://github.com/your-username/Expense-Tracker-REST-API.git
```

Navigate to the project directory:

```bash
cd Expense-Tracker-REST-API
```

Run the application:

```bash
./mvnw spring-boot:run
```

Or simply run the main class from your IDE.

---

## 📚 Concepts Practiced

- Spring Boot
- REST APIs
- Layered Architecture
- Dependency Injection
- Spring Data JPA
- Hibernate ORM
- MySQL Integration
- Constructor Injection
- Maven
- Git & GitHub
- Postman API Testing

---

## 🎯 Project Status

| Feature | Status |
|----------|--------|
| Spring Boot Setup | ✅ |
| MySQL Integration | ✅ |
| Expense Entity | ✅ |
| Repository Layer | ✅ |
| Service Layer | ✅ |
| Controller Layer | ✅ |
| POST API | ✅ |
| GET All API | ✅ |
| GET by ID | 🚧 |
| UPDATE API | 🚧 |
| DELETE API | 🚧 |
| Validation | 🚧 |
| Exception Handling | 🚧 |
| Swagger | 🚧 |
| DTO Pattern | 🚧 |

---

## 👩‍💻 Author

**Divija P**

Built as part of my Spring Boot backend learning journey and interview preparation.

---
⭐ If you found this project helpful, feel free to star the repository!