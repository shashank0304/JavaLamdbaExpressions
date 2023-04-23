package lambdas.ch03.exercise;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableLambdasTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Future<Integer> valAnonymous = executorService.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				return computeTotal();
			}
		});

		System.out.println(valAnonymous.get());
		
		//Exercise
		
		/*Uncomment the line below(30) and write the lambda expression
		Notice the signature of call method above and see what call is doing.*/
		
		//params -> body
		//Future<Integer> valLambda = executorService.submit(<lambda here>);

		//Uncomment the next line,retrieve the value using reference above.
		//System.out.println(<invoke get on it>);
		
		executorService.shutdown();
	}

	private static int computeTotal() {
		System.out.println(Thread.currentThread().getName());
		return 200000;
	}

}
