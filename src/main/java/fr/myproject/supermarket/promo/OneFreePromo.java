package fr.myproject.supermarket.promo;

import java.math.BigDecimal;

import fr.myproject.supermarket.order.Discount;
import fr.myproject.supermarket.order.Order;
import fr.myproject.supermarket.product.Product;
import fr.myproject.supermarket.product.ProductUnit;
import fr.myproject.supermarket.utils.Constants;

public class OneFreePromo extends Promo {

	private BigDecimal quantity;

	public OneFreePromo(String name, Product product, BigDecimal quantity) {
		this.setName(name);
		this.setProduct(product);
		this.quantity = quantity;
	}


	@Override
	public void processPromo(Order order, BigDecimal orderedQuantity) {

		if (ProductUnit.POUND.equals(getProduct().getUnit())) {
			orderedQuantity = orderedQuantity.divide(Constants.CONVERSION_TO_OUNCE);
		}
		int numberOfFreeProduct = orderedQuantity.intValue() / quantity.intValue();
		
		Discount discount = new Discount(getProduct(), getName(),
				getProduct().getPrice().multiply(BigDecimal.valueOf(numberOfFreeProduct)));
		
		order.addDiscount(discount);

	}

	public BigDecimal getQuantity() {
		return quantity;
	}
	
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
}
