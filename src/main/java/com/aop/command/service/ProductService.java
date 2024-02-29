package com.aop.command.service;

import com.aop.command.dto.EventTypes;
import com.aop.command.dto.KafkaEvent;
import com.aop.command.model.Product;
import com.aop.command.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo ;

    @Autowired
    private KafkaJsonService kafkaJsonService;

    @Autowired
    private KafkaService kafkaService;

//    public void addProduct(Product product) {
//        productRepo.save(product);
//        kafkaJsonService.sendProduct(product);
//    }
public void addProduct(Product product) {
    productRepo.save(product);
    KafkaEvent kafkaEvent = new KafkaEvent(EventTypes.addProduct,product);
    kafkaJsonService.sendMessage(kafkaEvent);
}

    public void updateProduct(String id, Product product) {
        Product old = productRepo.findById(id).get();
        old.setName(product.getName());
        old.setDescription(product.getDescription());
        old.setPrice(product.getPrice());
        productRepo.save(old);
        KafkaEvent updateEvnent = new KafkaEvent(EventTypes.updateProduct,old);
        kafkaJsonService.sendMessage(updateEvnent);
    }

    public void deleteProduct(String id) {
        Product old = productRepo.findById(id).get();
        productRepo.delete(old);
        KafkaEvent deleteEvent = new KafkaEvent(EventTypes.deleteProduct,old);
        kafkaJsonService.sendMessage(deleteEvent);

    }
}
