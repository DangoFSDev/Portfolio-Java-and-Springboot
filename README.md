# E-Commerce Order System

# TODO: In-Progress (Finalization)

Spring Boot application implementing Clean Architecture with Oracle DB, Docker, and CI pipeline.

---

## 🚀 Tech Stack

- Java 17+
- Spring Boot
- Oracle XE (Docker)
- Maven
- Flyway (DB migrations)
- Docker / Docker Compose
- SpotBugs (static analysis)

---

## 📁 Project Structure

```
src/
├── domain/ # Business logic (pure Java)
├── application/ # Use cases
├── interface/ # Controllers (REST)
├── infrastructure/ # DB, JPA, config
```

---

## ⚙️ Requirements

Install the following:

- Java 17+
- Maven 3.9+
- Docker + Docker Compose

Verify:

```bash
java -version
mvn -version
docker -v
docker-compose -v
```

---

## 🛠️ Setup

### 1. Clone the repository

```bash
git clone https://github.com/your-repo/ecommerce.git
cd ecommerce
```

// TODO: Beautify

### 2. Configure environment (optional)

Default DB config (Docker):

```
SPRING_DATASOURCE_URL=jdbc:oracle:thin:@localhost:1521/XEPDB1
SPRING_DATASOURCE_USERNAME=appuser
SPRING_DATASOURCE_PASSWORD=apppass
```

---

### ▶️ Run the Application

Option 1: Docker (Recommended)

```
docker-compose up --build
```

Access:

```
http://localhost:8080
```

Option 2: Local (without Docker)
Start Oracle manually (or use existing DB)

Then:

```
mvn clean install
mvn spring-boot:run
```

---

### 🗄️ Database

Oracle XE via Docker
Flyway migrations auto-run on startup

Location:

```
src/main/resources/db/migration/
```

### 🔐 Authentication

Basic Auth (for now)

```
Roles:
- USER
- ADMIN
```

### Example:

```
/admin/** → ADMIN only
/users/** → USER, ADMIN
```

---

## 📡 API Endpoints

### Auth

```
POST /auth/register
POST /auth/login
```

### Orders

```
POST /orders/checkout
GET /orders/{id}
```

### Products

```
GET /products
GET /products/{id}
```

---

### 🧪 Running Tests

Run all tests

```
mvn test
Run with full build
mvn clean install
```

### Test coverage (if configured)

```
mvn verify
```

## 🔍 Static Analysis

### Run SpotBugs:

```
mvn spotbugs:check
```

## 🐳 Docker Services

```
oracle-db → Oracle XE
app → Spring Boot app

```

### Stop containers:

```
docker-compose down
```

### Remove volumes:

```
docker-compose down -v
```

---

## ⚠️ Common Issues

### Port already in use

Change port in:

```
application.yml
```

### Oracle not ready

Wait ~30–60 seconds for DB container to initialize.

### Build fails

Run:

```
mvn clean install -U
```