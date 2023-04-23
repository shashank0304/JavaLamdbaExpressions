package lambdas.ch05;

public class AddTwoNumbersByteCode {

	public int add_Two(int a, int b) {
		return a + b;
	}

	public static void main(String[] args) {
		AddTwoNumbersByteCode addTwoNumbersByteCode = new AddTwoNumbersByteCode();
		addTwoNumbersByteCode.add_Two(10, 20);
	}

}
