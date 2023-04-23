package lambdas.ch02.exercise.strategy;

import java.math.BigDecimal;

import lambdas.ch02.exercise.PaymentStatus;

public class DebitCardPayment implements PaymentStrategy {

	@Override
	public PaymentStatus pay(BigDecimal money) {
		System.out.println("Paying by debit card : " + money);
		return PaymentStatus.SUCCESS;
	}

}
