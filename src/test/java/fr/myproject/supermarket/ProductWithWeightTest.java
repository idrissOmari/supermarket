package fr.myproject.supermarket;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import fr.myproject.supermarket.cart.Cart;
import fr.myproject.supermarket.order.Order;
import fr.myproject.supermarket.product.Product;
import fr.myproject.supermarket.product.ProductUnit;
import junit.framework.Assert;

public class ProductWithWeightTest {

	private Cart cart;

	private MarketManager manager = new MarketManager();

	private Product almond;
	
	private Product tomato;


	@Before
	public void setUp() {
		cart = new Cart();
		almond = new Product("almond", new BigDecimal(0.47), ProductUnit.OUNCE);
		tomato = new Product("tomato", new BigDecimal(1.99), ProductUnit.POUND);
	}

	/**
	 * 20 * 0.47 = 9.4
	 * 
	 */
	@Test
	public void productWithOunceTest() {
		cart.addItem(almond, BigDecimal.valueOf(20));
		Order order = manager.processCart(cart);
		Assert.assertEquals(9.4, order.getTotal());
	}
	
	/**
	 * 4 * 1.99 / 16 ounces = 0.5
	 * 
	 */
	@Test
	public void productWithPoundTest() {
		cart.addItem(tomato, BigDecimal.valueOf(4));
		Order order = manager.processCart(cart);
		Assert.assertEquals(0.5, order.getTotal());
	}
}
