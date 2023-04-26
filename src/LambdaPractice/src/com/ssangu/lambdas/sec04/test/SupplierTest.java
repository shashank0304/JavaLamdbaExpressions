package com.ssangu.lambdas.sec04.test;

import java.util.function.IntSupplier;
import java.util.function.Supplier;

public class SupplierTest {
	public static void main(String[] args) {
		
		Supplier<Integer> val = () -> 42;
		System.out.println(val.get());
		
		IntSupplier valIntSupplier = () -> 43;
		System.out.println(valIntSupplier.getAsInt());
	}
}
