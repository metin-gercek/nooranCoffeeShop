package com.nooran.noorancoffeeshop.service;

import java.util.List;

import com.nooran.noorancoffeeshop.model.Product;
import com.nooran.noorancoffeeshop.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }
    
}
