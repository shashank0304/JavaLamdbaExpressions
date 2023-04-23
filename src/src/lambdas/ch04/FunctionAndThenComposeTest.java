package lambdas.ch04;

import java.math.BigDecimal;
import java.util.function.Function;

public class FunctionAndThenComposeTest {

	public static void main(String[] args) {
		System.out.println("\nDifference between andThen and Compose: ");
		BigDecimal profit = BigDecimal.valueOf(20_000.00);

		// 10 % hike
		Function<BigDecimal, BigDecimal> tenPercentHike = (s) -> s.add(s.multiply(BigDecimal.valueOf(0.1)));

		// fixed component
		Function<BigDecimal, BigDecimal> unitPerformance = (t) -> t.add(BigDecimal.valueOf(1000.00));
		                                     // ------------->
		BigDecimal totalMoneyMade = tenPercentHike.andThen(unitPerformance).apply(profit);

		System.out.println(totalMoneyMade);
		                                     // <------------
		System.out.println(tenPercentHike.compose(unitPerformance).apply(profit));

	}

}
