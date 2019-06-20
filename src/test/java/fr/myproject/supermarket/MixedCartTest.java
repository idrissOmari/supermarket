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

public class MixedCartTest {

	private Cart cart;

	private MarketManager manager = new MarketManager();

	private Product canOfBeans;

	private Product almond;
	
	private Product tomato;

	@Before
	public void setUp() {
		cart = new Cart();
		canOfBeans = new Product("canOfBeans", new BigDecimal(0.65), ProductUnit.PIECE);
		almond = new Product("almond", new BigDecimal(0.47), ProductUnit.OUNCE);
		tomato = new Product("tomato", new BigDecimal(1.99), ProductUnit.POUND);
		PackagePromo packageOfFive = new PackagePromo(tomato, BigDecimal.valueOf(1), BigDecimal.valueOf(1));
		manager.addPromo(packageOfFive);
	}

	/**
	 * 0.65 + 0.47 * 1.4 = 1.31
	 * 
	 */
	@Test
	public void mixedTypeProductTest() {
		cart.addItem(canOfBeans, BigDecimal.ONE);
		cart.addItem(almond, BigDecimal.valueOf(1.4));
		Order order = manager.processCart(cart);
		Assert.assertEquals(1.31, order.getTotal());
	}
	
	/**
	 * 0.65 + 16 * 1.99 / 16 ounces = 2.64
	 *      discount 16 ounces ->1  = 0.99
	 */
	@Test
	public void mixedTypeProductWithPromoTest() {
		cart.addItem(tomato, BigDecimal.valueOf(16));
		cart.addItem(canOfBeans, BigDecimal.ONE);
		Order order = manager.processCart(cart);
		Assert.assertEquals(1.65, order.getTotal());
	}
}
