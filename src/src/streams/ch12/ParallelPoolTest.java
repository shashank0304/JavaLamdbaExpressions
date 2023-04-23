package streams.ch12;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

//Use JMH for measuring.
public class ParallelPoolTest {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		// no of processors.
		System.out.println("Processors :"+Runtime.getRuntime().availableProcessors());
				
		//set the size of the common pool
		//System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "10");
		
		//get current degree of parallelism
		System.out.println("Common Pool size:"+ForkJoinPool.commonPool().getParallelism());
		
		System.out.println("\nSequential...");
		
		Instant start = Instant.now();
		
		long ans = LongStream.rangeClosed(1, 100_000_000)
				 			 .sum();
		
		Instant end = Instant.now();
		
		System.out.println("Time taken : "+Duration.between(start,end).toMillis());
		System.out.println("Sum is "+ans);

		
		System.out.println("\nParallel...");

	
		Instant now = Instant.now();
		
		ans = LongStream.rangeClosed(1, 100_000_000)
				        .parallel()
				        .sum();
		 
		Instant later = Instant.now();
		
		System.out.println("Time taken : "+Duration.between(now,later).toMillis());
		System.out.println("Sum is "+ans);
	}
	
	private static long delay(long num) {
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		return num * 2;

	}

}
