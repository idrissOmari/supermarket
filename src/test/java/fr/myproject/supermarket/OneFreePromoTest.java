package fr.myproject.supermarket;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import fr.myproject.supermarket.cart.Cart;
import fr.myproject.supermarket.order.Order;
import fr.myproject.supermarket.product.Product;
import fr.myproject.supermarket.product.ProductUnit;
import fr.myproject.supermarket.promo.OneFreePromo;
import junit.framework.Assert;

public class OneFreePromoTest {

	private Cart cart;

	private MarketManager manager = new MarketManager();

	private Product canOfBeans;


	@Before
	public void setUp() {
		cart = new Cart();
		canOfBeans = new Product("canOfBeans", new BigDecimal(0.65),ProductUnit.PIECE);
		OneFreePromo oneCanOffers = new OneFreePromo("buy two can and get one free", canOfBeans, BigDecimal.valueOf(3));
		manager.addPromo(oneCanOffers);
	}

	/**
	 * 0.65 * 3 = 1.95
	 * discount  -0.65	
	 * total    = 1.3
	 */
	@Test
	public void twoOneFreeTest() {
		cart.addItem(canOfBeans, BigDecimal.valueOf(3));
		Order order = manager.processCart(cart);
		Assert.assertEquals(1.3, order.getTotal());
	}
	
	/**
	 * 0.65 * 5 = 3.25
	 * discount  -0.65	
	 * total    = 2.6
	 */
	@Test
	public void twoOneFreeFiveItemTest() {
		cart.addItem(canOfBeans, BigDecimal.valueOf(5));
		Order order = manager.processCart(cart);
		Assert.assertEquals(2.6, order.getTotal());
	}
	
	/**
	 * 0.65 * 6 = 3.9
	 * discount  -1.3	
	 * total    = 2.6
	 */
	@Test
	public void twoOneFreeTwiceTest() {
		cart.addItem(canOfBeans, BigDecimal.valueOf(6));
		Order order = manager.processCart(cart);
		Assert.assertEquals(2.6, order.getTotal());
	}
}
