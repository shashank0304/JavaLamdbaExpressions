package lambdas.ch06;

import java.util.List;
import java.util.function.Predicate;

import lambdas.employee.Employee;
import lambdas.employee.Skill;
import lambdas.employee.Unit;

//Test class for fetching Employee on different filtering criteria.
public class EmployeeFilterTest {

	private static final EmployeeService employeeService = new EmployeeService();

	public static void main(String args[]) {

		// 1. Get a list of all employees in EDC.
		testEDCFilter();

		// 2.Get all the java developers.
		testJavaDevelopers();

		// 3. Get all senior professionals
		testSeniorProfessionals();

		// 4. Java developer in edc. Implement here.
		testJavaDevelopersInEDC();

	}

	private static void testJavaDevelopersInEDC() {
		List<Employee> javaEdcEmployees = employeeService.getEmployeesFilteredBy(edcFilter().and(javaFilter()));
		System.out.println("--------Java Developers in edc--------");
		System.out.println(javaEdcEmployees);		
	}

	private static void testSeniorProfessionals() {
		int years = 10;
		List<Employee> seniorProfessionals = employeeService.getEmployeesFilteredBy(seniorProfessionals(years));

		System.out.println("--------Senior Professionals-------");
		System.out.println(seniorProfessionals);

	}

	private static void testJavaDevelopers() {

		List<Employee> javaDevelopers = employeeService.getEmployeesFilteredBy(employee -> employee.getSkills().contains(Skill.JAVA));

		System.out.println("--------Java Developers--------");
		System.out.println(javaDevelopers);
	}

	private static void testEDCFilter() {

		List<Employee> edcEmployees = employeeService.getEmployeesFilteredBy(edcFilter());

		System.out.println("--------EDC Employees--------");
		System.out.println(edcEmployees);
	}

	private static Predicate<Employee> seniorProfessionals(int years) {
		return employee -> employee.getExperience() > years;
	}

	private static Predicate<Employee> edcFilter() {
		return employee -> employee.getUnit() == Unit.EDC;
	}

	private static Predicate<Employee> javaFilter() {
		return employee -> employee.getSkills().contains(Skill.JAVA);
	}

}