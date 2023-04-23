package lambdas.ch06;

class AnonymousShadowing {

	int i = 10;

	public void inner() {
		
	Runnable r  = new Runnable() {
		int i = 30;
		public void run() {
			System.out.println(this.getClass().getName());
			System.out.println("This is a hello from an inner class: " + i);// or this.i
			System.out.println("This is a hello from an inner class: " + AnonymousShadowing.this.i);
			System.out.println(this);
			System.out.println(AnonymousShadowing.this.toString());
		}

		@Override
		public String toString() {
			return "Inner Class - toString....";
		}
	};
	
	Thread t = new Thread(r); 
	t.start();
 };

	@Override
	public String toString() {
		return "Outer Class - toString....";
	}

	public static void main(String[] args) {
		AnonymousShadowing outer = new AnonymousShadowing();
		outer.inner();
		
	}
}
