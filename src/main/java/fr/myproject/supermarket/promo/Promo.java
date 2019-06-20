package fr.myproject.supermarket.promo;

import java.math.BigDecimal;

import fr.myproject.supermarket.order.Order;
import fr.myproject.supermarket.product.Product;

public abstract class Promo {

	private String name;
	private Product product;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	
	public abstract void processPromo(Order order, BigDecimal quantity);
}
