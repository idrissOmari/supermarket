package fr.myproject.supermarket.product;

import java.math.BigDecimal;

public class Product {

	private String name;
	private BigDecimal price;
	private ProductUnit unit;
	
	public Product(String name, BigDecimal price, ProductUnit unit) {
		super();
		this.name = name;
		this.price = price;
		this.unit = unit;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public ProductUnit getUnit() {
		return unit;
	}

	public void setUnit(ProductUnit unit) {
		this.unit = unit;
	}
 
}
