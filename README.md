# Kafka Producer Microservice with CQRS and AOP using Spring Boot

This repository contains a Spring Boot microservice designed as a Kafka consumer, implementing the Command Query Responsibility Segregation (CQRS) pattern and Aspect-Oriented Programming (AOP) principles. The microservice is intended to work in conjunction with the producer available in the [consumer repository]([https://github.com/Oussama-Aouina/producer.git](https://github.com/Oussama-Aouina/consumer.git)).

## Features

- **Kafka Producer**: Efficiently produce/send messages in JSON format to the Kafka topic to be consumed by the associated consumers.
- **CQRS Pattern**: Separates the command (write) and query (read) operations, allowing for scalability and flexibility.
- **AOP Implementation**: Leverages Aspect-Oriented Programming for modularizing cross-cutting concerns such as logging, security, and performance monitoring.
- **Spring Boot**: Built on the Spring Boot framework, providing a streamlined development experience and easy integration.

## Getting Started

1. Clone the repository:

   ```bash
   git clone https://github.com/Oussama-Aouina/producer.git

2. Navigate to the project directory:

   ```bash
   cd producer

3. Build and run the application:

   ```bash
   ./mvnw spring-boot:run

## Configuration

Adjust Kafka configuration in application.properties to match your Kafka setup.

## Dependencies

- **Java 8 or later**
- **Spring Boot**
- **Kafka**
- **Mysql**
- **JPA**
- **Lombok**

