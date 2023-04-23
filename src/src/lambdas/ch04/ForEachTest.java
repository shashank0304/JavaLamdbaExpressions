package lambdas.ch04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ForEachTest {

	public static void main(String[] args) {

		List<String> strings = getData();

		// Using iterator
		System.out.println("\nUsing Iterator...");
		for (Iterator<String> itr = strings.iterator(); itr.hasNext();) {
			String s = itr.next();
			System.out.println(s);
		}

		// Enhanced for-loop
		System.out.println("\nEnhanced for-loop...");
		for (String s : strings) {
			System.out.println(s);
		}

		// takes consumer
		System.out.println("\nUsing forEach...");
		strings.forEach(s -> System.out.println(s));
		
	}

	private static List<String> getData() {
		List<String> strings = new ArrayList<>();
		strings.add("I");
		strings.add("am");
		strings.add("learning");
		strings.add("lambdas");
		return strings;

	}
}
