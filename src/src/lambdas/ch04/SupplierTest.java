package lambdas.ch04;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierTest {
	public static void main(String[] args) {

		// T get();

		// Example one
		Supplier<Integer> val = () -> 42; //int
		System.out.println(val.get());

		// Example two - Better usage prevents boxing, auto-boxing.
		IntSupplier valIntSupplier = () -> 42;
		System.out.println(valIntSupplier.getAsInt());

		// Example three

		// 1. Get 2 coupons randomly
		System.out.println("Two coupons : ");
		System.out.println(Coupons.getAvailableCoupons(2, Coupons.getCoupon()));

		
		// 2. Get total of 6 coupons randomly but budget restricted to 500$
		
		System.out.println("All coupons upto 500 USD: ");
		System.out.println(Coupons.getAvailableCoupons(6, Coupons.getCouponUpto500$()));
		
		

		System.out.println("Getting top valued coupon: ");

		Supplier<String> getTopValuedCoupon = Coupons.getTopValuedCoupon();
		System.out.println(Coupons.getAvailableCoupons(1, getTopValuedCoupon));

	}

}
