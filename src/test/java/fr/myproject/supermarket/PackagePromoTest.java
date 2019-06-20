package fr.myproject.supermarket;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import fr.myproject.supermarket.cart.Cart;
import fr.myproject.supermarket.order.Order;
import fr.myproject.supermarket.product.Product;
import fr.myproject.supermarket.product.ProductUnit;
import fr.myproject.supermarket.promo.PackagePromo;
import junit.framework.Assert;

public class PackagePromoTest {

	private Cart cart;

	private MarketManager manager = new MarketManager();

	private Product canOfBeans;

	@Before
	public void setUp() {
		cart = new Cart();
		canOfBeans = new Product("canOfBeans", new BigDecimal(0.65), ProductUnit.PIECE);
		PackagePromo packageOfFive = new PackagePromo(canOfBeans, BigDecimal.valueOf(5), BigDecimal.valueOf(2));
		manager.addPromo(packageOfFive);
	}

	/**
	 * 0.65 * 5 = 2.0
	 * 
	 */
	@Test
	public void packageFiveForFiveTest() {
		cart.addItem(canOfBeans, BigDecimal.valueOf(5));
		Order order = manager.processCart(cart);
		Assert.assertEquals(2.0, order.getTotal());
	}
	
	/**
	 * 0.65 * 3 = 1.95
	 * 
	 */
	@Test
	public void packageFiveForThreeTest() {
		cart.addItem(canOfBeans, BigDecimal.valueOf(3));
		Order order = manager.processCart(cart);
		Assert.assertEquals(1.95, order.getTotal());
	}
	
	
	/**
	 * 0.65 * 10 = 4.0
	 * 
	 */
	@Test
	public void packageFiveForTenTest() {
		cart.addItem(canOfBeans, BigDecimal.valueOf(10));
		Order order = manager.processCart(cart);
		Assert.assertEquals(4.0, order.getTotal());
	}
	
	/**
	 * 0.65 * 11 = 4.0 + 0.65 = 4.65
	 * 
	 */
	@Test
	public void packageFiveForElevenTest() {
		cart.addItem(canOfBeans, BigDecimal.valueOf(11));
		Order order = manager.processCart(cart);
		Assert.assertEquals(4.65, order.getTotal());
	}
}
