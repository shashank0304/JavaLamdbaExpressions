package lambdas.ch04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {

	public static void main(String[] args) {

		// void accept(T t);

		// Example one - Simple consumer
		System.out.println("Example 1 - Display on console  ");

		Consumer<String> simpleDisplay = (s) -> System.out.println(s);
		simpleDisplay.accept("lambdas");

		// Example two - store string in database
		System.out.println("\nExample 2 - Storing in db  ");

		Consumer<String> updateDB = str -> storeInDB(str);
		updateDB.accept("lambdas");

		// Example three - Method accepts Consumer as parameter.
		System.out.println("\nExample 3 - Consumer as parameter ");
		performOperationWith("lambdas", simpleDisplay);
		performOperationWith("lambdas", updateDB);

		// Example four - Formatting strings.
		System.out.println("\nExample 4 - Formatting strings");

		Consumer<String> displayWithSpaces = (s) -> System.out.println(String.format("%10s", s));
		performOperationWith("lambdas", displayWithSpaces);

		// Example five - Shows andThen in action.
		System.out.println("\nExample 5 - Chaining - andThen()");

		StringBuilder stringBuilder = new StringBuilder("lambdas");

		// "lambdasLAMBDAS"
		Consumer<StringBuilder> changeCase = sb -> sb.append(sb.toString().toUpperCase());

		Consumer<StringBuilder> print = (s) -> display(s);

		// Chain behavior
		Consumer<StringBuilder> chained = changeCase.andThen(print);
		chained.accept(stringBuilder);
		// changeCase.andThen(print).accept(stringBuilder);

		// Using generics
		System.out.println("\nExample using generics-");

		List<String> strings = Arrays.asList("java", "lamdbas", "spring");
		performOperationWithGenerics(strings, (s) -> System.out.println(s.toUpperCase()));
		
		List<Integer> integers = Arrays.asList(1, 2, 3);

		performOperationWithGenerics(integers , (Integer number) -> System.out.println(number*2));

	}

	private static void storeInDB(String input) {
		if (null != input)
			System.out.println("Storing the input - " + input + " in database...");
	}

	private static void display(StringBuilder string) {
		System.out.println(string);
	}

	// passing behavior
	private static <T> void performOperationWith(String s, Consumer<String> operation) {
		if (null != s)
			operation.accept(s);
	}

	// passing behavior
	private static <T> void performOperationWithGenerics(List<T> input, Consumer<T> operation) {
		if (null != input) {
			for (T t : input) {
				operation.accept(t);
			}
		}
	}

}
