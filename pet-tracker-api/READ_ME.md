# 🐾 pet-tracker-api

A simple in-memory **CRUD API** built using **Kotlin + Spring Boot**, for managing pet records.

---

## 🚀 Features

- RESTful API design
- In-memory data storage using a singleton object
- JSON request/response handling
- Proper use of HTTP status codes (`200`, `201`, `204`, `404`)
- Tested with Postman & curl

---

## ⚙️ Tech Stack

| Technology     | Version / Tool         |
|----------------|------------------------|
| Language        | Kotlin                 |
| Framework       | Spring Boot (3.x)      |
| Build Tool      | Gradle (Kotlin DSL)    |
| JSON Mapper     | Jackson (default)      |
| Testing Tool    | Postman or curl        |
| Storage         | In-memory (no DB yet)  |

---

## 📁 Project Structure

```
pet-tracker-api/
├── controller/
│   └── PetController.kt
├── model/
│   └── Pet.kt
├── service/
│   └── PetService.kt
├── storage/
│   └── PetStorage.kt
└── PetTrackerApiApplication.kt
```

---

## 📮 API Endpoints

| Method | Endpoint         | Description               | Status Code |
|--------|------------------|---------------------------|-------------|
| GET    | `/pets`          | Get all pets              | 200 OK      |
| GET    | `/pets/{id}`     | Get pet by ID             | 200 / 404   |
| POST   | `/pets`          | Create new pet            | 201 Created |
| PUT    | `/pets/{id}`     | Update existing pet       | 200 / 404   |
| DELETE | `/pets/{id}`     | Delete pet by ID          | 204 / 404   |

### 🐶 Sample JSON Body
```json
{
  "name": "Simba",
  "type": "Dog"
}
```

---

## 🧪 Testing the API

### ▶️ Add a pet
```bash
curl -X POST http://localhost:8080/pets \
  -H "Content-Type: application/json" \
  -d '{"name":"Simba", "type":"Dog"}'
```

### ▶️ Get all pets
```bash
curl http://localhost:8080/pets
```

### ▶️ Get a pet by ID
```bash
curl http://localhost:8080/pets/1
```

### ▶️ Update a pet
```bash
curl -X PUT http://localhost:8080/pets/1 \
  -H "Content-Type: application/json" \
  -d '{"id":0, "name":"Simba", "type":"Golden Retriever"}'
```

### ▶️ Delete a pet
```bash
curl -X DELETE http://localhost:8080/pets/1
```

---
