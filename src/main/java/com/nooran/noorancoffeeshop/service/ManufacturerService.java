package com.nooran.noorancoffeeshop.service;

import com.nooran.noorancoffeeshop.model.Manufacturer;
import com.nooran.noorancoffeeshop.repository.ManufacturerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManufacturerService {
    @Autowired
    ManufacturerRepository manufacturerRepository;
    public List<Manufacturer> getAllManufacturer() {
        return manufacturerRepository.findAll();
    }
    public void addManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);
    }   
}