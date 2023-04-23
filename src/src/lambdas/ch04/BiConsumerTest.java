package lambdas.ch04;

import java.util.HashMap;
import java.util.Map;

public class BiConsumerTest {
	public static void main(String[] args) {
		Map<Integer, String> lengthString = new HashMap<>();

		lengthString.put(4, "java");
		lengthString.put(6, "spring");
		lengthString.put(7, "lambdas");

		System.out.println("Usual way: ");
		// Typical way.
		for (Map.Entry<Integer, String> entrySet : lengthString.entrySet()) {
			System.out.print("Key is:" + entrySet.getKey());
			System.out.println(" Value is:" + entrySet.getValue());
		}

		System.out.println("\nUsing Lambdas: ");
		// Using Lambda
		lengthString.forEach((key, value) -> System.out.println("Key is:" + key + " Value is:" + value));

	}

}
