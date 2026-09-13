# Ubeer

Ubeer is a backend microservices project inspired by ride-hailing platforms. It is designed to explore how ride requests, driver locations, and driver-passenger matching can be separated into independent services and connected through event-driven communication.

The project is currently in early development. Its service structure and local infrastructure have been created, while business APIs and inter-service integration are still being implemented.

## Services

- **Location Service** — designed to manage driver location data with Redis.
- **Matching Service** — designed to process driver-passenger matching events with Kafka.
- **Ride Service** — designed to manage ride data with MySQL and publish ride-related events through Kafka.

## Tech Stack

- Java 17
- Spring Boot 4
- Spring Web MVC
- Spring Data JPA
- Spring Data Redis
- Apache Kafka
- MySQL
- Redis
- Docker Compose
- Maven

## Project Structure

```text
Ubeer/
├── location-service/    # Driver location service
├── matching-service/    # Driver-passenger matching service
├── ride-service/        # Ride management service
└── docker-compose.yml   # Redis, MySQL, Kafka, and ZooKeeper
```

## Local Infrastructure

Start Redis, MySQL, Kafka, and ZooKeeper with Docker Compose:

```bash
docker compose up -d
```

Stop the infrastructure:

```bash
docker compose down
```

## Development Status

This project is under active development. The current repository provides the initial microservice modules, dependencies, and local infrastructure required for future ride-hailing workflows.
