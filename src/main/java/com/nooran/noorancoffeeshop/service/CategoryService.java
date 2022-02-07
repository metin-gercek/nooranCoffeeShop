package com.nooran.noorancoffeeshop.service;

import java.util.List;
import com.nooran.noorancoffeeshop.model.Category;
import com.nooran.noorancoffeeshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    public void addCategory(Category category) {
        categoryRepository.save(category);
    }
}