package lambdas.ch02.exercise.strategy;

import java.math.BigDecimal;

import lambdas.ch02.exercise.Item;

public class ShoppingCartStrategyTest {
	
	
	public static void main(String[] args) {
		
		Item item1 = new Item("Phone",BigDecimal.valueOf(200.00));
		Item item2 = new Item("Laptop",BigDecimal.valueOf(800.00));
		Item item3 = new Item("Paper",BigDecimal.valueOf(10.00));
		
		ShoppingCartStrategy shoppingCartStrategy = new ShoppingCartStrategy();
		shoppingCartStrategy.addItem(item1);
		shoppingCartStrategy.addItem(item2);
		shoppingCartStrategy.addItem(item3);
		
		PaymentStrategy paymentStrategy = new CreditCardStrategy();
		//System.out.println(shoppingCartStrategy.pay(paymentStrategy));
		System.out.println(shoppingCartStrategy.pay(paymentStrategy));
	}
}
