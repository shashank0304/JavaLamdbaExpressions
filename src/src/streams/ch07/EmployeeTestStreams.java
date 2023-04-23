package streams.ch07;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Predicate;

import lambdas.employee.Skill;
import lambdas.employee.Unit;

public class EmployeeTestStreams {
	
	public static final EmployeeService employeeService = new EmployeeService();
	
	public static void main(String[] args) {		
		
		//Employees with experience > 10 years.
		System.out.println("Simple usage of stream,filter, collect");
		seniorEmployeesUsingStreams();
	
		
		//map example - get employee name with AngularJS skills.
		System.out.println("Example of map function");
		employeeNamesWithAngularJSSkills();
	
		
		//Employee names with multiple skills - sorted by exp- old way
		System.out.println("Sorting using imperative style:");
		namesWithMultipleSkillsSortedOldWay();
		
		
		
		//Employee names with multiple skills - sorted by exp - streams
		System.out.println("Sorting using declarative style:");
		namesWithMultipleSkillsSortedStreams();
		
		//example for distinct
		List<String> units = employeeService.getUniqueUnitNamesWithJavaSkill();
		System.out.println("\nDistinct Unit names with Java skills: " + units);

		//findFirst by id with stream/optional.
		System.out.println("\nFind first with id : ");
		findFirstById(1);
		
		
		//findAny with matching skill.
		System.out.println("\nFind Any with skill : ");
		findAnyBySkill(Skill.ANGULARJS);
		
		//limit - two developers
		System.out.println("\nLimit : Finding 2 employees with skill : ");
		limitToTwoBySkill();
		
		System.out.println(employeeService.findEmployeeWithSkillAndMinExp(Skill.JAVA));
		
		//grouping by unit
		Map<Unit,List<Employee>> byUnit = employeeService.findByUnit();
		System.out.println(byUnit);
		
	}


	private static void seniorEmployeesUsingStreams() {
		Predicate<Employee> seniorProfessionals = (employee) -> employee.getExperience()>10; 
		List<Employee> seniors = employeeService.getEmployeesFilteredByImperative(seniorProfessionals);
		System.out.println(seniors);
	}
	
	private static void employeeNamesWithAngularJSSkills() {
		List<String> angularSkills = employeeService.getEmployeeNamesWith(Skill.ANGULARJS);
		System.out.println("Employees with angularjs skills : " + angularSkills);
	}
	
	
	//get emp names sorted by exp level but with more than one skill.
	private static void namesWithMultipleSkillsSortedOldWay() {
		List<String> namesWithSkills = employeeService.getEmployeeNamesWithMultipleSkillsImperative();
		System.out.println(namesWithSkills);
	}

	private static void namesWithMultipleSkillsSortedStreams() {
		List<String> namesWithSkillsStreams = employeeService.getEmployeeNamesWithMultipleSkillsStreams();
		System.out.println(namesWithSkillsStreams);
	}

	private static void limitToTwoBySkill() {
		List<String> names = employeeService.getTwoDevelopersWithSkill(Skill.JAVA);
		System.out.println(names);
	}

	private static void findAnyBySkill(Skill withSkill) {
		
		Optional<Employee> empWithSkill = employeeService.findAnyEmployeeBySkill(withSkill);
		
		String empNameWithSkill = empWithSkill.map(e -> e.getName())
		                                      .orElse("No employee found, need to upskill");
		
		System.out.println("Employee with required skill = " + withSkill + ": " + empNameWithSkill);
	}

	private static void findFirstById(int id) {
		Optional<Employee> employee = employeeService.findEmployee(id);
		String name = employee.map(e -> e.getName())
		           			//.orElse("Unknown Employee")
		           			//.orElseThrow()
		                      .orElseThrow(() -> new NoSuchElementException("Could not "
		                          		+ "find employee with id:"+id));
		            
		System.out.println("Finding employee name with id = " + id + ": "+name);
	}
}
