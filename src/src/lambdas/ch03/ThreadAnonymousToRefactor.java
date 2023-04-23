package lambdas.ch03;

public class ThreadAnonymousToRefactor {

	public static void main(String[] args) {

		// public abstract void run();

		
		Thread t = new Thread(() -> performLongRunningOperation());

		t.start();

   //1.What are the parameters passed to the run method ? None
   //2.What does it return and what should the behavior be ? -// void,performLongRunningOperation()

	}

	private static void performLongRunningOperation() {
		System.out.println("This is a long running operation...");
	}

}
