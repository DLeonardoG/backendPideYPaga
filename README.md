# El que pide paga - Backend

## Description

**"El que pide paga"** is a web application designed for managing restaurant orders. The backend, built with **Spring Boot**, provides a RESTful API that enables authentication, product management, and real-time order administration. **Spring Security with JWT** is used for authentication, and **MySQL** is used for data storage.

## Technologies & Tools

### Backend
- **Spring Boot 3.2.3** - Main framework for the backend
- **Java (JDK 17)** - Programming language
- **Spring Security with JWT** - Authentication and authorization
- **Spring Data JPA** - Persistence management
- **MySQL** - Relational database
- **Swagger** - API documentation
- **Maven** - Dependency management
- **Lombok** - Reducing boilerplate code

### Frontend
- **React.js** - UI framework
- **React Router** - Routing management
- **Axios** - API consumption
- **Tailwind CSS** - Modern and responsive styling
- **https://github.com/LauCarrillo16/Front-PideYPaga**
- **HASH: d737570017fc31d861b0ecd35252eca1c693a11a**

## Project Architecture

The system follows a well-structured layered architecture:
- **Controller Layer**: Exposes endpoints and handles HTTP requests.
- **Service Layer**: Contains business logic.
- **Repository Layer**: Interacts with the database using JPA.
- **Security Layer**: Implements JWT authentication and authorization.

## Installation & Configuration

### Prerequisites
- **Java JDK 17** installed
- **Maven** installed
- **MySQL** installed and configured
- **Node.js & npm** (to run the frontend)

### Database Configuration
1. Create the database in MySQL:
   ```sql
   CREATE DATABASE pideypaga;
   ```
2. Set up credentials in `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/pideypaga
   spring.datasource.username=root
   spring.datasource.password=your_password
   ```

### Running the Backend
1. Clone the repository:
   ```bash
   git clone https://github.com/DLeonardoG/backendPideYPaga/tree/main
   ```
2. Navigate to the project directory:
   ```bash
   cd backendPideYPaga
   ```
3. Build and run the project with Maven:
   ```bash
   mvn spring-boot:run
   ```

### Running the Frontend
1. Clone the repository:
   ```bash
   git clone https://github.com/LauCarrillo16/Front-PideYPaga/tree/main
   ```
2. Navigate to the project directory:
   ```bash
   cd Front-PideYPaga
   ```
3. Install dependencies:
   ```bash
   npm install
   ```
4. Start the application:
   ```bash
   npm start
   ```

## API Documentation

The backend includes API documentation generated with **Swagger**.

- **Swagger URL**: `http://localhost:8080/swagger-ui.html`
- **Available Endpoints**:

### Authentication
- **POST /api/login** - Log in and get JWT token.
- **POST /api/register** - Register a new user.

### Product Management
- **GET /api/product** - List all products.
- **POST /api/product** - Create a new product (admin only).
- **PUT /api/product/{id}** - Edit an existing product.
- **DELETE /api/product/{id}** - Delete a product.

### Order Management
- **POST /api/orders** - Create an order.
- **GET /api/orders** - List orders.
- **PUT /api/orders/{id}** - Update order status.

## Security & Authentication

**Spring Security with JWT** is implemented:
- Users must authenticate to access protected routes.
- Only **admins** can create, edit, and delete products.
- The JWT token is sent in the `Authorization Header` of each request.

Example of an authenticated request:
```bash
curl -H "Authorization: Bearer <TOKEN>" http://localhost:8080/api/product
```

## Database Schema

```plaintext
Users (id, name, email, password, role)
Products (id, name, description, price, stock)
Orders (id, user_id, total, status, date)
Orders_Products (id, order_id, product_id, quantity, subtotal)
```

## Error Handling & Exceptions

The system has centralized exception handling. Some common error codes:
- **400 BAD REQUEST** - Invalid request data.
- **401 UNAUTHORIZED** - User not authenticated.
- **403 FORBIDDEN** - User lacks sufficient permissions.
- **404 NOT FOUND** - Resource not found.

## Development Team

**Backend -> David Leonardo Gonzalez Gomez**  
**Frontend -> Laura Yuliana Carrillo Almeida**  
**Integration -> Michelle Dayanna Sanchez Angarita**  

---
**© 2025 El que pide paga** - All rights reserved.

