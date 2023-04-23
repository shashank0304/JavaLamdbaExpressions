package streams.ch08.exercise;

import java.util.Arrays;
import java.util.List;

//Solution for exercise to find first occurence of an article 
public class ExerciseOneSolution {
	
	public static void main(String[] args) {
		
		List<String> articles = Arrays.asList("the","a","an");
		
		List<String> words = Arrays.asList("software","programmer","i","am","a","java","the");
		
		String result = words.stream()
						     .filter(s -> articles.contains(s))
		                     .findFirst()
		                     .map(s -> s.toUpperCase())
		                     .orElse("No word found");
		
		System.out.println(result);
		
	}
	

}
