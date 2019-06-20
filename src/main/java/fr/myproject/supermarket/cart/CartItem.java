package fr.myproject.supermarket.cart;

import java.math.BigDecimal;

import fr.myproject.supermarket.product.Product;

public class CartItem {
	
	private Product product;
	private BigDecimal quantity;
	
	
	public CartItem(Product product, BigDecimal quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}


}
