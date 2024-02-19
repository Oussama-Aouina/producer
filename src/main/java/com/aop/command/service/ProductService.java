package com.aop.command.service;

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
    private KafkaService kafkaService;
    public void addProduct(Product product) {
        productRepo.save(product);
        kafkaService.sendMessage("product added:"+product.getId());
    }
}
