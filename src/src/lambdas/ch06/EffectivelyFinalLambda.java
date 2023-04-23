package lambdas.ch06;

import java.util.function.Supplier;

//Effectively final local variables
public class EffectivelyFinalLambda {

	// x and y - effectively final
	static void test1(int x) {
		int y = 1;
		supply(() -> x + y);
	}

	// x and y are both effectively final.
	void test2(int x) {
		int y;
		y = 1;
		supply(() -> x + y);
	}

	// Notice that if condition could return false and y will be unassigned.
	void test3(int x) {
		int y;
		if (x > 10)
			y = 1;
//		supply(() -> x+y);
	}

	// x and y are both effectively final.
	void test4(int x) {
		int y;
		if (x > 10)
			y = 1;
		else
			y = 2;
		supply(() -> x + y);
	}

	// y is not effectively final. -> if condition could be true, y will be assigned
	// twice.

	void test5(int x) {
		int y;
		if (x > 10)
			y = 1;
		y = 2;
		//supply(() -> x+y);
	}

	// x is not effectively final.
	
	void test6(int x) {
		//supply(() -> x + 1);
		x++;
	}

	private static void supply(Supplier<Integer> r) {
		System.out.println(r.get());
	}

	public static void main(String[] args) {
		test1(20);
	}

}
