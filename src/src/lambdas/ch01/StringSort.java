package lambdas.ch01;

import static java.util.Comparator.comparing;
import static java.util.Comparator.naturalOrder;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Example shows how to sort strings by length using verbose style and concise style
 *
 */
public class StringSort {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("Biggest", "at", "ate", "I", "apple", "ball", "cat", "rhino",
				"series");

		System.out.println("\n-----Sorting-----\n");

		System.out.println("Imperative : ");
		imperativeSort(strings);
		System.out.println(strings);

		System.out.println("Functional : ");
		System.out.println(functionalSort(strings));

	}

	//Verbose
	public static void imperativeSort(List<String> strings) {
		strings.sort(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {

				if (s1.length() > s2.length()) {
					return 1;
				} else if (s1.length() < s2.length()) {
					return -1;
				}
				return s1.compareTo(s2);
			}
		});
	}

	//Concise
	public static List<String> functionalSort(List<String> strings) {
		
		return strings.stream()
				      .sorted(comparing(String::length).thenComparing(naturalOrder()))
				      .collect(Collectors.toList());
		
	}

}
