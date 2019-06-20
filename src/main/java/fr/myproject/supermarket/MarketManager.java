package fr.myproject.supermarket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import fr.myproject.supermarket.cart.Cart;
import fr.myproject.supermarket.cart.CartItem;
import fr.myproject.supermarket.order.Order;
import fr.myproject.supermarket.order.OrderItem;
import fr.myproject.supermarket.product.Product;
import fr.myproject.supermarket.promo.Promo;

public class MarketManager {

	private Map<Product, Promo> allPromos = new HashMap<>();

	/**
	 * Method to build the order for the cart.
	 * 
	 * @param cart
	 * @return
	 */
	public Order processCart(Cart cart) {
		Order order = new Order();
		Optional<List<CartItem>> listItems = cart.getCartItems();
		if (listItems.isPresent()) {
			listItems.get().stream().map(OrderItem::new).forEach(oi -> order.addOrderItem(oi));
			applyOffers(order, cart);
		}
		return order;
	}


	/**
	 * Apply available offers
	 * 
	 * @param order
	 * @param cart
	 */
	private void applyOffers(Order order, Cart cart) {
		Map<Product, BigDecimal> quantityProduct = cart.getProductQuantity();
		quantityProduct.keySet().stream()
		.filter(prd -> allPromos.containsKey(prd)).forEach(prd ->processPromo(order, quantityProduct, prd));
	}

	/**
	 * To process each promo
	 * @param order
	 * @param quantityProduct
	 * @param product
	 */
	private void processPromo(Order order, Map<Product, BigDecimal> quantityProduct, Product product) {
		allPromos.get(product).processPromo(order, quantityProduct.get(product));
	}
	
	/**
	 * Adding available promos
	 * @param promo
	 */
	public void addPromo(Promo promo) {
		allPromos.put(promo.getProduct(), promo);

	}

}
