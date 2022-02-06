package com.nooran.noorancoffeeshop.repository;

import com.nooran.noorancoffeeshop.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    
}
