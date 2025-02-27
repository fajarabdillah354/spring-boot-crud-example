# spring-boot-crud-example

# Spring Boot CRUD Example with JWT Authentication

This project demonstrates a basic CRUD (Create, Read, Update, Delete) application using Spring Boot with JWT (JSON Web Token) authentication.

## Features

- CRUD operations for Product entity
- JWT Authentication
- MySQL database integration
- RESTful API endpoints
- Spring Security implementation

## Technologies Used

- Spring Boot 2.3.4.RELEASE
- Java 8
- MySQL Database
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- Maven

## Prerequisites

- JDK 1.8 or later
- Maven 3.x
- MySQL Server
- Your favorite IDE (IntelliJ IDEA/Eclipse/VS Code)

## Project Setup

1. Clone the repository:
```bash
git clone https://github.com/fajarabdillah354/spring-boot-crud-example.git
```

2. Configure MySQL database in `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

3. Add JWT configuration in `application.properties`:
```properties
jwt.secret=your_jwt_secret
jwt.expiration=86400000
```

4. Build the project:
```bash
mvn clean install
```

5. Run the application:
```bash
mvn spring-boot:run
```

## API Endpoints

### Authentication
- POST `/api/auth/signup` - Register new user
- POST `/api/auth/login` - Login user

### Products
- GET `/api/v1/product` - Get all products
- GET `/api/v1/product/{id}` - Get product by ID
- POST `/api/v1/product` - Create new product
- PUT `/api/v1/product` - Update product
- DELETE `/api/v1/product/{id}` - Delete product

## Request/Response Examples

### Register User
```json
POST /api/auth/signup
{
    "username": "user1",
    "email": "user1@example.com",
    "password": "password123"
}
```

### Login
```json
POST /api/auth/login
{
    "username": "user1",
    "password": "password123"
}
```

### Create Product
```json
POST /api/v1/product
{
    "name": "Product Name",
    "quantity": 10,
    "price": 100.00
}
```

## Security

- All endpoints except `/api/auth/signup` and `/api/auth/login` require authentication
- JWT token must be included in the Authorization header for protected endpoints
- Token format: `Bearer <token>`

## Project Structure

```
src/main/java/com/example/crud/
├── config/
│   ├── SecurityConfig.java
│   └── JwtConfig.java
├── controller/
│   ├── AuthController.java
│   └── ProductController.java
├── model/
│   ├── Product.java
│   └── User.java
├── repository/
│   ├── ProductRepository.java
│   └── UserRepository.java
├── security/
│   ├── JwtTokenUtil.java
│   └── JwtRequestFilter.java
└── SpringBootCrudExampleApplication.java
```

## Development

To add new features or fix bugs:

1. Create a new branch
2. Make your changes
3. Submit a pull request

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/amazingFeature`)
3. Commit your changes (`git commit -m 'Add some amazingFeature'`)
4. Push to the branch (`git push origin feature/amazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Fajar Abdillah - [GitHub](https://github.com/fajarabdillah354)

Project Link: [https://github.com/fajarabdillah354/spring-boot-crud-example](https://github.com/fajarabdillah354/spring-boot-crud-example)
