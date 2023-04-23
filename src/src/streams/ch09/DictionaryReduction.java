package streams.ch09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;

public class DictionaryReduction {
	
	//Edit as per location.
	private static final String FILE_PATH = "D:\\dictionary\\dictionary.txt";
	
	public static void main(String[] args) throws IOException {
		
		//find the length of the largest word starting from 'a'.
		maxLengthOfWordFromA();
				
		//find word starting from 'a' that has maximum length.
	 	largestWordFromA();
		
		//Find the smallest word in dictionary.
		smallestWord();
		
		//Total number of characters in the dictionary.
		sumTotalCharacters();
		
		//total number of words starting from the letter 'z'
		totalNumberOfWordsStartingFromZ();
	}

	

	public static void maxLengthOfWordFromA() throws IOException {
		
		//IntBinaryOperator max = (a,b) -> a >=b ? a : b;
		try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH))){
			OptionalInt maxLength = lines.filter( line -> line.startsWith("a"))
							     	     .mapToInt(word -> word.length())
			                             .max();
			
			System.out.println(maxLength.orElseThrow());					
		}
	}

	public static void largestWordFromA() throws IOException {
		
		Comparator<String> byLength = Comparator.comparing(s -> s.length());
		try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH))){		
			
			Optional<String> largestWordFromA = lines.filter( line -> line.startsWith("a"))
												     .max(byLength);
			
			System.out.println(largestWordFromA.orElse("Word not found..."));
	
		}
		
	}
	
	public static void smallestWord() throws IOException {

		Comparator<String> byLength = Comparator.comparing(s -> s.length());

		try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH))){
			
			Optional<String> smallestWord =   lines.min(byLength);
			System.out.println(smallestWord.orElse("Word not found..."));						
		}
	}
	
	public static void sumTotalCharacters() throws IOException {
		
		try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH))){
			
			int sum = lines.mapToInt(line -> line.length())
						   .sum();
			
			System.out.println("Total characters in the file: " + sum); //1570532
		}
	}
	
	public static void totalNumberOfWordsStartingFromZ() throws IOException {
		try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH))){
			
			long count = lines.filter(line -> line.startsWith("z"))
							  .count();
			
			System.out.println("Total words starting from the letter 'z:' " + count);
		}
	}
	
}
