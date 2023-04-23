package streams.ch12.exercise;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/* Solution - Find the total number of prime numbers starting from 1 to 10 million.
 * Write code using sequential and parallel streams.
 */
public class PrimeNumbersParallel {


	public static void main(String[] args) throws IOException {

		Instant start = Instant.now();
	 	long totalPrimes = LongStream.rangeClosed(1, 10_000_000)
				                     .filter(number -> isPrime(number))
	  		                         .count();
		Instant end = Instant.now();	
		
	    System.out.println("Time taken seq: "+Duration.between(start,end).toMillis());
		System.out.println(totalPrimes);
		
		start = Instant.now();
		totalPrimes = LongStream.range(1, 10_000_000)
				                .parallel()
				                .filter(number -> isPrime(number))
				                .count();
		end = Instant.now();	
		
		System.out.println("Time taken parallel: "+Duration.between(start,end).toMillis());
		System.out.println(totalPrimes);
	}

	private static boolean isPrime(long number) {
		
		return  number> 1 && IntStream.rangeClosed(2, (int)Math.sqrt(number))
				                      .noneMatch(i -> number%i == 0);
	}
    

}
