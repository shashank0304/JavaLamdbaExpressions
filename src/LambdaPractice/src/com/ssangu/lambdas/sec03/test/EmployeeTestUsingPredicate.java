package com.ssangu.lambdas.sec03.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import com.ssangu.lambdas.sec03.EmployeeFilter;

import lambdas.employee.ContractType;
import lambdas.employee.Designation;
import lambdas.employee.Employee;
import lambdas.employee.Skill;
import lambdas.employee.Unit;

public class EmployeeTestUsingPredicate {

	public static final List<Employee> employees = new ArrayList<>();

	public static void main(String[] args) {

		initialize();

		Unit unit = Unit.EDC;
		//1.Get list of all employees in EDC unit
		//EmployeeFilter edcFilter = (Employee employee) -> { return employee.getUnit() == unit;};
		Predicate<Employee> edcFilter = (Employee employee) -> { return employee.getUnit() == unit;};
		List<Employee> edcEmployees = getEmployeesFilteredBy(edcFilter);
		System.out.println("All EDC Employees:"+edcEmployees);
		

		//2. Get all Java Developers
		Skill javaSkill = Skill.JAVA;
		//EmployeeFilter javaFilter = (Employee employee) -> {return employee.getSkills().contains(javaSkill);};
		Predicate<Employee> javaFilter = (Employee employee) -> {return employee.getSkills().contains(javaSkill);};
		List<Employee> javaDevelopers = getEmployeesFilteredBy(javaFilter);
		System.out.println("All Java Developers:"+javaDevelopers);

		// 3. Get employees > 10 years experience

		Predicate<Employee> seniorsWithMoreThanTenYrsExpFilter = (Employee employee) -> {return employee.getExperience() > 10;};
		//EmployeeFilter seniorsWithMoreThanTenYrsExpFilter = (Employee employee) -> {return employee.getExperience() > 10;};
		List<Employee> seniorProfessionals = getEmployeesFilteredBy(seniorsWithMoreThanTenYrsExpFilter);

		System.out.println("--------Senior guys--------");
		System.out.println(seniorProfessionals);

		//Exercise
		// 4. How will you implement the requirement Java Developers in EDC ?
		List<Employee> javaEdcEmployees = getEmployeesFilteredBy(javaFilter.and(edcFilter));
		System.out.println("Java Developers in EDC Unit");
		System.out.println(javaEdcEmployees);
	}





	public static List<Employee> getEmployeesFilteredBy(Predicate<Employee> filter) {

		List<Employee> filteredEmployees = new ArrayList<>();
		for(Employee employee: employees) {
			if(filter.test(employee)) {
				filteredEmployees.add(employee);
			}
		}
		return filteredEmployees;
	}

	public static void initialize() {
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
