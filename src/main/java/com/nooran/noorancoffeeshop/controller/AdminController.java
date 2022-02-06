package com.nooran.noorancoffeeshop.controller;

import com.nooran.noorancoffeeshop.model.Category;
import com.nooran.noorancoffeeshop.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

	@Autowired
    CategoryService categoryService;
    @GetMapping("/admin")
	public String adminHome() {
		
		return "adminHome";
	}

    @GetMapping("admin/categories")
    public String getCat(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}
    @GetMapping("admin/categories/add")
    public String getCatAdd(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}
    @PostMapping("admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}


    @GetMapping("admin/products")
    public String getProducts() {
		
		return "products";
	}
    @GetMapping("admin/manufacturers")
    public String getManufacturers() {
		
		return "manufacturers";
	}
    @GetMapping("admin/suppliers")
    public String getSupplier() {
		
		return "suppliers";
	}

}