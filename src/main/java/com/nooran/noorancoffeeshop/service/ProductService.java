package com.nooran.noorancoffeeshop.service;

import java.util.List;
import java.util.Optional;

import com.nooran.noorancoffeeshop.model.Product;

import com.nooran.noorancoffeeshop.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

   
    

    @Autowired
    ProductRepository productRepository;
    public List<Product> getAllProduct() {
        return productRepository.findAll();
    }

    

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public void removeProductById(long id){
        productRepository.deleteById(id);
    }

    public Optional<Product> getProductById(long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProductsByCategoryId(int parentId) {
        return productRepository.findAllByCategory_Id(parentId);
    }

    public List<Product> getAllProductsByManufacturerId(int id) {
        return productRepository.findAllByManufacturer_Id(id);
    }
    
    public List<Product> getAllProductsBySupplierId(int id) {
        return productRepository.findAllBySupplier_Id(id);
    }

    public Page<Product> getProductPaginate(int currentPage, int size) {

        PageRequest pageable = PageRequest.of(currentPage, size);
        return productRepository.findAll(pageable);
    }

    
    
}
