package lambdas.ch06;

class LambdaLexical {

	public int i = 10;

	public void inner() {
		Runnable r = () -> {
			int i = 30;
			System.out.println(this.getClass().getName());
			System.out.println("Accessing 'i' directly inside lambda : " + i);
			System.out.println("Accessing 'i' using 'this' inside lambda : " + this.i);
			System.out.println("This call is from inside lambda : " + this);
			System.out.println(toString());
		};		
		
		Thread t = new Thread(r);
		t.start();
	}
	
	@Override
	public String toString() {
		return "Outer Class - toString....";
	}

	public static void main(String[] args) {
		LambdaLexical h = new LambdaLexical();
		h.inner();
	}
}
