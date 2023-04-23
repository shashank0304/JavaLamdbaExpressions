package lambdas.ch05;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class LambdaMetFactoryTest {
	public static void main(String[] args) throws Throwable {

		MethodHandles.Lookup LOOKUP = MethodHandles.lookup();
		MethodType methodType = MethodType.methodType(void.class);
		MethodType invokedType = MethodType.methodType(Runnable.class);
		
		CallSite site = LambdaMetafactory.metafactory(LOOKUP, 
				                                      "run", 
				                                      invokedType, 
				                                      methodType,
				                                      LOOKUP.findStatic(LambdaMetFactoryTest.class, 
				                                      "performLongRunningOperation", methodType), 
				                                      methodType);
		MethodHandle factory = site.getTarget();
		Runnable r = (Runnable) factory.invoke();
		r.run();
	}

	private static void performLongRunningOperation() {
		System.out.println("This is a long running operation...");
	}
}
