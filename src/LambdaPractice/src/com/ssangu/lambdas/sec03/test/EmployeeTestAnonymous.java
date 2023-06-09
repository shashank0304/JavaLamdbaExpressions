package com.ssangu.lambdas.sec03.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import lambdas.employee.ContractType;
import lambdas.employee.Designation;
import lambdas.employee.Employee;
import lambdas.employee.Skill;
import lambdas.employee.Unit;

public class EmployeeTestAnonymous {
	private static final List<Employee> employees = new ArrayList<>();

	public static void main(String args[]) {
		initialize();

		// 1. Get a list of all employees in EDC.

		Unit unit = Unit.EDC;
		//EmployeeFilter edcFilter = (Employee employee) -> {return employee.getUnit() == unit;};
		Predicate<Employee> edcFilter = (Employee employee) -> {return employee.getUnit() == unit;};
		List<Employee> edcEmployees = getEmployeesFilteredBy(edcFilter);

		System.out.println("--------EDC Employees--------");
		System.out.println(edcEmployees);

		// 2.Get all the java developers.
		//EmployeeFilter javaFilter = (Employee employee) -> {return employee.getSkills().contains(Skill.JAVA);};
		Predicate<Employee> javaFilter = (Employee employee) -> {return employee.getSkills().contains(Skill.JAVA);};
		List<Employee> javaDevelopers = getEmployeesFilteredBy(javaFilter);

		System.out.println("--------Java Developers--------");
		System.out.println(javaDevelopers);

		// 3. Get employees > 10 years experience
		
		Predicate<Employee> seniorsWithMoreThanTenYrsExpFilter = (Employee employee) -> {return employee.getExperience() > 10;};
		List<Employee> seniorProfessionals = getEmployeesFilteredBy(seniorsWithMoreThanTenYrsExpFilter);

		System.out.println("--------Senior guys--------");
		System.out.println(seniorProfessionals);
		
		//Exercise
		// 4. How will you implement the requirement Java Developers in EDC ?
		//Predicate<Employee> javaDevInEDCFilter = (Employee employee) -> {return (employee.getUnit() == unit && employee.getSkills().contains(Skill.JAVA));};
		List<Employee> javaDevInEDC = getEmployeesFilteredBy(javaFilter.and(edcFilter));
		
		System.out.println("Java Devs in EDC Unit");
		System.out.println(javaDevInEDC);
		
	}

	public static List<Employee> getEmployeesFilteredBy(Predicate<Employee> filter) { //EmployeeFilter filter{
		
		List<Employee> filteredEmployees = new ArrayList<>();
		for (Employee employee : employees) {
			if (filter.test(employee)) {
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
		employees.add(new Employee("Amit", 8, Designation.DEVELOPER, Unit.EDC, dev1Skills, ContractType.FULLTIME));

		// Rahul with .NET as a programmer
		List<Skill> dev2Skills = new ArrayList<>();
		dev2Skills.add(Skill.MICROSOFT);
		employees.add(new Employee("Rahul", 5, Designation.DEVELOPER, Unit.EDC, dev2Skills, ContractType.FULLTIME));

		// Peter with python as a programmer in FS
		List<Skill> dev3Skills = new ArrayList<>();
		dev3Skills.add(Skill.PYTHON);
		employees.add(new Employee("Peter", 7, Designation.DEVELOPER, Unit.FS, dev3Skills, ContractType.CONTRACT));

		// Stanley with angular/js as a programmer in oil gas
		List<Skill> dev4Skills = new ArrayList<>();
		dev4Skills.add(Skill.ANGULARJS);
		dev4Skills.add(Skill.JAVASCRIPT);
		employees.add(new Employee("Stanley", 3, Designation.DEVELOPER, Unit.OIL_GAS, dev4Skills, ContractType.FULLTIME));

		// Manoj with java and angular as a programmer in FS
		List<Skill> dev5Skills = new ArrayList<>();
		dev5Skills.add(Skill.ANGULARJS);
		dev5Skills.add(Skill.JAVA);
		employees.add(new Employee("Manoj", 3, Designation.DEVELOPER, Unit.FS, dev5Skills, ContractType.CONTRACT));

		// Jose as manager
		List<Skill> managerSkills = new ArrayList<>();
		managerSkills.add(Skill.PMP);
		employees.add(new Employee("Jose", 15, Designation.MANAGER, Unit.EDC, managerSkills, ContractType.FULLTIME));

		// Pirlo as architect in edc.
		List<Skill> architectSkills = new ArrayList<>();
		architectSkills.add(Skill.DESIGN);
		employees.add(new Employee("Pirlo", 13, Designation.ARCHITECT, Unit.EDC, architectSkills, ContractType.FULLTIME));

	}

}
