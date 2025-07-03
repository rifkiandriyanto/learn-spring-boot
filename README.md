# Software Engineer API - User Guide

A RESTful API for managing software engineers built with Spring Boot and PostgreSQL.

## 🚀 Getting Started

### Prerequisites
- Docker and Docker Compose installed on your system
- Java 17 or higher (for development)
- API testing tool (Postman, Thunder Client, or curl)

### Quick Setup

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd learn-spring
   ```

2. **Start the application with Docker**
   ```bash
   docker-compose up -d
   ```

3. **Verify the application is running**
   ```bash
   curl http://localhost:8080/
   ```
   You should see: `Hello world learn spring boot`

## 📋 API Endpoints

### Base URL
```
http://localhost:8080/api/v1/software-engineers
```

### Available Operations

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/` | Welcome message |
| GET | `/api/v1/software-engineers` | Get all software engineers |
| GET | `/api/v1/software-engineers/{id}` | Get engineer by ID |
| POST | `/api/v1/software-engineers` | Create new engineer |
| PUT | `/api/v1/software-engineers/{id}` | Update engineer by ID |
| DELETE | `/api/v1/software-engineers/{id}` | Delete engineer by ID |

## 🔧 API Usage Examples

### 1. Get All Engineers
```http
GET http://localhost:8080/api/v1/software-engineers
```

**Response:**
```json
[
  {
    "id": 1,
    "name": "John Doe",
    "techStack": "Java, Spring Boot, PostgreSQL",
    "createdAt": "2024-01-15T10:30:00",
    "updatedAt": "2024-01-15T10:30:00"
  }
]
```

### 2. Get Engineer by ID
```http
GET http://localhost:8080/api/v1/software-engineers/1
```

**Response:**
```json
{
  "id": 1,
  "name": "John Doe",
  "techStack": "Java, Spring Boot, PostgreSQL",
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T10:30:00"
}
```

### 3. Create New Engineer
```http
POST http://localhost:8080/api/v1/software-engineers
Content-Type: application/json

{
  "name": "Jane Smith",
  "techStack": "JavaScript, React, Node.js, MongoDB"
}
```

**Response:**
```json
{
  "id": 2,
  "name": "Jane Smith",
  "techStack": "JavaScript, React, Node.js, MongoDB",
  "createdAt": "2024-01-15T11:00:00",
  "updatedAt": "2024-01-15T11:00:00"
}
```

### 4. Update Engineer
```http
PUT http://localhost:8080/api/v1/software-engineers/1
Content-Type: application/json

{
  "name": "John Doe Updated",
  "techStack": "Java, Spring Boot, PostgreSQL, Docker, Kubernetes"
}
```

**Response:**
```json
{
  "id": 1,
  "name": "John Doe Updated",
  "techStack": "Java, Spring Boot, PostgreSQL, Docker, Kubernetes",
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T11:15:00"
}
```

### 5. Delete Engineer
```http
DELETE http://localhost:8080/api/v1/software-engineers/1
```

**Response:**
```json
"Software Engineer with id 1 has been deleted successfully"
```

## 📝 Request/Response Format

### Create/Update Request Body
```json
{
  "name": "Engineer Name",        // Required, 2-100 characters
  "techStack": "Technologies"     // Optional, max 500 characters
}
```

### Response Body
```json
{
  "id": 1,
  "name": "Engineer Name",
  "techStack": "Technologies",
  "createdAt": "2024-01-15T10:30:00",
  "updatedAt": "2024-01-15T10:30:00"
}
```

## ⚠️ Error Responses

### Validation Error (400 Bad Request)
```json
{
  "status": 400,
  "message": "Validation failed",
  "errors": {
    "name": "Name is required"
  },
  "path": "/api/v1/software-engineers"
}
```

### Not Found Error (404 Not Found)
```json
{
  "status": 404,
  "message": "Software Engineer with id 999 not found",
  "path": "/api/v1/software-engineers/999",
  "timestamp": "2024-01-15T11:30:00"
}
```

### Server Error (500 Internal Server Error)
```json
{
  "status": 500,
  "message": "Internal server error: Database connection failed",
  "path": "/api/v1/software-engineers",
  "timestamp": "2024-01-15T11:30:00"
}
```

## 🧪 Testing with Different Tools

### Using cURL

**Get all engineers:**
```bash
curl -X GET http://localhost:8080/api/v1/software-engineers
```

**Create new engineer:**
```bash
curl -X POST http://localhost:8080/api/v1/software-engineers \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Alice Johnson",
    "techStack": "Python, Django, PostgreSQL, AWS"
  }'
```

**Update engineer:**
```bash
curl -X PUT http://localhost:8080/api/v1/software-engineers/1 \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Alice Johnson Updated",
    "techStack": "Python, Django, PostgreSQL, AWS, Docker"
  }'
```

**Delete engineer:**
```bash
curl -X DELETE http://localhost:8080/api/v1/software-engineers/1
```

### Using Postman

1. Import the collection or create requests manually
2. Set the base URL: `http://localhost:8080`
3. For POST/PUT requests:
   - Set Content-Type header to `application/json`
   - Add request body in JSON format

## 🔍 Data Validation Rules

| Field | Rules |
|-------|-------|
| name | Required, 2-100 characters |
| techStack | Optional, max 500 characters |

## 🐳 Docker Commands

### Start the application
```bash
docker-compose up -d
```

### Stop the application
```bash
docker-compose down
```

### View logs
```bash
docker-compose logs -f app
```

### Reset database (⚠️ This will delete all data)
```bash
docker-compose down
docker volume rm learn-spring_db_data
docker-compose up -d
```

### Access PostgreSQL directly
```bash
docker exec -it postgres-spring-boot psql -U rifki -d springboot_db
```

## 🛠️ Troubleshooting

### Common Issues

**1. Port 8080 already in use**
```bash
# Check what's using port 8080
lsof -i :8080

# Kill the process or change port in docker-compose.yml
```

**2. Database connection failed**
```bash
# Check if PostgreSQL container is running
docker ps

# Restart the database
docker-compose restart db
```

**3. Application won't start**
```bash
# Check application logs
docker-compose logs app

# Rebuild the application
docker-compose up --build
```

### Health Check
```bash
# Check if application is healthy
curl http://localhost:8080/

# Check database connection
curl http://localhost:8080/api/v1/software-engineers
```

## 📊 Sample Data

You can use this sample data to test the API:

```json
[
  {
    "name": "John Doe",
    "techStack": "Java, Spring Boot, PostgreSQL, Docker"
  },
  {
    "name": "Jane Smith",
    "techStack": "JavaScript, React, Node.js, MongoDB"
  },
  {
    "name": "Bob Wilson",
    "techStack": "Python, Django, PostgreSQL, AWS"
  },
  {
    "name": "Alice Johnson",
    "techStack": "C#, .NET Core, SQL Server, Azure"
  },
  {
    "name": "Charlie Brown",
    "techStack": "Go, Docker, Kubernetes, Redis"
  }
]
```

## 🔒 Security Notes

- This is a development setup without authentication
- Database credentials are stored in plain text in docker-compose.yml
- For production use, implement proper security measures

## 📞 Support

If you encounter any issues:

1. Check the troubleshooting section above
2. Verify Docker containers are running: `docker ps`
3. Check application logs: `docker-compose logs app`
4. Ensure all ports are available (8080 for app, 5432 for database)

---

**Happy coding! 🚀**