# 🏦 Digital Banking Microservices Architecture
## 📖 Overview

This project is a **Digital Banking Platform** built using a **Microservices Architecture**. Each business domain is developed as an independent service, allowing scalability, maintainability, fault isolation, and independent deployment.

The platform supports multiple client applications such as mobile banking and web portals through a centralized API Gateway.

---
# Technology Stack

| Layer            | Technology                                                                             |
|------------------|----------------------------------------------------------------------------------------|
| Frontend         | Angular + Typescript,Tailwind CSS, Material UI atau shadcn/ui,                         |
| Mobile           | Flutter/ Kotlin(ANdroid),  Swift (iOS)                                                 |
| Backend          | Java 17                                                                                |
| Framework        | Spring Boot 3                                                                          |
| Security         | Spring Security 6                                                                      |
| Data Acces Layer | Spring JPA                                                                             |
| API              | RESTful API                                                                            |
| Database         | PostgreSQL                                                                             |
| Cache            | Redis                                                                                  |
| Search           | Elasticsearch                                                                          |
| Message Broker   | Kafka / RabbitMQ                                                                       |
| API Gateway      | Spring Cloud Gateway                                                                   |
| Authentication   | JWT + OAuth2                                                                           |
| Build Tool       | Maven                                                                                  |
| Containerization | Docker                                                                                 |
| Orchestration    | Kubernetes                                                                             |
| Monitoring       | Prometheus + Grafana                                                                   |
| Logging          | ELK Stack                                                                              |
| Documentation    | OpenAPI (Swagger)                                                                      |
| DevOps           | Docker, Kubernetes, GitHub Actions, Jenkins, SonarQube, Prometheus, Grafana, ELK Stack |
---

# 🏛 High Level Architecture

```text
                    Mobile App
                         |
                  Angular Web Portal (Port : 4200)
                         |
                  API Gateway (Port:8080)
                         |
------------------------------------------------------------
| User Service (Port: 8081)
| Authentication Service 
| Customer Service 
| Account Service (Port : 8082)
| Deposit Service (Port : 8083)
| Transaction Service
| Payment Service
| Transfer Service (Port : 8084)
| Biller Service (Port : 8085)
| QRIS Service
| Virtual Account Service
| Notification Service
| Reporting Service
------------------------------------------------------------
               Kafka / RabbitMQ
------------------------------------------------------------
       PostgreSQL | Redis | Elasticsearch 
------------------------------------------------------------
               Docker | Kubernetes 
```

---

# 🧩 Architecture Components

## Client Layer

### 📱 Mobile App

Native Android/iOS application used by customers to access banking services.

Features:

- User Login
- Balance Inquiry
- Fund Transfer
- QRIS Payment
- Virtual Account Payment
- Transaction History
- Notifications

---

### 💻 React Web Portal

Web application for:

- Customers
- Customer Service
- Bank Administrators
- Super Admin

Features:

- User Management
- Customer Management
- Transaction Monitoring
- Reporting Dashboard
- Account Management

---

# API Gateway

Acts as the single entry point for all client requests.

Responsibilities:

- Authentication
- Authorization
- JWT Validation
- SSL Termination
- Request Routing
- Rate Limiting
- Load Balancing
- API Versioning
- Logging
- Request Transformation

Possible Technologies:

- Spring Cloud Gateway
- Kong
- NGINX
- Traefik

---

# Microservices

---

## 👤 User Service

Responsible for user management.

Responsibilities:

- User CRUD
- User Profile
- User Preferences
- Device Registration
- User Status

Database:

- PostgreSQL

---

## 🔐 Authentication Service (user-service)

Handles identity and access management.

Responsibilities:

- Login
- Register
- Logout
- JWT Access Token
- Refresh Token
- OTP Verification (OTP SMS/OTP Email)
- Password Reset
- Password Change
- MFA
- Face ID
- Fingerprint
- OAuth2 Login
- Session Management

Database:

- PostgreSQL
- Redis

---

## 👥 Customer Service

Responsible for customer information.

Responsibilities:

- Customer Registration (Profile)
- KYC
- Customer Verification (Selfie Verification)
- Customer Address
- Customer Documents (Upload KTP)
- Customer Status
- Update Profile

Database:

- PostgreSQL

---

## 💳 Account Service

Handles bank accounts. (Savings, Current Account, Deposit)

Responsibilities:

- Create Account
- Close Account
- Account Inquiry
- Balance Inquiry
- Statement
- Mutation
- Mini Statement
- Account Status
- Account Types

Database:

- PostgreSQL

---

## 💸 Transaction Service

Responsible for transaction records.

Responsibilities:

- Debit
- Credit
- Transaction History
- Mini Statement
- Transaction Search
- Transaction Audit

Database:

- PostgreSQL
- Elasticsearch

---

## 🔁 Transfer Service

Responsible for money transfers.

Responsibilities:

- Internal Transfer
- Interbank Transfer
- Scheduled Transfer
- Recurring Transfer
- BI Fast
- RTGS
- SKN
- Transfer Validation
- Transfer Limit
- Transfer Fee

Database:

- PostgreSQL

---

## 💰 Payment Service

Handles payments.

Responsibilities:

- Bill Payment
- Merchant Payment
- PLN
- PDAM 
- Internet 
- Credit Card 
- Insurance
- Education
- Taxes 
- Government
- Payment Validation
- Payment Settlement
- Payment History

Database:

- PostgreSQL

---

## 📱 QRIS Service

Handles QRIS payment processing.

Responsibilities:

- QRIS Generate
- QRIS Scan
- Merchant QR
- Merchant Payment
- Merchant History
- Dynamic QR
- Static QR
- QR Payment
- QR Transaction History

Database:

- PostgreSQL

---

## 📱Top Up
- E-Wallet
  - GoPay
  - OVO
  - DANA
  - ShopeePay
- Pulsa
- Data Package
- Game Voucher
  
Database:
- PostgreSQL

---
## 🏦 Virtual Account Service

Responsible for Virtual Account transactions.

Responsibilities:

- Generate VA
- VA Inquiry
- VA Payment
- VA Status
- VA Callback
- VA Settlement

Database:

- PostgreSQL

---

## 🔔 Card Management

- Debit Card
- Virtual Card
- Block Card
- Change PIN
- Card Limit

Database:
- PostgreSQL
---
## 🔔 Investment

- Mutual Fund
- Gold
- Bond
- Stock

Database:
- PostgreSQL
---
## 🔔Loan
- Personal Loan
- Mortgage
- Vehicle Loan
- Credit Simulation

Database:

- PostgreSQL
---

## 🔔 Notification Service

Responsible for notifications.

Responsibilities:

- Email
- SMS
- Push Notification
- WhatsApp
- OTP Delivery
- Notification History
- In App Notification

Messaging:

- Kafka / RabbitMQ

---

## 📊 Admin Dashboard

- Customer Management
- Transaction Monitoring
- Fraud Detection
- Audit Trail
- Role Management
- System Configuration
- Reports
---

## 📊 Reporting Service

Responsible for reporting and analytics.

Responsibilities:

- Daily Report
- Monthly Report
- Customer Report
- Transaction Report
- Financial Report
- Dashboard Analytics

Database:

- Elasticsearch
- PostgreSQL

---

# Microservices

- Authentication Service
- Customer Service
- Account Service
- Transaction Service
- Transfer Service
- Payment Service
- Biller Service
- QRIS Service
- Notification Service
- Reporting Service
- Audit Service
- Fraud Service
- File Service
- Admin Service
- API GATEWAY
- COMMON-LIBRARY
- Discovery Service
---

# Messaging Layer

## Kafka / RabbitMQ

Used for asynchronous communication between microservices.

Example Events:

- UserRegistered
- LoginSuccess
- OTPGenerated
- TransactionCreated
- TransferCompleted
- PaymentCompleted
- QRISPaid
- VANotification
- SendEmail
- SendSMS
- PushNotification

Benefits:

- Loose Coupling
- Event Driven Architecture
- Retry Mechanism
- High Throughput
- Scalability

---

# Data Layer

## PostgreSQL

Primary relational database.

Stores:

- Users
- Customers
- Accounts
- Transactions
- Payments
- Transfers
- QRIS
- Virtual Accounts
- Reports

---

## Redis

In-memory database used for caching.

Stores:

- JWT Blacklist
- Refresh Token
- OTP
- Session
- Cache
- Rate Limiter
- Temporary Data

---

## Elasticsearch

Used for searching and analytics.

Indexes:

- Transactions
- Logs
- Customer Search
- Reporting
- Audit Trail

Benefits:

- Full-text Search
- Fast Filtering
- Aggregation
- Dashboard Analytics

---

# Request Flow

```text
Mobile App / React Web
        │
        ▼
API Gateway
        │
        ▼
Authentication Service
        │
        ▼
JWT Validation
        │
        ▼
Business Microservice
        │
        ▼
PostgreSQL
        │
        ▼
Publish Event
        │
        ▼
Kafka / RabbitMQ
        │
        ├────────► Notification Service
        ├────────► Reporting Service
        └────────► Other Services
```

---

# Security

- HTTPS
- JWT Authentication
- Refresh Token
- OAuth2
- HTTPS
- TLS 1.3
- AES Encryption
- RSA Encryption
- Database Encryption
- Password Encryption (BCrypt)
- Role Based Access Control (RBAC)
- Multi-Factor Authentication (MFA)
- OTP
- Device Binding
- Session Management
- Rate Limiting
- CAPTCHA
- API Gateway Security
- Audit Logging
- Fraud Detection
- IP Whitelist
- API Key
- Certificate Pinning

---


# Microservices Communication

| Communication | Purpose |
|--------------|---------|
| REST API | Synchronous service communication |
| Kafka | Event Streaming |
| RabbitMQ | Reliable Messaging |
| Redis | Distributed Cache |
| PostgreSQL | Persistent Data |
| Elasticsearch | Search & Analytics |

---

# APIs Example

| METHOD | API | Description |
|--------|------|----|
| POST| /api/v1/auth/user/login | User Login |
| POST | /api/v1/auth/user/register | User Register |
| POST | /api/v1/auth/user/{id}/role | Super Admin Change Role Customer |
| GET | /api/v1/accounts | |
| GET | /api/v1/accounts/{id} | |
| GET |  /api/v1/balance | |
| POST | /api/v1/transfers | |
| POST |  /api/v1/payments | |
| POST | /api/v1/qris/generate | |
| POST | /api/v1/qris/pay | |
| GET | /api/v1/transactions | |
| GET | /api/v1/history | |
| POST | /api/v1/cards/block | |
| POST | /api/v1/cards/change-pin | |

---

# Project Goals

- Domain-Driven Design (DDD)
- Event-Driven Architecture (EDA)
- Independent Deployment
- Horizontal Scalability
- High Availability
- Fault Isolation
- Secure Authentication
- Modular Development
- Cloud-Native Architecture
- Production-Ready Banking Platform

---

# Future Enhancements

- Open Banking API
- AI Fraud Detection
- AML (Anti-Money Laundering)
- BI Fast Integration
- Payment Gateway Integration
- International Remittance
- Card Management
- Investment Services
- Loan Services
- Digital Wallet Integration
- Multi-Tenant Architecture
- Service Mesh (Istio)
- Distributed Tracing (Jaeger)
- Centralized Configuration (Spring Cloud Config)
- Distributed Transaction (Saga Pattern)
- Kubernetes Auto Scaling
- CI/CD Pipeline with GitHub Actions