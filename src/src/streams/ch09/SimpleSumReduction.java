package streams.ch09;

import java.util.Arrays;
import java.util.List;

public class SimpleSumReduction {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList( 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 );
		
		//sum the usual way.
		sumImperative(numbers);

		//sum using stream
		sumDeclarative(numbers);
		
		//sum of all word-length : notice the blank word.
		List<String> words = Arrays.asList("I","am"," ", "learning","reductions","streams");
		
		int totalLength = 0;
		for(String word : words) {
			if(!word.isBlank())
			totalLength += word.length();
		}
		System.out.println(totalLength); //28
		
		//Total length using stream/reduce
		totalLength = words.stream()
						   .filter(s -> !s.isBlank())
						   .mapToInt(s -> s.length())
						   .boxed()
						   .reduce(0, Integer::sum);
						   
		System.out.println(totalLength); //28
		
		//sum is nothing but reduce
		totalLength = words.stream()
				   		   .filter(s -> !s.isBlank())
				   		   .mapToInt(s -> s.length())
				   		   .sum();
				   
		System.out.println(totalLength); //28
		
		
		//Exercise - find distinct words.
		int countWords = words.stream()
				   			  .filter(s -> !s.isBlank())
				              .mapToInt(s -> 1)
				              .reduce(0, (l1,l2) -> l1+l2);
		System.out.println(countWords);
		
	}

	public static void sumImperative(List<Integer> numbers) {
		int sum = 0;
		for (int num : numbers) {
			sum += num;
		}
		System.out.println("Sum the usual way : "+ sum);		
	}
	
	private static void sumDeclarative(List<Integer> numbers) {
		int sum = numbers.stream()
				         .mapToInt(Integer::intValue)
            	 		 .reduce(0,Integer::sum);
     
		System.out.println("Sum using streams : "+ sum);		
	}

}
