package streams.ch12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectInParallelStream {
	
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("add","eel","very","watt","i","owl","us");
		for(int i = 0 ; i<5 ;i ++) {

			List<String> vowels =
					words.parallelStream()
				     	 .filter(s -> startsWithVowel(s))
				         .collect(Collectors.toList());

			System.out.println(vowels);	
		}

	}
	
	private static boolean startsWithVowel(String s) {
		return s.startsWith("a") || s.startsWith("e") || s.startsWith("i")
				||s.startsWith("o")||s.startsWith("u");
	}
	
	//ArrayList::new, List::add, (left, right) -> { left.addAll(right); return left; }
	//Supplier<A> supplier, BiConsumer<A, T> accumulator, BinaryOperator<A> combiner
	
	//[a,b,c,d,e,f]
	
	//T1 -> ArrayList::new -> [a,b,c]  
	                   //            \ 
	                   //             | [a,b,c,d,e,f]
	                   //            / 
	//T2 -> ArrayList::new -> [d,e,f] 

}
