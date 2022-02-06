package com.nooran.noorancoffeeshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    
    @GetMapping("/admin")
	public String adminHome() {
		
		return "adminHome";
	}

    @GetMapping("admin/categories")
    public String getCategories() {
		
		return "categories";
	}
    @GetMapping("admin/products")
    public String getProducts() {
		
		return "products";
	}

}