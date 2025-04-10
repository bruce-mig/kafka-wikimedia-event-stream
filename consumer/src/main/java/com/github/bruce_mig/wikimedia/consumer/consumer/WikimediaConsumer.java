package com.github.bruce_mig.wikimedia.consumer.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.retry.annotation.Backoff;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikimediaConsumer {

    @Value("${topic.name}")
    private static String wikimediaStream;

    @Value("${spring.kafka.consumer.group-id}")
    private String group;

    @RetryableTopic(
            attempts = "4",
            backoff = @Backoff(delay = 3000, multiplier = 1.5, maxDelay = 15000),
            exclude = {NullPointerException.class, JsonProcessingException.class}
    )
    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMsg(String msg, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) long offset){
        log.info("Consuming the message: '{}' from  topic: '{}'", msg ,wikimediaStream);
        // todo: persist data
    }

    @DltHandler
    public void listenDLT(String msg, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic, @Header(KafkaHeaders.OFFSET) long offset){
        log.info("Dead Letter Topic received: {}, from: {}, offset: {}",msg, topic, offset);
    }
}
