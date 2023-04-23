package lambdas.ch02.exercise.strategy;

import java.math.BigDecimal;

import lambdas.ch02.exercise.Item;

//Solution to shopping cart exercise using Strategy pattern
public class ShoppingCartStrategyTest {
	
	public static void main(String[] args) {
		Item item1 = new Item("Phone",BigDecimal.valueOf(200.00));
		Item item2 = new Item("Laptop",BigDecimal.valueOf(800.00));
		Item item3 = new Item("Paper",BigDecimal.valueOf(10.00));
		
		ShoppingCartStrategy shoppingCart = new ShoppingCartStrategy();
		shoppingCart.addItem(item1);
		shoppingCart.addItem(item2);
		shoppingCart.addItem(item3);
			
		//Testing with strategy.
		System.out.println(shoppingCart.pay(new CreditCardPayment()));	
	}

}
