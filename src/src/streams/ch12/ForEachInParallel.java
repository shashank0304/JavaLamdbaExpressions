package streams.ch12;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEachInParallel {
	public static void main(String[] args) {
		List<String> words = Arrays.asList("add","eel","very","watt","i","owl","us");
		
		for(int i = 0 ; i<5 ;i ++) {
			
			List<String> vowels = new ArrayList<>();
			
			words.parallelStream()
			     .filter(s -> startsWithVowel(s))
			     .forEach(word -> vowels.add(word));
			System.out.println(vowels);	
		}
		
	}

	private static boolean startsWithVowel(String s) {
		return s.startsWith("a") || s.startsWith("e") || s.startsWith("i")
				||s.startsWith("o")||s.startsWith("u");
	}

}
