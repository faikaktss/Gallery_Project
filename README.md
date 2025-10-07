# 🎓 Graduation Project Final Part

![Java](https://img.shields.io/badge/Java-17-blue?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.0-green?logo=springboot)
![JWT Auth](https://img.shields.io/badge/JWT-Enabled-yellow?logo=jsonwebtokens)
![Maven](https://img.shields.io/badge/Maven-Build-red?logo=apachemaven)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-blue?logo=postgresql)

---

## 🏆 Overview

**Graduation Project Final Part** is a professional full-stack backend solution for a car dealership (gallerist) management system. Designed in Java using Spring Boot, it provides robust authentication, secure JWT-based APIs, multi-entity management, and real-time currency integration. The architecture is modular, scalable, and production-ready, following clean code and industry best practices.

---

## 🌈 Table of Contents

- [Features](#features)
- [Architecture](#architecture)
- [Entity Structure](#entity-structure)
- [Authentication & Security](#authentication--security)
- [API Endpoints](#api-endpoints)
- [DTOs & Models](#dtos--models)
- [Exception Handling](#exception-handling)
- [Currency Integration](#currency-integration)
- [How to Run](#how-to-run)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Contributing](#contributing)
- [License](#license)

---

## 🚀 Features

- 🔐 **JWT Authentication:** Secure login, registration, token refresh, and stateless session management.
- 🏢 **Gallerist & Car Management:** CRUD operations for cars, customers, gallerists, accounts, addresses, and more.
- 💶 **Live Currency Rates:** Integrates with TCMB API for USD/TRY exchange rates.
- 🧩 **Robust Service Layer:** Clean separation of concerns, with DTOs, repositories, and services.
- 🦺 **Global Error Handling:** Custom exceptions, validation, and detailed API error responses.
- 🏗️ **Professional Codebase:** Follows SOLID principles, clean architecture, and best practices.

---

## 🏛 Architecture

```
Spring Boot ⟶ Controllers ⟶ Services ⟶ Repositories ⟶ Entities (JPA) ⟶ PostgreSQL
            ⟶ Security (JWT, BCrypt) ⟶ Exception Handling
```

- **Controllers:** RESTful endpoints for all entities.
- **Services & Impl:** Business logic, validation, and orchestration.
- **Repositories:** Interfaces for JPA database operations.
- **Models:** Persistent entities mapped to DB tables.
- **DTOs:** Data Transfer Objects for API requests/responses.
- **SecurityConfig:** Spring Security + JWT integration.
- **Exception & Handler:** Custom error management.

---

## 🗂️ Entity Structure

Entities (see **Model** folder):

- `Account`
- `Address`
- `Car`
- `Customer`
- `Gallerist`
- `GalleristCar`
- `SaledCar`
- `User`
- `ResfrehToken` *(for refresh tokens)*

Each entity has a corresponding DTO for input/output operations.  
*(See Screenshot 1 for DTOs, Screenshot 2 for Models)*

---

## 🛡 Authentication & Security

- **Spring Security** + **JWT Filter** for stateless authentication.
- Endpoints:
  - `/register` : User registration
  - `/authenticate` : Login, receive JWT
  - `/refreshToken` : Get new JWT with refresh token

Security is enforced globally, with exceptions and error codes for invalid credentials, expired tokens, and unauthorized access.

---

## 📲 API Endpoints

Examples:

| Entity         | Endpoint                                | Method    | Description            |
|----------------|-----------------------------------------|-----------|------------------------|
| Auth           | `/register`, `/authenticate`            | POST      | Register/Login         |
| Account        | `/rest/api/account/save`                | POST      | Create Account         |
| Address        | `/rest/api/address/save`                | POST      | Create Address         |
| Car            | `/rest/api/car/save`                    | POST      | Add Car                |
| Customer       | `/rest/api/customer/save`               | POST      | Add Customer           |
| Gallerist      | `/rest/api/gallerist/save`              | POST      | Add Gallerist          |
| GalleristCar   | `/rest/api/GalleristCar/save`           | POST      | Link Gallerist & Car   |
| Currency       | `/rest/api/currency-rest/currency-rest` | GET       | Currency rates         |

Authorization is enforced except for authentication endpoints.

---

## 📦 DTOs & Models

All requests/responses use DTOs for decoupled API communication.

**DTOs:**  
- Example: `DtoCar`, `DtoAccount`, `DtoGalleristCarIU`  
- See Screenshot 1 for all available DTOs.

**Models:**  
- Entities mapped to database tables.
- Example: `Car.java`, `Account.java`, `GalleristCar.java`  
- See Screenshot 2 for Models.

---

## 🛑 Exception Handling

- Custom exceptions (e.g., `BaseException`)
- Error messages with codes and localization (see `MessageType` enum)
- Global exception handler for API errors
- Validation of input using `@Valid` annotation

---

## 💱 Currency Integration

- Fetches USD exchange rates from TCMB API
- Endpoints return currency rates for given dates
- Secure API key usage in production

---

## 🔧 How to Run

1. **Clone the repository**
   ```bash
   git clone https://github.com/faikaktss/Graduation_Project_Final_Part.git
   cd Graduation_Project_Final_Part
   ```
2. **Configure application properties**  
   Set DB connection, JWT secret, and other configs in `application.properties`.

3. **Build and run**
   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

4. **Access API**  
   Use tools like Postman or Curl to interact with endpoints.

---

## 🛠 Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA**
- **Spring Security**
- **JWT (Json Web Token)**
- **Maven**
- **PostgreSQL**
- **Lombok**

---

## 📁 Project Structure

```
src/
├── main/
│   ├── java/com/faik/
│   │   ├── Config/
│   │   ├── Controller/
│   │   ├── Dto/
│   │   ├── enums/
│   │   ├── Exception/
│   │   ├── Handler/
│   │   ├── Jwt/
│   │   ├── Model/
│   │   ├── Repository/
│   │   ├── Service/
│   │   ├── Starter/
│   └── resources/
│       └── application.properties
```
- **Screenshot 1:** ![image1](image1) (DTOs Directory)
- **Screenshot 2:** ![image2](image2) (Model Directory)
- **Screenshot 3:** ![image3](image3) (Service Interfaces)

---

## 🤝 Contributing

Pull requests and issue reports are welcome!
Please follow [Conventional Commits](https://www.conventionalcommits.org/) and write clean, well-documented code.

---

## 📄 License

This project is licensed under the MIT License.

---

## 📧 Contact

For questions or support, contact [faikaktss](https://github.com/faikaktss).

---

> **Professional, scalable, and secure — built for your graduation and beyond!**
