package com.nooran.noorancoffeeshop.repository;

import java.util.List;

import com.nooran.noorancoffeeshop.model.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategory_Id(int id);
    List<Product> findAllByManufacturer_Id(int id);
    List<Product> findAllBySupplier_Id(int id);

    @Query("SELECT product FROM Product product WHERE product.name LIKE %?1%")
    List<Product> search(String keyword);

    
}
