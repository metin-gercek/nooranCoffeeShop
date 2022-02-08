package com.nooran.noorancoffeeshop.repository;

import com.nooran.noorancoffeeshop.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    
}
