package lambdas.ch06;

import java.util.Comparator;

import lambdas.employee.Employee;

//Sorting using lambdas
public class EmployeeSorterLambda {

	//retrieve a list of employees that are sorted alphabetically by name

	public static final Comparator<Employee> byNameAlphabetical = (e1, e2) -> {
		return e1.getName().compareTo(e2.getName());
	};

	/**Sort the employees with increasing experience and if they have the same experience, 
	then we sort them alphabetically by name.*/
	public static final Comparator<Employee> byInrExpAndName = (e1, e2) -> {
		if (e1.getExperience() == e2.getExperience()) {
			return e1.getName().compareTo(e2.getName());
		}
		return (e1.getExperience() < e2.getExperience()) ? -1 : 1;
	};

	/**
	 * Sort  the employees with decreasing experience 
	 * and if they have the same experience, then we sort them alphabetically by name.
	 */
	public static final Comparator<Employee> byDecExpAndName = (e1, e2) -> {
		if (e1.getExperience() == e2.getExperience())
			return e1.getName().compareTo(e2.getName());
		return (e1.getExperience() < e2.getExperience()) ? 1 : -1;
	};

}
