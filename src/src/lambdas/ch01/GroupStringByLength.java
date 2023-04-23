package lambdas.ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Example shows how to group strings by length using verbose style 
 * and concise style
 *
 */
public class GroupStringByLength {

	public static void main(String[] args) {
		
		List<String> strings = Arrays.asList("Biggest", "at", "ate", "I", 
				"apple", "ball", "cat", "rhino","series");

		System.out.println("Old Style : ");
		imperativeByLength(strings);

		System.out.println("New Style : ");
		functionalByLength(strings);

	}

	//Verbose
	public static void imperativeByLength(List<String> strings) {

		Map<Integer, List<String>> lengthMap = new HashMap<>();
		for (String string : strings) {
			
			List<String> sameLength = null;
			Integer length = string.length();
			
			if (lengthMap.get(length) == null) {
				sameLength = new ArrayList<>();
				lengthMap.put(length, sameLength);
			} else {
				sameLength = lengthMap.get(length);			
			}
			sameLength.add(string);

		}
		System.out.println(lengthMap);
	}

	//Concise
	public static void functionalByLength(List<String> strings) {
		
		System.out.println(strings.stream()
				                  .collect(Collectors.groupingBy(String::length)));
	}

}
