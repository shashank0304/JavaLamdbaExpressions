package lambdas.ch04;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//Shows example of andThen() in Function
public class FunctionAndThenTest {

	public static void main(String[] args) {

		List<Customer> customer = new ArrayList<>();

		// Read data.
		List<String> customerDataCSV = getCustomerDataCSV();

		Function<String, Customer> nameEmailSeparator = (String s) -> getCustomer(s);

		for (String customerDataFromCSV : customerDataCSV) {
			customer.add(nameEmailSeparator.apply(customerDataFromCSV));
		}

		// Overrides toString();
		System.out.println("\nCreate Customer instance from CSV");
		System.out.println(customer);

		// Only first name in uppercase and email separated by hyphen.
		// [RAHUL - rahul@rahul.com, BOB - bob@bob.com, ALICE - alice@alice.com]

		Function<Customer, String> hyphenSeparator = (Customer c) -> c.getFirstName().toUpperCase() + " - "
				+ c.getEmail();

		List<String> firstNameEmailHyphenSeparated = new ArrayList<>();

		// Use andThen since nameEmailSeparator is already there.
		for (String customerDataFromCSV : customerDataCSV) {
			firstNameEmailHyphenSeparated.add(nameEmailSeparator.andThen(hyphenSeparator).apply(customerDataFromCSV));
		}

		System.out.println("\nExample of andThen :");

		System.out.println(firstNameEmailHyphenSeparated);
	}

	public static Customer getCustomer(String customerDataCSV) {
		String[] customerData = customerDataCSV.split(",");
		return new Customer(customerData[0], customerData[2], customerData[1],
				Integer.parseInt(customerData[3]));
	}

	private static List<String> getCustomerDataCSV() {

		List<String> customerData = new ArrayList<>();

		customerData.add("Rahul,rahul@rahul.com,Delta,30");
		customerData.add("Bob,bob@bob.com,Alpha,35");
		customerData.add("Alice,alice@alice.com,Gamma,35");
		return customerData;
	}

	public static int findAverageAge(List<Customer> customers) {
		int total = 0;
		for (Customer customer : customers) {
			total += customer.getAge();
		}
		return total / customers.size();
	}

}
