package lambdas.ch06;

//Test class for sorting Employee
public class EmployeeComparatorTest {

	private static final EmployeeService employeeService = new EmployeeService();

	public static void main(String args[]) {

		// Sort all employees alphabetically
		testSortByName();

		// Sort with increasing experience and if same experience,then
		// alphabetically.
		testSortByIncreasingExperienceAndThenName();

		// Sort with decreasing experience and if same experience,then
		// alphabetically.
		testSortByDecreasingExperienceAndThenName();

	}
	
	private static void testSortByName() {
		System.out.println("\nSorting by name alphabetically :\n");
		
		System.out.println(employeeService.sortByName());
	}

	private static void testSortByIncreasingExperienceAndThenName() {
		System.out.println("\nSort by increasing experience,then alphabetically :");
		
		System.out.println(employeeService.sortByInreasingExpAndThenName());
	}

	private static void testSortByDecreasingExperienceAndThenName() {
		System.out.println("\nSort by decreasing experience,then name alphabetically :\n");
		
		System.out.println(employeeService.sortByDecreasingExpAndThenName());
	}

	
}