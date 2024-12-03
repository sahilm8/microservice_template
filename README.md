# Microservice Template

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white) ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white) ![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)

![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)

![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)

Microservice template with Java 21, Spring Boot, Spring Web, Spring Data JPA, MySQL Connector, Docker, Spring Dotenv, Lombok, and Spring Test.

## Stack

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL Connector
- Docker
- Spring Dotenv
- Lombok
- Spring Test


## Setup

- Install dependencies:
```
./mvnw clean install
```
- Pull Docker MySQL image for running database server:
```
docker pull mysql:latest
```

- Create an external volume for storing MySQL data:
```
docker volume create mysql_volume
```
- Run the container:
```
docker compose up -d
```
- Start the application:
```
./mvnw spring-boot:run
```
- Stop the container:
```
docker compose down
```
