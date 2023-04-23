package streams.ch08;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OptionalPatternExample {
	
	public static void main(String[] args) {
		System.out.println(firstMatch("stream").orElse("Could not find pattern..."));
		System.out.println(firstMatch("hello").orElse("Could not find pattern..."));
	}
	
	public static Optional<String> firstMatch(String pattern) {
		
		String text = "I am learning lambdas and learning streams";
		
	    Matcher m = Pattern.compile(pattern).matcher(text);
	    return m.find()? Optional.of(m.group()): Optional.empty();
	}
}
