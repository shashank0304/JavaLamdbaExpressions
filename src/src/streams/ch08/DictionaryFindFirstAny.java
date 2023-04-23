package streams.ch08;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Stream;


public class DictionaryFindFirstAny {
	
	//change as per location.
	private static String FILE_PATH = "D:\\dictionary\\dictionary.txt";
	
	public static void main(String[] args) throws IOException {
		
		
		//Find the first occurrence of a large word. i.e  > 20 characters.
		findFirstLargeWord();
		
		//Find a word that starts with 'a' and greater than 10 characters.
		String firstLetter = "a"; 
		findWordStartingFrom(firstLetter);					   
	}


	public static void findFirstLargeWord() throws IOException{
		
		try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH)))
		{
			
			Optional<String> firstLargeWord = lines.filter(word -> word.length() > 20)
				       							   .findFirst();

			System.out.println(firstLargeWord.orElse("No large word found..."));
		}
	}

	public static void findWordStartingFrom(String firstLetter) throws IOException {
		
		try(Stream<String> lines = Files.lines(Paths.get(FILE_PATH)))
		{
			Optional<String> anyLargeWord = 
										lines.filter(word -> word.startsWith(firstLetter))
					 					     .filter(word -> word.length() > 10)
					 					     .findAny();

			System.out.println(anyLargeWord.orElse("No word starting "
					+ "from "+firstLetter+"found..."));
		}		
	}
}
