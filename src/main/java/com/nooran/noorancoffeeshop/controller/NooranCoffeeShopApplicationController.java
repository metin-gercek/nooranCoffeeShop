package com.nooran.noorancoffeeshop.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NooranCoffeeShopApplicationController {
    @GetMapping("/")
	public String showHomePage() {
		
		System.out.println("In Home Page");
		
		return "index";
	}
}
