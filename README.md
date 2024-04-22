# Overview
Dam service provide a set of Apis to manage dam information and dam opening schedules
# Required:
```diff
+ Docker.
+ Maven.
+ JDK 17 and above.
```
# Installation:
## 1. application.properties
PATH: <your_project>/src/main/resources/application.properties
```java
server.port=<service_port>
spring.datasource.url=jdbc:postgresql://<db_host>:<db_port>/<db_name>
spring.datasource.username=<db_username>
spring.datasource.password=<db_password>
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
management.endpoints.web.exposure.include=*
```
## 2. .env
PATH: .env
```java
POSTGRES_USER=<db_username>
POSTGRES_PASSWORD=<db_password>
POSTGRES_DB=<db_name>
```
## 3. Dockerfile
PATH: ./Dockerfile
```java
FROM openjdk:17

COPY ./target/<your_built_file>.jar /app/<your_built_file>.jar

WORKDIR /app/

EXPOSE 8082
EXPOSE 5005

CMD [ "java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar", "/app/<your_built_file>.jar" ]
```
## 4. docker-compose.yml
PATH: ./docker-compose.yml <br/>
It's just an example, all values in this file can be edited based on your local machine or your customization.
```java
version: "2.10.2"
services:
  dms-postgres-db:
   image: postgres
   container_name: dms-postgres-db
   env_file:
     - .env
   ports:
     - '5434:5432'
   networks:
     - dms-net
   restart: always
  dms-service:
    image: dam-service:1.0.0
    container_name: dms-service
    build:
      context: .
      dockerfile: Dockerfile
    env_file:
      - .env
    ports:
      - '8082:8081'
      - '5005:5005'
    networks:
      - dms-net
    depends_on:
      - dms-postgres-db
networks:
  dms-net:
    name: dms-net
    attachable: true
    driver: bridge
```

# Deployment:
## 1. Build & Start
```java
docker compose up
```
## 2. Stop & Remove
Deleting an image in your docker desktop is necessary, if you want to build it again. 
```java
Ctrl + C 
or 
docker compose down
```
