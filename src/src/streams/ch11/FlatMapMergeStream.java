package streams.ch11;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapMergeStream {
	
	public static void main(String[] args) throws IOException {
		
		List<Integer> system1 = Arrays.asList(1,2,3,4);
		List<Integer> system2 = Arrays.asList(5,6,7);
		List<Integer> system3 = Arrays.asList(8,9,10);
		
		Stream<List<Integer>> numbers = Stream.of(system1,system2,system3);
		
		/* Attempt one.
		List<List<Integer>> merged = numbers.map(num -> num)
				                         	.collect(Collectors.toList());
		System.out.println(merged);
		
		//Attempt two.
		List<Stream<Integer>> mergedStream = numbers.map(num -> num.stream())
													.collect(Collectors.toList());
		System.out.println(mergedStream);
		
		*/
		//Attempt three.
		List<Integer> mergedStreamHammeredOut = numbers.flatMap(num -> num.stream())
													   .collect(Collectors.toList());
		System.out.println(mergedStreamHammeredOut);
	}

}
