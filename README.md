# Project Name
LibraryManagement

## Overview
LibraryManagement is an advanced library management system designed to streamline the cataloging, tracking, and lending of books, ensuring a seamless experience for both librarians and patrons. This application leverages modern technologies such as Java, Apache Kafka, and Spring Boot to ensure high performance and scalability. With integrated support for APIs, the system offers comprehensive functionality to manage books and authors, enabling efficient data handling and retrieval.


## Prerequisites

- Java 17+
- Maven 3.6+
- Apache Kafka
- Docker (optional, if you use Docker for Kafka setup)

## Setup

### Clone the repository

```sh
git clone https://github.com/gnayak09/LibraryManagement.git
cd your-repo
```

### Build the application

```sh
mvn clean install
```

### Run the Kafka server

```sh
docker-compose up -d
```
OR if you're using a local Kafka setup:

```sh
# Start Zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties 

# Start Kafka broker
bin/kafka-server-start.sh config/server.properties
```

### Configure application properties

Make sure to update your `application.properties` with your Kafka server's details.

```properties
kafka.topic.author=author-topic
kafka.topic.book=book-topic
spring.kafka.bootstrap-servers=localhost:9092
spring.kafka.consumer.group-id=my-group
```

### Run the application

```sh
mvn spring-boot:run
```

## API Endpoints

### List of all Books with their authors’ details
``GET /api/books-with-authors/books``
``GET /api/books-with-authors/books/{bookId}``

### Information about an author along with their books
``GET api/author-with-books/author``
``GET api/author-with-books/author/{authorId}``

### Books endpoint 
``POST /api/books``
``PUT /api/books/{bookId}``
``DEL /api/books/{bookId}``
``GET /api/books/{bookId}``
``GET /api/books``

### Author endpoint 
``POST /api/authors``
``PUT /api/authors/{authorId}``
``DEL /api/authors/{authorId}``
``GET /api/authors/{authorId}``
``GET /api/authors`

###Postman Collection
Below is the Postman collection JSON to import and start testing the APIs. Save the following JSON to a file (e.g., `PostmanCollection.json`) and import it into Postman.
Added in the resource folder with name Library Management.postman_collection.json.

###Script to add sample data in DB is aslo added as schema.sql

 
