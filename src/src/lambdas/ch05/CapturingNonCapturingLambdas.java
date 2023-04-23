package lambdas.ch05;

import java.util.function.IntPredicate;

public class CapturingNonCapturingLambdas {

	public static void main(String[] args) {

		int maxValue = 100;

		IntPredicate compareCapture = (int val) -> val > maxValue;
		System.out.println("Found bigger value : " + compareCapture.test(200));

		IntPredicate noCapture = (int val) -> val > 100;
		System.out.println("Found bigger value : " + noCapture.test(50));

	}

}
