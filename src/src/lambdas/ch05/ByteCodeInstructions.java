package lambdas.ch05;

import java.util.ArrayList;
import java.util.List;

public class ByteCodeInstructions {
	
	public void virtualMethod(int a, String b) {
		System.out.println("This is a virtual method..." + a + " " + b);
	}
	
	public static void staticMethod() {
		System.out.println("This is a static method...");
	}
	
	public static void main(String[] args){
	
		List<String> strings= new ArrayList<>();
		strings.add("a");
		
		ByteCodeInstructions byteCodeInstructions = new ByteCodeInstructions();
		byteCodeInstructions.virtualMethod(10,"Ten");
		ByteCodeInstructions.staticMethod();
	}
}
