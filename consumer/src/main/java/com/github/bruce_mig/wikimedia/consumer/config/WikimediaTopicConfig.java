package com.github.bruce_mig.wikimedia.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class WikimediaTopicConfig {

    @Value("${topic.name}")
    private String wikimediaStream;


    @Bean
    public NewTopic wikimediaStreamTopic(){
        return TopicBuilder
                .name(wikimediaStream)
                .build();
    }
}
