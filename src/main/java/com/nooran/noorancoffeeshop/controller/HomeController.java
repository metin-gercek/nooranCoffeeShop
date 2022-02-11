package com.nooran.noorancoffeeshop.controller;

import com.nooran.noorancoffeeshop.model.Manufacturer;
import com.nooran.noorancoffeeshop.service.CategoryService;
import com.nooran.noorancoffeeshop.service.ManufacturerService;
import com.nooran.noorancoffeeshop.service.ProductService;
import com.nooran.noorancoffeeshop.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;
    @Autowired
    ManufacturerService manufacturerService;
    @Autowired
    SupplierService supplierService;

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturer());
        model.addAttribute("suppliers", supplierService.getAllSupplier());
        model.addAttribute("products", productService.getAllProduct());
        return "index";
    }


    
}
