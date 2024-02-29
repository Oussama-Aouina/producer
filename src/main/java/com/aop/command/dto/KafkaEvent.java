package com.aop.command.dto;

import com.aop.command.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class KafkaEvent {
    private EventTypes eventType;
    private Product product;
}
