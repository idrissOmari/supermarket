package fr.myproject.supermarket.cart;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import fr.myproject.supermarket.product.Product;

public class Cart {

	private List<CartItem> cartItems;
	private Map<Product, BigDecimal> productQuantity;

	public Cart() {
		cartItems = new ArrayList<>();
		productQuantity = new HashMap<>();
	}

	public Optional<List<CartItem>> getCartItems() {
		return Optional.ofNullable(cartItems);
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public Map<Product, BigDecimal> getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Map<Product, BigDecimal> productQuantity) {
		this.productQuantity = productQuantity;
	}

	/**
	 * Add a product to the cart
	 * 
	 * @param product
	 * @param quantity
	 */
	public void addItem(Product product, BigDecimal quantity) {
		cartItems.add(new CartItem(product, quantity));
		if (productQuantity.containsKey(product)) {
			productQuantity.put(product, productQuantity.get(product).add(quantity));
		} else {
			productQuantity.put(product, quantity);
		}
	}

}
