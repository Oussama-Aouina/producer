package com.aop.command.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {
    // this bean is used to create the kafka topic
    @Bean
    public NewTopic stockTopic(){
        return TopicBuilder.
                name("stock").
                build();
    }
}
