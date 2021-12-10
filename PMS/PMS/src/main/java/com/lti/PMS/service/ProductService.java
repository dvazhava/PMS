package com.lti.PMS.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.PMS.Dao.ProductDao;
import com.lti.PMS.model.Product;

@Service
@Transactional
public class ProductService {
	
	@Autowired
	ProductDao productdao;


	public Product createProduct(Product product) {
		// TODO Auto-generated method stub
		return productdao.save(product);
	}


	public Optional<Product> search(String category) {
		// TODO Auto-generated method stub
		return productdao.findbyCategory(category);
	}


	public Optional<Product> searchByName(String name) {
		// TODO Auto-generated method stub
		return productdao.findByName(name);
	}


	public Iterable<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return productdao.findAll();
	}





/*	public int calculatePrice(long productId) {
		
		Product prod= productdao.getById((int) productId);
		int qty=prod.getQuantity();
		int price=prod.getUnitPrice();
		int totalPrice=qty*price;
		// TODO Auto-generated method stub
		return totalPrice;
	}
*/

	public void removeProduct() {
		// TODO Auto-generated method stub
		List<Product> prod=productdao.findAll();
		List<Product> filteredRecord=prod.stream().filter(p->p.getRating() < 2).collect(Collectors.toList());
		
		for(Product p : filteredRecord) {
			productdao.delete(p);
		}
		
	}


	public void totalPrice() {
		// TODO Auto-generated method stub
		
		List<Product> prod=productdao.findAll();
		
		for(Product p: prod) {
		int totalprice=	p.getQuantity() * p.getUnitPrice();
		//Product updatedproduct= new Product();
		p.setTotalprice(totalprice);
		productdao.save(p);
		}
	}
	

}
