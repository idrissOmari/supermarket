package fr.myproject.supermarket;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import fr.myproject.supermarket.cart.Cart;
import fr.myproject.supermarket.order.Order;
import fr.myproject.supermarket.product.Product;
import fr.myproject.supermarket.product.ProductUnit;
import junit.framework.Assert;

public class UnitProductTest {

	private Cart cart;

	private MarketManager manager = new MarketManager();

	private Product canOfBeans;

	private Product coke;

	@Before
	public void setUp() {
		cart = new Cart();
		canOfBeans = new Product("canOfBeans", new BigDecimal(0.65), ProductUnit.PIECE);
		coke = new Product("coke", new BigDecimal(1.25), ProductUnit.PIECE);
	}

	@Test
	public void addOneNormalProductTest() {
		cart.addItem(canOfBeans, BigDecimal.ONE);
		Order order = manager.processCart(cart);
		Assert.assertEquals(0.65, order.getTotal());
	}

	@Test
	public void addTwoNormalProductTest() {
		cart.addItem(canOfBeans, BigDecimal.ONE);
		cart.addItem(coke, BigDecimal.ONE);
		Order order = manager.processCart(cart);
		Assert.assertEquals(1.9, order.getTotal());
	}

	@Test
	public void addOneNormalProductTwiceTest() {
		cart.addItem(canOfBeans, BigDecimal.ONE);
		cart.addItem(canOfBeans, BigDecimal.ONE);
		Order order = manager.processCart(cart);
		Assert.assertEquals(1.3, order.getTotal());
	}

}
