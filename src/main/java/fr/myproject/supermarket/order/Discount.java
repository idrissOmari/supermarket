package fr.myproject.supermarket.order;

import java.math.BigDecimal;

import fr.myproject.supermarket.product.Product;

public class Discount {
	
	private Product product;
	private String  description;
	private BigDecimal discountValue;
	
	
	public Discount(Product product, String description, BigDecimal discountValue) {
		this.product = product;
		this.description = description;
		this.discountValue = discountValue;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BigDecimal getDiscountValue() {
		return discountValue;
	}
	public void setDiscountValue(BigDecimal discountValue) {
		this.discountValue = discountValue;
	}
	

}
