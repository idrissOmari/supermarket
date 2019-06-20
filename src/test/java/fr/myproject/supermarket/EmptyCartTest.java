package fr.myproject.supermarket;

import org.junit.Before;
import org.junit.Test;

import fr.myproject.supermarket.cart.Cart;
import fr.myproject.supermarket.order.Order;
import junit.framework.Assert;

public class EmptyCartTest {
	
	private Cart cart;
	
	private MarketManager manager = new MarketManager();
	

	@Before
    public void setUp() {
        cart = new Cart();
    }

	@Test
	public void emptyCartTest() {
		   Order order = manager.processCart(cart);
		   Assert.assertEquals(0.0, order.getTotal());
	}
	

}
