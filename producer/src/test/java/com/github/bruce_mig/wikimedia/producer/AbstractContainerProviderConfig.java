package com.github.bruce_mig.wikimedia.producer;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest
@Testcontainers
public class AbstractContainerProviderConfig {

//    static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:6.2.1"));
    static KafkaContainer kafka = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:7.9.0")
        .asCompatibleSubstituteFor("apache/kafka"));


    @DynamicPropertySource
    public static void setup(DynamicPropertyRegistry registry) {
        Startables.deepStart(kafka).join();

        registry.add("spring.kafka.producer.bootstrap-servers", kafka::getBootstrapServers);
    }
}
