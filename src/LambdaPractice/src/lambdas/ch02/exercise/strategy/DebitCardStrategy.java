package lambdas.ch02.exercise.strategy;

import java.math.BigDecimal;

import lambdas.ch02.exercise.PaymentStatus;

public class DebitCardStrategy implements PaymentStrategy {

	@Override
	public PaymentStatus pay(BigDecimal money) {
		// TODO Auto-generated method stub
		System.out.println("Debit Card paid:"+money);
		return PaymentStatus.SUCCESS;
	}

}
