package lambdas.ch03;

public class ThreadLambdas {

	public static void main(String[] args) {

		Runnable r = () -> performLongRunningOperation();
		Thread t = new Thread(r);
		t.start();

	}

	private static void performLongRunningOperation() {
		System.out.println("This is a long running operation...");
	}

}