package com.aop.command.service;

import com.aop.command.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaJsonService {
    @Autowired
    private final KafkaTemplate<String, Product> kafkaTemplate;

    public void sendProduct(Product product){
        Message<Product> message= MessageBuilder.withPayload(product)
                .setHeader(KafkaHeaders.TOPIC,"stock")
                .build();
        kafkaTemplate.send(message);
    }

}
