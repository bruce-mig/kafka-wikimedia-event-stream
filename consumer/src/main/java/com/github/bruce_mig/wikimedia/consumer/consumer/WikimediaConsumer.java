package com.github.bruce_mig.wikimedia.consumer.consumer;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WikimediaConsumer {

    @Value("${topic.name}")
    private static String wikimediaStream;

    @Value("${spring.kafka.consumer.group-id}")
    private String group;


    @KafkaListener(topics = "${topic.name}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumeMsg(String msg){
        log.info("Consuming the message: {} from  topic: '{}'", msg ,wikimediaStream);
        // todo: persist data
    }
}
