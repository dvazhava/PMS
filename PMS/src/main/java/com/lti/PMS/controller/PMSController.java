package com.lti.PMS.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.PMS.model.Product;
import com.lti.PMS.service.ProductService;

@RestController
@RequestMapping("/product")
public class PMSController {
	
	@Autowired
	ProductService productservice;
	
	@PostMapping("/display")
	public Product createProduct(@RequestBody Product product) {
		
		return productservice.createProduct(product);
		
	}
	
	@GetMapping("/display/{category}")
	public Optional<Product> SearchProduct(@PathVariable("category") String category){
		return productservice.search(category);
	}
	

	@GetMapping("/show/{name}")
	public Optional<Product> SearchProductName(@PathVariable("name") String name){
		return productservice.searchByName(name);
	}
	
	@GetMapping("/viewAll")
	public List<Product> getAllProduct(){
		return (List<Product>) productservice.getAllProduct();
	}
	
	/*
	@PutMapping("/calculateTotalPrice/{productId}")
	public int totalPrice(@PathVariable("productId") long productId) {
		return  productservice.calculatePrice(productId);
		
	}*/
	
	@PutMapping("/update/{id}")
	public String updateProduct(@RequestBody Product product) {
		Product product1= new Product();
		product1.setCategory(product.getCategory());
		product1.setName(product.getName());
		product1.setQuantity(product.getQuantity());
		product1.setRating(product.getRating());
		product1.setUnitPrice(product.getUnitPrice());
		productservice.createProduct(product1);
		return "updated successfully";
	}
	
	@PutMapping("/remove")
	public String removeProduct() {
		productservice.removeProduct();
		return "success";
		
	}
	
	@PutMapping("/totalPrice")
	public String totalPrice() {
		productservice.totalPrice();
		return "price calculated";
	}
	

	

}
