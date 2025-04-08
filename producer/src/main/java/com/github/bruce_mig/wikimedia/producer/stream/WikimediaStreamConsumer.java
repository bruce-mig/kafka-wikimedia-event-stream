package com.github.bruce_mig.wikimedia.producer.stream;

import com.github.bruce_mig.wikimedia.producer.producer.WikimediaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@Slf4j
public class WikimediaStreamConsumer {

    private final WebClient webClient;
    private final WikimediaProducer producer;


    public WikimediaStreamConsumer(WebClient webClient, WikimediaProducer producer) {
        this.webClient = webClient;
        this.producer = producer;
    }

    public void consumeStreamAndPublish(){
        webClient.get()
                .uri("/stream/recentchange")
                .retrieve()
                .bodyToFlux(String.class)
                .subscribe(producer::sendMessage);
    }


}
