package lambdas.ch06;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;

import java.util.Comparator;

import lambdas.employee.Employee;

//Final version of the re-factored code.
public class EmployeeSorterFinal {

	//retrieve a list of employees that are sorted alphabetically by name
	
	//keyExtractor - field that is used to sort objects.
	//comparing- pass me the field that I can use to compare objects.
	
	public static final Comparator<Employee> BY_NAME_ALPHA =
			comparing((Employee e) -> e.getName());
	
	
	// Comparator for sorting employee by experience.
	public static final Comparator<Employee> BY_EXPERIENCE =
			comparingInt((Employee e) -> e.getExperience());

	/**Sort the employees with increasing experience and if they have the same experience, 
	then we sort them alphabetically by name.*/
	
	public static final Comparator<Employee> BY_ASC_EXP_THEN_NAME =
			BY_EXPERIENCE.thenComparing(BY_NAME_ALPHA);

	/**
	 * Sort  the employees with decreasing experience 
	 * and if they have the same experience, then we sort them alphabetically by name.
	 */
	public static final Comparator<Employee> BY_DESC_EXP_THEN_NAME =
			BY_EXPERIENCE.reversed().thenComparing(BY_NAME_ALPHA);
}
