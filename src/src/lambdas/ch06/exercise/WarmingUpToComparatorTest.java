package lambdas.ch06.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Solution to WarmingUpToComparatorExercise.
 */
public class WarmingUpToComparatorTest {

	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("i", "am", "we", "learning", "lambdas");

		//anonymous class
		sortByLengthUsualWay(strings);
		
		//Lambdas
		sortByLengthLambdas(strings);
		
		//Using Comparator.comparing.
		sortByLengthComparing(strings);
	}

	public static void sortByLengthComparing(List<String> strings) {
		Comparator<String> byLength = Comparator.comparing((String s) -> s.length());
		strings.sort(byLength);

		//Method reference - uncomment the following.
		//Comparator<String> byLengthMR = Comparator.comparing(String::length);
		//strings.sort(byLengthMR);

		System.out.println(strings);
	}

	public static void sortByLengthLambdas(List<String> strings) {
		
		
		Comparator<String> byLength  = (s1, s2) -> {
			return Integer.compare(s1.length(),s2.length());
		};
		
		//Using sort from Collections.
		//Collections.sort(strings, byLength);
		
		//invoke sort on list.
		strings.sort(byLength);
		
		System.out.println(strings);
	}

	public static void sortByLengthUsualWay(List<String> strings) {
		// usual way.
		strings.sort(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return Integer.compare(o1.length(),o2.length());
			}
		});
		
		System.out.println(strings);
	}

}
