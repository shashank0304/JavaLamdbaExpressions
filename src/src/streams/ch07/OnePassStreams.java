package streams.ch07;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class OnePassStreams {
	
	public static void main(String[] args) {
		List<String> strings = Arrays.asList("I", "am", "learning", "Lambdas", 
				                            "and", "Streams");		
		List<String> output =  strings.stream()
				                      .filter(OnePassStreams::isMoreThan3Characters)
				                      .map(OnePassStreams::convertToUpperCase)
				                      .collect(Collectors.toList());
		System.out.println(output);
	}
	
	public static boolean isMoreThan3Characters(String input) {
		System.out.println("Checking length of : "+input);
		return input.length() >3;
	}
	
	public static String convertToUpperCase(String input) {
		System.out.println("Will convert to upper case :"+input);
		return input.toUpperCase();
	}

}
