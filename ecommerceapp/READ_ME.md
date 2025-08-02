# 🛒 E-commerce Order System

A sample backend project to demonstrate **Spring Boot + Kotlin + PostgreSQL + JPA/Hibernate** with proper entity relationships.

## 📦 Features

- User Management
- Product Listing
- Place Orders (multiple products per order)
- Fetch All Orders
- Fetch Orders by User

## 🧱 Tech Stack

- Kotlin
- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL
- Gradle
- H2 (optional for testing)

## 🗃️ Entity Relationships

- `User` ⬌ `Order` → OneToMany
- `Order` ⬌ `Product` → ManyToMany

---

## 🏁 Getting Started

### 🛠 Prerequisites

- JDK 17+
- PostgreSQL installed and running
- Gradle

### 🗄 Database Setup

```bash
# Connect to PostgreSQL
psql -U postgres

# Inside psql shell
CREATE USER book_user WITH PASSWORD 'book_pass';
CREATE DATABASE ecommerce_db OWNER book_user;
