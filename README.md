# InstaGet

A Spring Boot web application built by **SparkTech** that demonstrates core Spring concepts including dependency injection, REST APIs, JPA, DTOs, and Swagger documentation.

---

## Tech Stack

- **Java 25**
- **Spring Boot 3.5.13**
- **Spring MVC** — REST controllers and Thymeleaf UI
- **Spring Data JPA** — database access
- **H2 Database** — in-memory/file-based database
- **Thymeleaf** — server-side HTML templates
- **Swagger (SpringDoc OpenAPI)** — API documentation
- **Maven** — build tool

---

## Project Structure

```
src/main/java/com/sparktech/InstaGet/
├── controllers/
│   ├── AppController.java       # UI endpoints (HomePage, Products, AI)
│   ├── ProductController.java   # REST API for products
│   ├── PaymentController.java   # REST API for payments
│   └── UserController.java      # REST API for users
├── services/
│   ├── AiService.java           # AI service interface
│   ├── GeminiService.java       # Gemini AI implementation
│   ├── ChatGPTService.java      # ChatGPT AI implementation
│   ├── ResponseGenerator.java   # AI response handler
│   ├── PaymentService.java      # Payment service interface
│   ├── UPI.java                 # UPI payment implementation
│   ├── Card.java                # Card payment implementation
│   ├── NetBanking.java          # NetBanking payment implementation
│   ├── PaymentManager.java      # Payment handler
│   ├── ProductService.java      # Product business logic
│   └── UserService.java         # User business logic
├── controllers/
├── Models/
│   ├── Product.java             # Product JPA entity
│   └── User.java                # User JPA entity
├── Repository/
│   ├── ProductRepository.java   # Product JPA repository
│   └── UserRepository.java      # User JPA repository
├── dtos/
│   ├── ProductDto.java          # Product data transfer object
│   └── UserDto.java             # User data transfer object (password excluded)
├── AppConfig.java               # @Configuration bean definitions
└── InstaGetApplication.java     # Application entry point
```

---

## Getting Started

### Prerequisites
- Java 25
- Maven (or use the included `mvnw.cmd`)

### Run the Application
```bash
.\mvnw.cmd clean spring-boot:run
```

The app starts on **port 8090**.

---

## Features & Endpoints

### UI Pages
| URL | Description |
|-----|-------------|
| `http://localhost:8090/HomePage` | Home page |
| `http://localhost:8090/products` | Products UI (add/delete via form) |
| `http://localhost:8090/ai?provider=gemini` | Gemini AI response |
| `http://localhost:8090/ai?provider=chatgpt` | ChatGPT AI response |

### Product REST API
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/products` | Get all products |
| GET | `/api/products/{id}` | Get product by ID |
| POST | `/api/products` | Create a product |
| PUT | `/api/products/{id}` | Update a product |
| DELETE | `/api/products/{id}` | Delete a product |

### User REST API
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/api/users` | Get all users |
| GET | `/api/users/{id}` | Get user by ID |
| POST | `/api/users` | Create a user |
| PUT | `/api/users/{id}` | Update a user |
| DELETE | `/api/users/{id}` | Delete a user |

### Payment API
| Method | URL | Description |
|--------|-----|-------------|
| GET | `/payment/upi` | Pay with UPI |
| GET | `/payment/card` | Pay with Card |
| GET | `/payment/netbanking` | Pay with NetBanking |
| GET | `/payment/default` | Pay with default method (UPI) |

---

## API Documentation (Swagger)

After running the app, open:
```
http://localhost:8090/swagger-ui/index.html
```

Raw OpenAPI JSON:
```
http://localhost:8090/v3/api-docs
```

---

## Database

Uses **H2 file-based database** (persists across restarts).

Access the H2 console at:
```
http://localhost:8090/h2-console
```
- JDBC URL: `jdbc:h2:file:./data/testdb`
- Username: `sa`
- Password: *(leave blank)*

---

## Spring Concepts Demonstrated

| Concept | Where Used |
|---------|------------|
| `@Service` | GeminiService, ChatGPTService, ProductService, UserService |
| `@Primary` | GeminiService, UPI — default bean when multiple exist |
| `@Qualifier` | AppController, PaymentController — pick specific bean |
| `@Autowired` | All controllers and services |
| `@Value` | ResponseGenerator — injects `ai.service.name` from properties |
| `@Configuration` + `@Bean` | AppConfig — defines Payment beans |
| `@Entity` + `@Repository` | Product, User — JPA persistence |
| DTO Pattern | ProductDto, UserDto — decouples API from DB layer |

---

## Sample Requests (PowerShell)

**Create a product:**
```powershell
Invoke-WebRequest -Uri "http://localhost:8090/api/products" -Method POST -ContentType "application/json" -Body '{"name":"Phone","price":999.99}'
```

**Create a user:**
```powershell
Invoke-WebRequest -Uri "http://localhost:8090/api/users" -Method POST -ContentType "application/json" -Body '{"name":"John","email":"john@example.com","password":"secret123"}'
```
