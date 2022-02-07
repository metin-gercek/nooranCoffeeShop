package com.nooran.noorancoffeeshop.repository;

import com.nooran.noorancoffeeshop.model.Supplier;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
    
}
