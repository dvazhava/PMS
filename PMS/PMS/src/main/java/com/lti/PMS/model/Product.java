package com.lti.PMS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="smartshop")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	@Column (name = "name", nullable = false)
	private String name;
	
	@Column (name = "category", nullable = false)
	private String category;
	
	@Column (name = "quantity", nullable = false)
	private int quantity;
	
	@Column (name = "unitPrice", nullable = false)
	private int unitPrice;
	
	@Column (name = "totalprice", nullable = true)
	private int totalprice;
	
	@Column (name = "rating", nullable = false)
	private int rating;
	
	public Product() {
		super();
	}

	public Product(int productId, String name, String category, int quantity, int unitPrice, int totalprice,
			int rating) {
		super();
		this.productId = productId;
		this.name = name;
		this.category = category;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
		this.totalprice = totalprice;
		this.rating = rating;
	}

	

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(int unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", category=" + category + ", quantity="
				+ quantity + ", unitPrice=" + unitPrice + ", totalprice=" + totalprice + ", rating=" + rating + "]";
	}
	
	

}
