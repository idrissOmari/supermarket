package fr.myproject.supermarket.promo;

import java.math.BigDecimal;

import fr.myproject.supermarket.order.Discount;
import fr.myproject.supermarket.order.Order;
import fr.myproject.supermarket.product.Product;
import fr.myproject.supermarket.product.ProductUnit;
import fr.myproject.supermarket.utils.Constants;

public class PackagePromo extends Promo {

	private BigDecimal quantity;
	private BigDecimal promoPrice;

	public PackagePromo(Product product, BigDecimal quantity, BigDecimal promoPrice) {
		setName(quantity + " for " + promoPrice);
		setProduct(product);
		this.quantity = quantity;
		this.promoPrice = promoPrice;
	}

	@Override
	public void processPromo(Order order, BigDecimal ordredQuantity) {

		if (ProductUnit.POUND.equals(getProduct().getUnit())) {
			ordredQuantity = ordredQuantity.divide(Constants.CONVERSION_TO_OUNCE);
		}
		
		if (ordredQuantity.doubleValue() >= quantity.doubleValue()) {
			BigDecimal priceProduct = this.getProduct().getPrice();

			int priceDiscount = promoPrice.multiply(ordredQuantity).divide(quantity).intValue();

			double priceNoDiscount = ordredQuantity.doubleValue() % quantity.doubleValue() * priceProduct.doubleValue();

			double totalWithDiscount = priceDiscount + priceNoDiscount;
			double discountValue = priceProduct.doubleValue() * ordredQuantity.doubleValue() - totalWithDiscount;
			Discount discount = new Discount(this.getProduct(), getName(),
					BigDecimal.valueOf(discountValue));
			order.addDiscount(discount);
		}

	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getPromoPrice() {
		return promoPrice;
	}

	public void setPromoPrice(BigDecimal promoPrice) {
		this.promoPrice = promoPrice;
	}

}
