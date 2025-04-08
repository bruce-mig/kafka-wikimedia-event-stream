## Kafka-Wikimedia-Event-Streamer

This repository contains a Spring Boot microservices application that streams events from Wikimedia, processes them using Apache Kafka, and stores them in a database. The application leverages Spring Reactive Web and WebClient to handle real-time event streaming.

### Technologies Used
- **Spring Boot**: For building the microservices architecture.
- **Apache Kafka**: For event streaming and messaging.
- **Spring Reactive Web**: For handling non-blocking reactive streams.
- **WebClient**: For making asynchronous web requests.
- **Database**: To store the streamed events.
- **Wikimedia Recent Changes Stream**: This public stream provides real-time updates on changes happening in Wikimedia projects.

### Key Features
- **Event Streaming**: Streams real-time events from the [Wikimedia Recent Changes API](https://stream.wikimedia.org/v2/stream/recentchange).
- **Kafka Integration**: Sends streamed events to Kafka topics.
- **Database Storage**: Consumes Kafka events and stores them in a database.
- **Reactive Programming**: Utilizes Spring Reactive and WebClient for non-blocking, asynchronous processing.

### Getting Started
1. **Clone the repository**:
   ```bash
   git clone https://github.com/bruce-mig/kafka-wikimedia-event-stream.git
   cd kafka-wikimedia-event-stream
   ```
2. **Configure Kafka**: Ensure that you have a running Kafka instance and update the application properties with the Kafka broker details.
   In root of the project run: 
    ```bash
   docker compose up -d
3. ```
3. **Run the Application**: Use the following command to start the Spring Boot application
   ```bash
   ./mvnw spring-boot:run
   ```

### Contributing
Feel free to contribute to this project by opening issues, submitting pull requests, or suggesting new features.
