package com.ssangu.lambdas.sec03;

public class ThreadLambdas {
	
	public static void main(String[] args) {
		
		//void run();
		Runnable target = () -> performingLongRunningOperation();
			Thread t = new Thread(target);
			
			t.start();
		
	}
	
	public static int performingLongRunningOperation() {
		System.out.println("This is a long running operation");
		return 10;
	}
}
