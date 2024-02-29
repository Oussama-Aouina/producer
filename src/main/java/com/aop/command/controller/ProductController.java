package com.aop.command.controller;

import com.aop.command.model.Product;
import com.aop.command.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@CrossOrigin("**")
@RequestMapping(path = "api/v1/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("/save")
    public void saveProduct(@RequestBody Product product) {
        productService.addProduct(product);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id,@RequestBody Product product){
        productService.updateProduct(id,product);
        return ResponseEntity.ok("product :"+id+"updated");
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable String id){
        productService.deleteProduct(id);
        return ResponseEntity.ok("product :"+id+"deleted");
    }
}
