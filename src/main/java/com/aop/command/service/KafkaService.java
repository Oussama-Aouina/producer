package com.aop.command.service;

import com.aop.command.dto.KafkaEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.protocol.types.Field;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {
    private final KafkaTemplate<String,Object> kafkaTemplate;
    public void sendMessage(KafkaEvent kafkaEvent){
        kafkaTemplate.send("stock2",kafkaEvent);
    }
}
