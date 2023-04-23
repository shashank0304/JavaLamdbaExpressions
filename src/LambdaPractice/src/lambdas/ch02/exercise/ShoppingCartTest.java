package lambdas.ch02.exercise;

import java.math.BigDecimal;

public class ShoppingCartTest {
	
	public static void main(String[] args) {
		
		Item item1 = new Item("Phone",BigDecimal.valueOf(200.00));
		Item item2 = new Item("Laptop",BigDecimal.valueOf(800.00));
		Item item3 = new Item("Paper",BigDecimal.valueOf(10.00));
		
		ShoppingCart shoppingCart = new ShoppingCart();
		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);
		shoppingCart.addItem(item3);
		
		PaymentStatus paymentStatus = shoppingCart.pay(PaymentType.NET_BANKING);
		System.out.println("Payment Status:"+ paymentStatus);
		
	}
	
}
