package com.example.controller;

import com.example.dto.ProductEvent;
import com.example.entity.Product;
import com.example.service.ProductCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    @Autowired
    private ProductCommandService commandService;

    @PostMapping
    public Product createProduct(@RequestBody ProductEvent productEvent) {
        return commandService.createProduct(productEvent);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody ProductEvent productEvent) {
        System.out.println("Controller : "+id+productEvent);
        return commandService.updateProduct(id, productEvent);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable long id, @RequestBody ProductEvent productEvent) {

        commandService.deleteProduct(id, productEvent);
    }
}
