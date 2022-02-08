package com.nooran.noorancoffeeshop.controller;

import java.util.Optional;

import com.nooran.noorancoffeeshop.dto.ProductDTO;
import com.nooran.noorancoffeeshop.model.Category;
import com.nooran.noorancoffeeshop.model.Manufacturer;
import com.nooran.noorancoffeeshop.model.Supplier;
import com.nooran.noorancoffeeshop.service.CategoryService;
import com.nooran.noorancoffeeshop.service.ManufacturerService;
import com.nooran.noorancoffeeshop.service.ProductService;
import com.nooran.noorancoffeeshop.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

	@Autowired
	CategoryService categoryService;
	@Autowired
	ManufacturerService manufacturerService;
	@Autowired
	SupplierService supplierService;
	@Autowired
	ProductService productService;

	@GetMapping("/admin")
	public String adminHome() {

		return "adminHome";
	}

	// Category section
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

	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCat(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/update/{id}")
	public String updateCat(@PathVariable int id, Model model) {
		Optional<Category> category = categoryService.getCategoryById(id);
		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			return "categoriesAdd";
		}
		return "404";

	}

	// Product section

	@GetMapping("/admin/products")
	public String getProducts(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "products";
	}

	@GetMapping("/admin/products/add")
	public String getProductsAdd(Model model) {
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", categoryService.getAllCategory());
		return "productsAdd";
	}


	// Manufacturer section
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

	@GetMapping("/admin/manufacturers/delete/{id}")
	public String deleteMan(@PathVariable int id) {
		manufacturerService.removeManufacturerById(id);
		return "redirect:/admin/manufacturers";
	}

	@GetMapping("/admin/manufacturers/update/{id}")
	public String updateMan(@PathVariable int id, Model model) {
		Optional<Manufacturer> manufacturer = manufacturerService.getManufacturerById(id);
		if (manufacturer.isPresent()) {
			model.addAttribute("manufacturer", manufacturer.get());
			return "manufacturersAdd";
		}
		return "404";

	}


	// Supplier section

	@GetMapping("/admin/suppliers")
	public String getSupplier(Model model) {
		model.addAttribute("suppliers", supplierService.getAllSupplier());
		return "suppliers";
	}

	@GetMapping("/admin/suppliers/add")
	public String getSupplierAdd(Model model) {
		model.addAttribute("supplier", new Supplier());
		return "suppliersAdd";
	}

	@PostMapping("/admin/suppliers/add")
	public String postSupplierAdd(@ModelAttribute("supplier") Supplier supplier) {
		supplierService.addSupplier(supplier);
		return "redirect:/admin/suppliers";
	}

	@GetMapping("/admin/suppliers/delete/{id}")
	public String deleteSupplier(@PathVariable int id) {
		supplierService.removeSupplierById(id);
		return "redirect:/admin/suppliers";
	}

	@GetMapping("/admin/suppliers/update/{id}")
	public String updateSupplier(@PathVariable int id, Model model) {
		Optional<Supplier> supplier = supplierService.getSupplierById(id);
		if (supplier.isPresent()) {
			model.addAttribute("supplier", supplier.get());
			return "suppliersAdd";
		}
		return "404";

	}

}