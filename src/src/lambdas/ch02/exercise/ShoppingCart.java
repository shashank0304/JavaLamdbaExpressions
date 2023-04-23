package lambdas.ch02.exercise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

	private List<Item> items = new ArrayList<>();

	public void addItem(Item item) {
		items.add(item);
	}

	public PaymentStatus pay(PaymentType paymentType) {

		BigDecimal total = getTotal();

		if (paymentType == PaymentType.CREDIT_CARD) {
			System.out.println("Paying by credit card : " + total);
			return PaymentStatus.SUCCESS;
		} else if (paymentType == PaymentType.DEBIT_CARD) {
			System.out.println("Paying by credit card : " + total);
			return PaymentStatus.SUCCESS;
		} else if (paymentType == PaymentType.CASH_ON_DELIVERY) {
			System.out.println("Paying by cash on delivery : " + total);
			return PaymentStatus.PENDING;
		} // other types - see PaymentType

		return PaymentStatus.FAIL;
	}

	private BigDecimal getTotal() {
		BigDecimal total = BigDecimal.ZERO;
		for (Item item : items) {
			total = total.add(item.getPrice());
		}
		return total;
	}
}
