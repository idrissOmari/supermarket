package fr.myproject.supermarket.order;

import java.math.BigDecimal;

import fr.myproject.supermarket.cart.CartItem;
import fr.myproject.supermarket.product.Product;
import fr.myproject.supermarket.product.ProductUnit;
import fr.myproject.supermarket.utils.Constants;

public class OrderItem {
	
	private Product product;
	private BigDecimal quantity;
	private BigDecimal totalPrice;
	
	
	public OrderItem(Product product, BigDecimal quantity, BigDecimal totalPrice) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
	}
	
	public OrderItem(CartItem ci) {
		Product product = ci.getProduct();
		BigDecimal unitPrice = product.getPrice();
		BigDecimal quantity = ci.getQuantity();

		if (ProductUnit.POUND.equals(product.getUnit())) {
			quantity = quantity.divide(Constants.CONVERSION_TO_OUNCE);
		}
		this.product = product;
		this.quantity = quantity;
		this.totalPrice = unitPrice.multiply(quantity);
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
	public BigDecimal getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(BigDecimal totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	

}
