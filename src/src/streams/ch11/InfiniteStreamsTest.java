package streams.ch11;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreamsTest {
	public static void main(String[] args) {
		
		System.out.println("\nNext 30 dates...");

		Stream.iterate(LocalDate.now(),d -> d.plusDays(1))
			  .limit(30)
		      .forEach(System.out::println);
		
		System.out.println("\n0 - 50, steps of 5:");
		
		Stream.iterate(0, i -> i < 50, i -> i + 5)
		      .forEach(System.out::println);
		
		System.out.println("\n10 random numbers between 0 and 10 ");

		List<Integer> numbers  = Stream.generate(() -> new Random().nextInt(10))
									   .limit(10)
									   .collect(Collectors.toList());
		System.out.println(numbers);
		
		System.out.println("uuid");
		Supplier<UUID> ids =  () -> UUID.randomUUID();
		Stream.generate(ids)
			  .limit(10)
			  .collect(Collectors.toList());
		
	
		//Example showing IntStream
		int integers[] = IntStream.rangeClosed(1,10).toArray();
		
		Arrays.stream(integers)
		      .forEach(System.out::println);
		
		String [] words  = {"I","am","learning","Lambdas","and","Streams"};
		
		String joinedByComma = Arrays.stream(words)
				                     .map(word -> word.toUpperCase())
									 .collect(Collectors.joining(","));
		System.out.println(joinedByComma);
		
		//exercise
		IntSummaryStatistics wordStats = Arrays.stream(words)
                					           .map(word -> word.toUpperCase())
				                               .collect(Collectors.summarizingInt(word ->word.length()));
		System.out.println(wordStats);
	}

}
