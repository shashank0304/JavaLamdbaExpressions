package streams.ch08.exercise;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TakeWhileListSet {
	
	public static void main(String[] args) {
		
		List<Integer> nList = List.of(2,3432,4,1,3,5,8,9,20);
		System.out.println("List -> "+ nList);
		List<Integer> fromList  = nList.stream()
                .peek(System.out::println)
                .takeWhile( e-> e % 2 == 0)
                .collect(Collectors.toList());
		System.out.println("Output from list->" + fromList);

		Set<Integer> nSet = Set.of(2,3432,4,1,3,5,8,9,20);
		System.out.println("Set -> "+nSet);
		List<Integer> fromSet  = nSet.stream()
					                 .peek(System.out::println)
				                     .takeWhile( e-> e % 2 == 0)
				                     .collect(Collectors.toList());
		
		System.out.println("Output from Set->"+fromSet);
	}

}
