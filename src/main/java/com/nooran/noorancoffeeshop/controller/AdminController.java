package com.nooran.noorancoffeeshop.controller;

import com.nooran.noorancoffeeshop.model.Category;
import com.nooran.noorancoffeeshop.model.Manufacturer;
import com.nooran.noorancoffeeshop.model.Supplier;
import com.nooran.noorancoffeeshop.service.CategoryService;
import com.nooran.noorancoffeeshop.service.ManufacturerService;
import com.nooran.noorancoffeeshop.service.SupplierService;

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
	ManufacturerService manufacturerService;
	SupplierService supplierService;
    @GetMapping("/admin")
	public String adminHome() {
		
		return "adminHome";
	}

    @GetMapping("/admin/categories")
    public String getCat(Model model) {
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}
    @GetMapping("/admin/categories/add")
    public String getCatAdd(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}
    @PostMapping("/admin/categories/add")
    public String postCatAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}


    @GetMapping("/admin/products")
    public String getProducts() {
		
		return "products";
	}


    @GetMapping("/admin/manufacturers")
    public String getMan(Model model) {
		model.addAttribute("manufacturers", manufacturerService.getAllManufacturer());
		return "manufacturers";
	}

	@GetMapping("/admin/manufacturers/add")
    public String getManAdd(Model model) {
		model.addAttribute("manufacturer", new Manufacturer());
		return "manufacturersAdd";
	}
    @PostMapping("/admin/manufacturers/add")
    public String postManAdd(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
		manufacturerService.addManufacturer(manufacturer);
		return "redirect:/admin/manufacturers";
	}




    @GetMapping("/admin/suppliers")
    public String getSupplier(Model model) {
		model.addAttribute("suppliers", supplierService.getAllSupplier());
		return "suppliers";
	}
    @GetMapping("/admin/suppliers/add")
    public String getSupplierAdd(Model model) {
		model.addAttribute("supplier", new Supplier());
		return "suppliers";
	}

    @PostMapping("/admin/suppliers/add")
    public String postSupplierAdd(@ModelAttribute("supplier")  Supplier supplier) {
		supplierService.addSupplier(supplier);
		return "redirect:admin/suppliers";
	}

}