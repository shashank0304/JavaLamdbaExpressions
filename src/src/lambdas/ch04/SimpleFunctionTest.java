package lambdas.ch04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

public class SimpleFunctionTest {
	
	public static void main(String[] args) {
		
		UnaryOperator<String>  u = (s) -> s.toUpperCase();
		System.out.println(u.apply("ajay"));

		List<String> strings = getData();
		System.out.println("Input : " + strings);

		// Example 1 - transform each string to length.
		List<Integer> lengthOfString = new ArrayList<>();

		Function<String, Integer> lengthFunction = (s) -> s.length();

		for (String str : strings) {
			lengthOfString.add(lengthFunction.apply(str));
		}
		System.out.println("\nExample One : ");
		System.out.println("Output :" + lengthOfString);

		// Example 2 - ToIntFunction - primitive.
		lengthOfString.clear();

		ToIntFunction<String> length = (s) -> s.length();
		for (String str : strings) {
			lengthOfString.add(length.applyAsInt(str));
		}
		System.out.println("\nExample Two using ToIntFunction: ");
		System.out.println("Output :" + lengthOfString);

		//Example 3 - Name in upper case.
		List<Customer> customers = getCustomerData();
		
		System.out.println("\nExample 3, Customer to Customer names in uppercase ");

		List<String> namesUpperCase = new ArrayList<>();
		Function<Customer,String> nameUpperCase= (Customer c) -> c.getName().toUpperCase();
		for(Customer customer:customers) {
			namesUpperCase.add(nameUpperCase.apply(customer));
		}
		
		System.out.println(namesUpperCase);
		
		
		// Example 4 - From List<Customer> to List<String> - email
		List<String> customerEmail = new ArrayList<>();

		Function<Customer, String> getEmail = (Customer c) -> c.getEmail();

		for (Customer customer : customers) {
			customerEmail.add(getEmail.apply(customer));
		}
		System.out.println("\nExample 4, Customer -> Email : ");
		System.out.println(customerEmail);

		// Example 5 - List<Integer> to int
		// We could use Collections.max
		List<Integer> numbers = Arrays.asList(1, 20, 200, 33, 43, 500);

		ToIntFunction<List<Integer>> maxFinder = (numList) -> findMax(numbers);
		int max = maxFinder.applyAsInt(numbers);

		System.out.println("\nExample Five : ");
		System.out.println("Input list is : " + numbers);
		System.out.println("Max number in the list is : " + max);

		// Exercise - Find average age of the customer.
	}

	public static int findMax(List<Integer> numbers) {
		int max = Integer.MIN_VALUE;
		for (Integer number : numbers) {
			if (number > max) {
				max = number;
			}
		}
		return max;
	}

	private static List<String> getData() {
		List<String> strings = new ArrayList<>();
		strings.add("I");
		strings.add("am");
		strings.add("learning");
		strings.add("lambdas");
		return strings;

	}

	private static List<Customer> getCustomerData() {

		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer("Rahul", "Delta", "rahul@rahul.com", 30));
		customers.add(new Customer("Bob", "Alpha", "bob@bob.com", 35));
		customers.add(new Customer("Alice", "Gamma", "alice@alice.com", 35));
		return customers;

	}

}
