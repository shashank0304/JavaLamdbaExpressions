package streams.ch07;

import java.util.ArrayList;
import java.util.List;

import lambdas.employee.Designation;
import lambdas.employee.Skill;
import lambdas.employee.Unit;

public class EmployeeUtil {

	public static List<Employee> initialize() {

		List<Employee> employees = new ArrayList<>();

		List<Skill> dev1Skills = new ArrayList<>();
		dev1Skills.add(Skill.JAVA);
		dev1Skills.add(Skill.JPA);
		
		// Amit is a developer with Java,Jpa
		Employee amit = new Employee(1, "Amit", 8, Designation.DEVELOPER);
		amit.setUnit(Unit.EDC);
		amit.setEmail("amit@amit.com");
		amit.setSkills(dev1Skills);
		employees.add(amit);

		// Rahul with .NET as a programmer
		List<Skill> dev2Skills = new ArrayList<>();
		dev2Skills.add(Skill.MICROSOFT);
		Employee rahul = new Employee(2, "Rahul", 5, Designation.DEVELOPER);
		rahul.setEmail("rahul@rahul.com");
		rahul.setUnit(Unit.EDC);
		rahul.setSkills(dev2Skills);
		employees.add(rahul);

		// Peter with python as a programmer in FS
		List<Skill> dev3Skills = new ArrayList<>();
		dev3Skills.add(Skill.PYTHON);
		Employee peter = new Employee(3, "Peter", 7, Designation.DEVELOPER);
		peter.setUnit(Unit.FS);
		peter.setSkills(dev3Skills);
		peter.setEmail("peter@peter.com");
		employees.add(peter);

		// Stanley with angular/js as a programmer in oil gas
		List<Skill> dev4Skills = new ArrayList<>();
		dev4Skills.add(Skill.ANGULARJS);
		dev4Skills.add(Skill.JAVASCRIPT);
		Employee stanley = new Employee(4, "Stanley", 3, Designation.DEVELOPER);
		stanley.setUnit(Unit.OIL_GAS);
		stanley.setSkills(dev4Skills);
		stanley.setEmail("stanley@stanley.com");
		employees.add(stanley);

		// Manoj with java and angular as a programmer in FS
		List<Skill> dev5Skills = new ArrayList<>();
		dev5Skills.add(Skill.ANGULARJS);
		dev5Skills.add(Skill.JAVA);
		Employee manoj = new Employee(5, "Manoj", 3, Designation.DEVELOPER);
		manoj.setEmail("manoj@manoj.com");
		manoj.setUnit(Unit.FS);
		manoj.setSkills(dev5Skills);
		employees.add(manoj);

		// Jose as manager
		List<Skill> managerSkills = new ArrayList<>();
		managerSkills.add(Skill.PMP);
		Employee jose = new Employee(6, "Jose", 15, Designation.MANAGER);
		jose.setUnit(Unit.EDC);
		jose.setSkills(managerSkills);
		jose.setEmail("jose@jose.com");
		employees.add(jose);

		// Pirlo as architect in edc.
		List<Skill> architectSkills = new ArrayList<>();
		architectSkills.add(Skill.DESIGN);
		architectSkills.add(Skill.JAVA);
		Employee pirlo = new Employee(7, "Pirlo", 13, Designation.ARCHITECT);
		pirlo.setUnit(Unit.EDC);
		pirlo.setSkills(architectSkills);
		employees.add(pirlo);
		
		
		//employees.add(amit);
		
		return employees;
	}

}
