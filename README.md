# Library & Staff Management System

A full-stack management dashboard combining a library catalog and a staff
attendance system, built as one integrated app with a Spring Boot + MongoDB
backend and a vanilla JavaScript frontend.

## Preview

*(Add 1-2 screenshots from the `screenshot/` folder here, e.g.)*
```markdown
![Dashboard - Books tab](screenshot/books-tab.png)
![Dashboard - Staff tab](screenshot/staff-tab.png)
```

## Features

**Library catalog**
- Add a book (name + type/genre)
- Borrow / return a book, with a live "Available" / "Borrowed" status badge
- Delete a book from the catalog

**Staff management**
- Add an employee (name + department)
- Clock in / clock out, with in-time and out-time logged per employee
- Remove an employee

Both tabs live in a single dashboard and talk to their own REST resource
independently.

## Tech stack

- **Backend:** Java, Spring Boot 3.2.4 (`spring-boot-starter-web`,
  `spring-boot-starter-data-mongodb`)
- **Database:** MongoDB
- **Frontend:** Vanilla HTML/CSS/JavaScript (no framework, no build step —
  just `fetch()` calls against the REST API)

## API endpoints

| Method | Endpoint                          | Description              |
|--------|------------------------------------|---------------------------|
| GET    | `/api/books`                      | List all books            |
| POST   | `/api/books`                      | Add a book                |
| PUT    | `/api/books/{id}/borrow`          | Mark a book as borrowed   |
| PUT    | `/api/books/{id}/return`          | Mark a book as returned   |
| DELETE | `/api/books/{id}`                 | Delete a book             |
| GET    | `/api/employees`                  | List all employees        |
| POST   | `/api/employees`                  | Add an employee           |
| PUT    | `/api/employees/{id}/clock-in`    | Log clock-in time         |
| PUT    | `/api/employees/{id}/clock-out`   | Log clock-out time        |
| DELETE | `/api/employees/{id}`             | Remove an employee        |

## Setup

**Prerequisites:** Java 17+, Maven, and a running MongoDB instance (local or
a connection string to one).

1. Configure your MongoDB connection in
   `src/main/resources/application.properties`
2. Run the backend:
   ```bash
   ./mvnw spring-boot:run
   ```
   This starts the API on `http://localhost:8080`
3. Open `index.html` directly in a browser (it calls the API at
   `localhost:8080` directly — no separate frontend server needed)

## Project structure

```
library-staff-management-system/
├── pom.xml
├── src/main/java/com/example/library/
│   ├── LibraryApplication.java
│   ├── controller/
│   │   ├── BookController.java
│   │   └── EmployeeController.java
│   ├── model/
│   │   ├── Book.java
│   │   └── Employee.java
│   └── repository/
│       ├── BookRepository.java
│       └── EmployeeRepository.java
├── src/main/resources/application.properties
├── index.html                # frontend dashboard
├── screenshot/                # preview images
└── README.md
```

## Notes

- `bbbooks.json` / `eeemployee.json` are sample seed data — useful for
  quickly populating the catalog and staff list to test with.
- This project runs locally only; the frontend is hardcoded to
  `localhost:8080`, so it isn't deployed anywhere.

## Possible extensions

- Add authentication so only staff can access the dashboard
- Move the hardcoded `localhost:8080` API URL into a config value so the
  frontend can point at a deployed backend
- Add due dates and overdue tracking for borrowed books
- Add pagination once the catalog/staff list grows large
