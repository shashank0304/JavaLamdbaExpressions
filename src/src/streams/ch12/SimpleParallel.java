package streams.ch12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimpleParallel {
	
	public static void main(String[] args) {
		
		parallelStream();		
		parallelOrSequentialStream();
		
	}
	
	public static void parallelStream() {
		
		List<Integer> numbers = Arrays.asList(1,2,45,220,420,735);
		
		List<Integer> evenNumbersDoubled = numbers.parallelStream()
										          .filter( n -> n % 2 == 0)
										          .map( n -> n * 2)										         
		                                          .collect(Collectors.toList());
		System.out.println(evenNumbersDoubled);
	}
	
	public static void parallelOrSequentialStream() {
		
		List<Integer> numbers = Arrays.asList(1,2,45,220,420,735);
		
		Stream<Integer> evenNumbersDoubled = numbers.stream()
										            .filter( n -> n % 2 ==0)
										            .parallel()
										            .map( n -> n * 2)
										            .sequential();
		
		System.out.println(evenNumbersDoubled.isParallel());		
	}
}
