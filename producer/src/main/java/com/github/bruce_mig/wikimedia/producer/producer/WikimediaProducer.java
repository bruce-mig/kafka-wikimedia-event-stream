package com.github.bruce_mig.wikimedia.producer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;


@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaProducer {

    @Value("${topic.name}")
    private String wikimediaStream;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg){
        log.info("Sending message: '{}' to Topic: {}" ,msg, wikimediaStream);
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send(wikimediaStream, msg);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Sent message=[{}] to topic=[{}] with offset=[{}]", msg,wikimediaStream, result.getRecordMetadata().offset());
            } else {
                log.error("Unable to send message=[{}] due to : {}", msg, ex.getMessage());
            }
        });
    }

}
