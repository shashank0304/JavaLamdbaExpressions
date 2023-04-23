package lambdas.ch02.exercise.strategy;

import java.math.BigDecimal;

import lambdas.ch02.exercise.PaymentStatus;

public class CashOnDeliveryStrategy implements PaymentStrategy {

	@Override
	public PaymentStatus pay(BigDecimal money) {
		// TODO Auto-generated method stub
		System.out.println("Pay cash on delivery:"+money);
		return PaymentStatus.PENDING;
	}

}
