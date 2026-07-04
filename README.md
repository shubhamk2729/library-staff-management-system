# 📚 Library & Staff Management System

A full-stack management system for tracking library books and staff attendance, built with a Spring Boot REST API backend and a MongoDB database, with a vanilla JS frontend that talks directly to the API.

## Features

**Book Management**
- Add and remove books from the catalog, each tagged with a name and type
- Mark books as borrowed / returned with a single action
- Live view of the full catalog and its borrow status

**Staff Attendance**
- Add and remove employee records with name and department
- **Clock-in / clock-out system** — timestamps are generated server-side (`yyyy-MM-dd hh:mm a` format) whenever a staff member clocks in or out, so records reflect actual system time rather than manual entry
- Track each employee's current shift status at a glance

## Tech Stack

- **Backend:** Java, Spring Boot, Spring Web (REST controllers)
- **Database:** MongoDB (via Spring Data MongoDB)
- **Frontend:** HTML, CSS, vanilla JavaScript — calls the REST API directly with `fetch`, no framework
- **Build tool:** Maven (`pom.xml`)

## API Endpoints

**Books** (`/api/books`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/books` | List all books |
| POST | `/api/books` | Add a new book |
| DELETE | `/api/books/{id}` | Remove a book |
| PUT | `/api/books/{id}/borrow` | Mark a book as borrowed |
| PUT | `/api/books/{id}/return` | Mark a book as returned |

**Employees** (`/api/employees`)
| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/employees` | List all employees |
| POST | `/api/employees` | Add a new employee |
| DELETE | `/api/employees/{id}` | Remove an employee |
| PUT | `/api/employees/{id}/clock-in` | Clock in (server-timestamped) |
| PUT | `/api/employees/{id}/clock-out` | Clock out (server-timestamped) |

## Getting Started

**Prerequisites:** Java, Maven, and a running MongoDB instance on `localhost:27017`

1. Clone the repo:
   ```bash
   git clone https://github.com/shubhamk2729/library-staff-management-system.git
   ```
2. Start MongoDB locally (default connection expected at `mongodb://localhost:27017/librarydb`)
3. Run the Spring Boot app:
   ```bash
   mvn spring-boot:run
   ```
4. Open `index.html` (in the `frontend` folder) in your browser — it connects directly to the API at `localhost:8080`

## Project Structure

```
library-staff-management-system/
├── pom.xml
├── src/
│   └── main/
│       ├── java/com/example/library/
│       │   ├── LibraryApplication.java
│       │   ├── controller/
│       │   │   ├── BookController.java
│       │   │   └── EmployeeController.java
│       │   ├── model/
│       │   │   ├── Book.java
│       │   │   └── Employee.java
│       │   └── repository/
│       │       ├── BookRepository.java
│       │       └── EmployeeRepository.java
│       └── resources/
│           └── application.properties
├── frontend/
│   └── index.html
└── screenshot/
```

## Project Documentation

This project also includes a full **[Project Report](./PROJECT%20REPORT.docx)** covering design and implementation details, plus a `screenshot/` folder documenting the working application.

## Future Improvements

- Add authentication so book/staff management isn't open to anyone with API access
- Input validation on the frontend and backend (currently trusts client input directly)
- Borrow history / due dates instead of a simple boolean borrowed flag
- Shift duration calculation from clock-in/clock-out timestamps

---
Built by [Shubham Krishna](https://github.com/shubhamk2729)
