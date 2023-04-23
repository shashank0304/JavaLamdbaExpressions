package lambdas.ch06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ToIntBiFunction;
import java.util.function.ToIntFunction;

import lambdas.employee.Employee;

public class MethodReferenceTest {

	public static void main(String[] args) {

		// 1. Method reference to static method
		// ClassName :: static method
		methodReferenceStaticMethod();

		// 2.Method reference to instance method of arbitary type.
		// ClassName :: instance method
		methodReferenceInstanceMethodViaClass();
		
		//3.Method reference to instance method of existing object.
        //obj :: instanceMethod
		methodReferenceInstanceMethodViaObject();

	}

	private static void methodReferenceInstanceMethodViaObject() {
		
		// Method reference to instance method of existing object.
        // obj :: instanceMethod
	
		//1.
		Consumer<String> printLambda = (s) -> System.out.println(s);
		Consumer<String> printMR = System.out::println;
		
		//2.
		List<String> list = Arrays.asList("a","b","c","d","e");
		list.forEach(System.out::println);
		
	
		//3.
		List<Employee> filteredEmployees = new ArrayList<>();
		
		Consumer<Employee> employeeLambda = (Employee employee) -> filteredEmployees.add(employee);	
		Consumer<Employee> employeeMR = filteredEmployees::add; 
		
	}

	private static void methodReferenceInstanceMethodViaClass() {
		// Method reference to instance method of arbitary type.
		// ClassName :: instance method
		// Key - Method of an object is referred and that object passed as one of the
		// parameters.
		
		System.out.println("Method reference to instance method of arbitary type");

		String input = "Lambdas";

		//1.Length of string 
		ToIntFunction<String> lengthLambdas = (String s) -> s.length();
		ToIntFunction<String> lengthMethodReference = String::length;
		
		System.out.println("Length of string using Lambda: "+lengthLambdas.applyAsInt(input));
		System.out.println("Length of string using MR: "+lengthMethodReference.applyAsInt(input));

		// 2.Find substring
                                                               
		BiFunction<String, Integer, String> substringLambdas = (text, position) -> text.substring(position);
		BiFunction<String, Integer, String> substringMethodReference = String::substring;

		
		System.out.println("Substring using Lambdas : "+substringLambdas.apply(input, 3));
		System.out.println("Substring using MR : "+substringMethodReference.apply(input, 3));


		// 3. Get employee name from Employee object.
		Function<Employee, String> employeeToNameLambda = (Employee e) -> e.getName();
		Function<Employee, String> employeeToNameMR = Employee::getName;
		
		
		//4.Arrays.sort
		System.out.println("Sorting an array using Lambdas/Method Reference");
		
		String[] names = { "Amit", "James", "Rahul", "John", "Patricia", 
				"Peter", "Stanley", "Anaya" };
		
		Arrays.sort(names, (s1, s2) -> s1.compareToIgnoreCase(s2));
		Arrays.sort(names,String::compareToIgnoreCase);

		for (int i = 0; i < names.length; i++) {
			System.out.println(names[i]);
		}
	}

	private static void methodReferenceStaticMethod() {
		
		// 1.Method reference to a static method

		// ClassName :: static method

		//1.
		ToIntBiFunction<Integer, Integer> maximumLambda = (a, b) -> Integer.max(a, b);
		ToIntBiFunction<Integer, Integer> maximumMR = Integer::max;

		System.out.println("Lambda : " + maximumLambda.applyAsInt(10, 20));
		System.out.println("MR : " + maximumMR.applyAsInt(10, 20));
		
	}

}
