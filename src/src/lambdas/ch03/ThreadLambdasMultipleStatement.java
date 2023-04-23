package lambdas.ch03;

public class ThreadLambdasMultipleStatement {

	public static void main(String[] args) {

		Runnable r = () -> findFirstTenPrimeNumbers();

		Thread t = new Thread(r);
		t.start();
	}

	private static void findFirstTenPrimeNumbers() {
		int num = 2;
		int count = 0;
		while (count != 10) {
			boolean isPrime = true;
			for (int i = 2; i <= Math.sqrt(num); i++) {
				if (num % i == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				count++;
				System.out.println(num + " ");
			}
			num++;
		}
	}
}
