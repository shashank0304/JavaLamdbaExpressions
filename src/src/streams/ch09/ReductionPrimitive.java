package streams.ch09;

import java.util.Arrays;
import java.util.List;

public class ReductionPrimitive {
	
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("I","am"," ", "learning","reductions","streams");
		
		int totalLength = words.stream()
		   		   			   .filter(s -> !s.isBlank())
		   		   			   .mapToInt(s -> s.length())
		   		   			   .reduce(0, (int a, int b) -> a+b);
		
		System.out.println(totalLength);
		
		int totalLengthBoxed = words.stream()
							   		.filter(s -> !s.isBlank())
							   		.map(s -> s.length())
							   		.reduce(0, (Integer a, Integer b) -> a+b);
		
		System.out.println(totalLengthBoxed);

	}

}
