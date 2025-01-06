# Role-Based Access Booking System
This project is a full-stack application that demonstrates a role-based access control system, implemented with a Spring Boot backend, ReactJS frontend, and a MongoDB database.

## Features
- Role-based user management with different access levels (Admin, Client, Partner)
- Authentication and authorization using JWT (JSON Web Tokens)
- MongoDB as the database for storing user data, bookings, and services.
- RESTful API for interacting with the backend.
- Frontend built using ReactJS

## Tech Stack
- Backend: Spring Boot (Java)
- Frontend: ReactJS
- Database: MongoDB (Database name: roleBasedSystem)
- Authentication: JWT (JSON Web Tokens)

## Architecture

The system follows a **Layered Architecture** design pattern, where the application is divided into separate layers that can be managed and maintained independently. Each layer has a specific role in the application, making it easier to maintain and scale.

### Architecture Includes:
- **Controllers**: Handle HTTP requests and route them to appropriate services.
- **Services**: Contain business logic and interact with repositories to perform actions on data.
- **Repositories**: Handle interactions with the database (MongoDB) using Spring Data.
- **Entities**: Represent the database tables and structure.


