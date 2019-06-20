package fr.myproject.supermarket.order;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<OrderItem> orders;
	private List<Discount> discounts;

	public Order() {
		orders = new ArrayList<>();
		discounts = new ArrayList<>();
	}

	public List<OrderItem> getOrders() {
		return orders;
	}

	public void setOrders(List<OrderItem> orders) {
		this.orders = orders;
	}

	/**
	 * Calculate total order
	 * 
	 * @return
	 */
	public double getTotal() {
		BigDecimal totalBD = BigDecimal.ZERO;
		BigDecimal discountBD = BigDecimal.ZERO;
		if (!orders.isEmpty()) {
			totalBD = orders.stream().map(OrderItem::getTotalPrice).reduce(BigDecimal::add).get();
			totalBD = new BigDecimal(totalBD.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		if (!discounts.isEmpty()) {
			discountBD = discounts.stream().map(Discount::getDiscountValue).reduce(BigDecimal::add).get();
			discountBD = new BigDecimal(discountBD.doubleValue()).setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		return totalBD.subtract(discountBD).doubleValue();
	}

	public void addOrderItem(OrderItem orderItem) {
		this.orders.add(orderItem);
	}

	public void addDiscount(Discount discount) {
		this.discounts.add(discount);
	}
}
