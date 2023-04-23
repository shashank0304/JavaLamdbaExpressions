package lambdas.ch05;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class MHStringCharAt {
	public static void main(String[] args) throws Throwable {
		// Find character at index 3
		String input = "Lambda";
		System.out.println("Usual way : " + input.charAt(3));

		MethodHandles.Lookup LOOKUP = MethodHandles.lookup();

		MethodType methodType = MethodType.methodType(char.class,int.class);
		MethodHandle methodHandle = LOOKUP.findVirtual(String.class, "charAt", 
				                                       methodType);

		char output = (char)methodHandle.invokeExact(input,3);
		System.out.println("Using method handles: " + output);
	}
}
