package lambdas.ch02;

import java.util.ArrayList;
import java.util.List;

import lambdas.employee.Designation;
import lambdas.employee.Employee;
import lambdas.employee.Skill;
import lambdas.employee.Unit;

//Strategy.
public class EmployeeTestUsingStrategy {

	private static final List<Employee> employees = new ArrayList<>();

	public static void main(String args[]) {
		initialize();

		// 1. Get list of all employees in EDC.
		System.out.println("----All in EDC----");

		List<Employee> allInEdc = getAllEmployeesFilteredBy(new EDCFilter());
		System.out.println(allInEdc);

		// 2. Get all employees with java skills.
		System.out.println("----All java developers----");

		List<Employee> allJavaDevelopers = getAllEmployeesFilteredBy(new JavaSkillsFilter());
		System.out.println(allJavaDevelopers);

		// 3. Get all employees having experience greater than 10 years.
		System.out.println("----All emp greater than 10 years----");

		List<Employee> allHavingGreaterThanTenYearsExp = getAllEmployeesFilteredBy(new SeniorProfessionalsFilter());
		System.out.println(allHavingGreaterThanTenYearsExp);
		
		//Exercise - Get all the employees who are working as contractors in the organization.
		// Assume there are 2 types - PERMANENT,CONTRACT

	}

	public static List<Employee> getAllEmployeesFilteredBy(EmployeeFilter filter) {
		List<Employee> allFiltered = new ArrayList<>();
		for (Employee employee : employees) {
			if (filter.filterEmployee(employee)) {
				allFiltered.add(employee);
			}
		}
		return allFiltered;
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