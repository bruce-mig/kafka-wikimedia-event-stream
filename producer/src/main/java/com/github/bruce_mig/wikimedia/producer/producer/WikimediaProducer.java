package com.github.bruce_mig.wikimedia.producer.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WikimediaProducer {

    @Value("${topic.name}")
    private String wikimediaStream;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String msg){
//        log.info("Sending message: '{}' to Topic: {}" ,msg, wikimediaStream);
        kafkaTemplate.send(wikimediaStream, msg);
    }

}
