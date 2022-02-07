package com.nooran.noorancoffeeshop.repository;

import com.nooran.noorancoffeeshop.model.Manufacturer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ManufacturerRepository extends JpaRepository<Manufacturer, Integer> {
    
}
