package com.ssangu.lambdas.sec04.test;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

import com.ssangu.lambdas.sec04.Coupons;

public class SupplierTest {
	public static void main(String[] args) {
		
		Supplier<Integer> val = () -> 42;
		System.out.println(val.get());
		
		IntSupplier valIntSupplier = () -> 43;
		System.out.println(valIntSupplier.getAsInt());
		
		System.out.println("Two Coupons:");
		System.out.println(Coupons.getAvailableCoupons(2, Coupons.getCoupon()));
		
		System.out.println("All coupons below 500$");
		System.out.println(Coupons.getAvailableCoupons(6, Coupons.getCouponsUpto500$()));
		
		System.out.println("Get Top Valued Coupon");
		Supplier<String> topValuedCoupon = Coupons.getTopValuedCoupon();
		System.out.println(Coupons.getAvailableCoupons(1, topValuedCoupon));
	}
}
