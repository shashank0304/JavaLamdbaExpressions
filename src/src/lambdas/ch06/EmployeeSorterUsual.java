package lambdas.ch06;

import java.util.Comparator;

import lambdas.employee.Employee;

//Sorting with Comparator - Anonymous class.
public class EmployeeSorterUsual {
	
	public static final Comparator<Employee> byNameAlphabetical = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			return e1.getName().compareTo(e2.getName());
		}
		
	};
	
	public static final Comparator<Employee> byInrExpAndName = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			if(e1.getExperience() == e2.getExperience()) {
				return e1.getName().compareTo(e2.getName());
			}
			return (e1.getExperience() < e2.getExperience()) ? -1 : 1;
		}
		
	};
	
	public static final Comparator<Employee> byDecExpAndName = new Comparator<Employee>() {

		@Override
		public int compare(Employee e1, Employee e2) {
			if(e1.getExperience() == e2.getExperience()) {
				return e1.getName().compareTo(e2.getName());
			}
			return (e1.getExperience() < e2.getExperience()) ? 1 : -1;
		}
		
	};

}
