package streams.ch12;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Ordering {
	
	public static void main(String[] args) {
		List<String> vowels = Arrays.asList("a","e","i","o","u");
		//seq
		System.out.println("\nSeqential forEach:");
		
		//sequential
		vowels.stream()
		      .peek(e -> System.out.print("Visting : "+e +"#"))
		      .forEach(System.out::print);
		
		System.out.println("\nParallel forEach:");

		//Visited in parallel but final can be other than encounter 
		vowels.parallelStream()
		      .map(e ->mapper(e))
	      	  .forEach(e -> System.out.print("Final "+ e+ "#"));
		
		//Visited in parallel but final will be encounter order
		System.out.println("\nParallel forEach Ordered:");
		vowels.parallelStream()
		      .map(e ->mapper(e))
         	  .forEachOrdered( e -> System.out.print("Final "+ e + "#"));
		
		//parallel but encounter order at end - list
		System.out.println("\nParallel List:");
		
		List<String> opList = vowels.parallelStream()
									.peek(v ->System.out.println(v))
									.collect(Collectors.toList());
		System.out.println(opList);
		
		//parallel but no order at end - set
		System.out.println("\nParallel Set:");
		
		Set<String> opSet = vowels.parallelStream()		 
								  .peek(v ->System.out.println(v))
								  .collect(Collectors.toSet());
		System.out.println(opSet);
	}
	
	private static String mapper(String vowel) {
		System.out.print("Mapper: "+vowel + "#");
		return vowel;
	}

}
