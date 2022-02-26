package com.nooran.noorancoffeeshop.controller;




import com.nooran.noorancoffeeshop.global.GlobalData;
import com.nooran.noorancoffeeshop.model.Product;
import com.nooran.noorancoffeeshop.service.CategoryService;
import com.nooran.noorancoffeeshop.service.ManufacturerService;
import com.nooran.noorancoffeeshop.service.ProductService;
import com.nooran.noorancoffeeshop.service.SupplierService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }

     @GetMapping("/shop")
    public String shop(Model model, String keyword) {

        /*
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturer());
        model.addAttribute("suppliers", supplierService.getAllSupplier());
        model.addAttribute("cartCount", GlobalData.cart.size());

        model.addAttribute("products", productService.getAllProduct()); */
        return findPaginated(0, model);
    } 

    //pagination

    @GetMapping("/shop/page/{pageno}")
    public String findPaginated(@PathVariable int pageno, Model model) {

        Page<Product> productList = productService.getProductPaginate(pageno, 6);
        model.addAttribute("products", productList);
        model.addAttribute("currentPage", pageno);
        model.addAttribute("totalPages", productList.getTotalPages());
        model.addAttribute("totalItem", productList.getTotalElements());
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturer());
        model.addAttribute("suppliers", supplierService.getAllSupplier());
        model.addAttribute("cartCount", GlobalData.cart.size());

        return "shop";
    }


    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable int id) {
        model.addAttribute("categories", categoryService.getAllCategory());
        model.addAttribute("manufacturers", manufacturerService.getAllManufacturer());
        model.addAttribute("suppliers", supplierService.getAllSupplier());
        model.addAttribute("products", productService.getAllProductsByCategoryId(id));
        return "shop";
    }

    @GetMapping("/shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.getProductById(id).get());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "viewProduct";
    }

    

    
}
