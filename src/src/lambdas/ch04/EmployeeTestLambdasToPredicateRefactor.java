package lambdas.ch04;

import java.util.ArrayList;
import java.util.List;

import lambdas.employee.Designation;
import lambdas.employee.Employee;
import lambdas.employee.Skill;
import lambdas.employee.Unit;


//Lambdas, EmployeeFilter to Predicate.
public class EmployeeTestLambdasToPredicateRefactor {

	private static final List<Employee> employees = new ArrayList<>();

	public static void main(String args[]) {
		initialize();

		// 1. Get a list of all employees in EDC.

		Unit unit = Unit.EDC;
		
		EmployeeFilter unitFilter = (Employee employee) ->  employee.getUnit() == unit;
		List<Employee> edcEmployees = getEmployeesFilteredBy(unitFilter);

		System.out.println("--------EDC Employees--------");
		System.out.println(edcEmployees);

		// 2.Get all the java developers.
		EmployeeFilter  javasSkillsFilter = (Employee employee) -> employee.getSkills().contains(Skill.JAVA);
		List<Employee> javaDevelopers = getEmployeesFilteredBy(javasSkillsFilter);

		System.out.println("--------Java Developers--------");
		System.out.println(javaDevelopers);

		// 3. Get employees > 10 years experience

		EmployeeFilter seniorProfessionalsFilter = (Employee employee) -> employee.getExperience() > 10;
		List<Employee> seniorProfessionals = getEmployeesFilteredBy(seniorProfessionalsFilter);

		System.out.println("--------Senior guys--------");
		System.out.println(seniorProfessionals);
		
		// How will you implement the requirement Java Developers in EDC ? 
		
	}

	public static List<Employee> getEmployeesFilteredBy(EmployeeFilter filter) {

		List<Employee> filteredEmployees = new ArrayList<>();
		for (Employee employee : employees) {
			if (filter.filterEmployee(employee)) {
				filteredEmployees.add(employee);
			}
		}
		return filteredEmployees;
	}

	private static void initialize() {

		List<Skill> dev1Skills = new ArrayList<>();
		dev1Skills.add(Skill.JAVA);
		dev1Skills.add(Skill.JPA);

		// Amit is a developer with Java,Jpa
		employees.add(new Employee("Amit", 8, Designation.DEVELOPER, Unit.EDC, dev1Skills));

		// Rahul with .NET as a programmer
		List<Skill> dev2Skills = new ArrayList<>();
		dev2Skills.add(Skill.MICROSOFT);
		employees.add(new Employee("Rahul", 5, Designation.DEVELOPER, Unit.EDC, dev2Skills));

		// Peter with python as a programmer in FS
		List<Skill> dev3Skills = new ArrayList<>();
		dev3Skills.add(Skill.PYTHON);
		employees.add(new Employee("Peter", 7, Designation.DEVELOPER, Unit.FS, dev3Skills));

		// Stanley with angular/js as a programmer in oil gas
		List<Skill> dev4Skills = new ArrayList<>();
		dev4Skills.add(Skill.ANGULARJS);
		dev4Skills.add(Skill.JAVASCRIPT);
		employees.add(new Employee("Stanley", 3, Designation.DEVELOPER, Unit.OIL_GAS, dev4Skills));

		// Manoj with java and angular as a programmer in FS
		List<Skill> dev5Skills = new ArrayList<>();
		dev5Skills.add(Skill.ANGULARJS);
		dev5Skills.add(Skill.JAVA);
		employees.add(new Employee("Manoj", 3, Designation.DEVELOPER, Unit.FS, dev5Skills));

		// Jose as manager
		List<Skill> managerSkills = new ArrayList<>();
		managerSkills.add(Skill.PMP);
		employees.add(new Employee("Jose", 15, Designation.MANAGER, Unit.EDC, managerSkills));

		// Pirlo as architect in edc.
		List<Skill> architectSkills = new ArrayList<>();
		architectSkills.add(Skill.DESIGN);
		employees.add(new Employee("Pirlo", 13, Designation.ARCHITECT, Unit.EDC, architectSkills));

	}

}