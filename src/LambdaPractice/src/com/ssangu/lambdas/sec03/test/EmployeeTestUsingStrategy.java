package com.ssangu.lambdas.sec03.test;

import java.util.ArrayList;
import java.util.List;

import com.ssangu.lambdas.sec03.EDCFilter;
import com.ssangu.lambdas.sec03.EmployeeFilter;
import com.ssangu.lambdas.sec03.JavaSkillsFilter;
import com.ssangu.lambdas.sec03.PositionFilter;
import com.ssangu.lambdas.sec03.SeniorProfessionalsFilter;

import lambdas.employee.ContractType;
import lambdas.employee.Designation;
import lambdas.employee.Employee;
import lambdas.employee.Skill;
import lambdas.employee.Unit;

public class EmployeeTestUsingStrategy {
	
	private static final List<Employee> employees = new ArrayList<>();
	
	public static void main(String[] args) {
		
		initialize();
		
		//1. List of all employees in EDC Unit
		System.out.println("---All in EDC----");
		List<Employee> allInEdc = getAllEmployeesFliteredBy(new EDCFilter());
		System.out.println(allInEdc);
		
		//2.Get all employees with Java Skills
		System.out.println("Employees with Java skills");
		List<Employee> allJavaDevelopers = getAllEmployeesFliteredBy(new JavaSkillsFilter());
		System.out.println(allJavaDevelopers);
		
		//3. Get all employees with experience greater than 10 years 
		System.out.println("Employees with more than 10 yrs experience");
		List<Employee> allHavingGreaterThanTenYrsExp = getAllEmployeesFliteredBy(new SeniorProfessionalsFilter());
		System.out.println(allHavingGreaterThanTenYrsExp);
		
		//4. Get all employees who are on contract
		System.out.println("Contract Employees");
		List<Employee> allContractEmployees = getAllEmployeesFliteredBy(new PositionFilter());
		System.out.println(allContractEmployees);
		
	}
	
	public static List<Employee> getAllEmployeesFliteredBy(EmployeeFilter filter) {
		
		List<Employee> allFiltered = new ArrayList<>();
		
		for(Employee employee: employees) {
			if(filter.employeeFilter(employee)) {
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
