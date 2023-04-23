package lambdas.ch02.exercise.strategy;

import java.math.BigDecimal;

import lambdas.ch02.exercise.PaymentStatus;

public class CreditCardStrategy implements PaymentStrategy {

	@Override
	public PaymentStatus pay(BigDecimal money) {
		
		System.out.println("Paid on Credit Card:"+money);
		return PaymentStatus.SUCCESS;
	}

}
