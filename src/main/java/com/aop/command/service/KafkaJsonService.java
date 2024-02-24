package com.aop.command.service;

import com.aop.command.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        //this object mapper is used to Serialize the json object "Product" to be sent in a String
        ObjectMapper mapper = new ObjectMapper();
        String reqJson = null;
        try {
            reqJson = mapper.writeValueAsString(product);
        } catch (JsonProcessingException e) {
            System.out.println(e);
            throw new RuntimeException(e);

        }
        // this is the kafka message
        Message<String> message= MessageBuilder.withPayload(reqJson)
                .setHeader(KafkaHeaders.TOPIC,"stock")
                .build();

        kafkaTemplate.send(message);

    }

}
