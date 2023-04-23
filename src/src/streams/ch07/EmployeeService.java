package streams.ch07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import lambdas.employee.Skill;
import lambdas.employee.Unit;

public class EmployeeService {
	
	//replace iteration - stream, if - filter, collect data.
	public List<Employee> getEmployeesFilteredByImperative(Predicate<Employee> filter) {

		List<Employee> employees = EmployeeUtil.initialize();
		
		List<Employee> filteredEmployee = new ArrayList<>();
		
		for (Employee employee : employees) {
			if (filter.test(employee)) {
				filteredEmployee.add(employee);
			}
		}
		
		return filteredEmployee;
	}
	
	//Using stream,filter,collect
	public List<Employee> getEmployeesFilteredBy(Predicate<Employee> filter) {

		List<Employee> employees = EmployeeUtil.initialize();

		return employees.stream()
				        .filter(filter)
				        .collect(Collectors.toList());
	}

	// retrieve a list of employees that are sorted alphabetically by name
	public List<Employee> sortByName() {
		List<Employee> employees = EmployeeUtil.initialize();
		employees.sort(EmployeeSorter.BY_NAME_ALPHA);
		return employees;
	}

	/**
	 * Sort the employees with increasing experience and if they have the same
	 * experience, then we sort them alphabetically by name.
	 */

	public List<Employee> sortByInreasingExpAndThenName() {
		List<Employee> employees = EmployeeUtil.initialize();
		employees.sort(EmployeeSorter.BY_ASC_EXP_THEN_NAME);
		return employees;
	}

	/**
	 * Sort the employees with decreasing experience and if they have the same
	 * experience, then we sort them alphabetically by name.
	 */
	public List<Employee> sortByDecreasingExpAndThenName() {
		List<Employee> employees = EmployeeUtil.initialize();
		employees.sort(EmployeeSorter.BY_DESC_EXP_THEN_NAME);
		return employees;
	}

	/**
	 * Exercise Top 3 methods can be combined into one.
	 * 
	 * @param sorter - Pass behavior
	 * @return -Sorted list.
	 */
	public List<Employee> getEmployees(Comparator<Employee> sorter) {
		List<Employee> employees = EmployeeUtil.initialize();
		Collections.sort(employees, sorter);
		return employees;
	}
	
	/**
	 * Return list of employee names using map method.
	 * @param skill -The skill to check.
	 * @return - List of employee names with angularjs skills.
	 */
	public List<String> getEmployeeNamesWith(Skill skill) {
		
		List<Employee> employees = EmployeeUtil.initialize();
		
		List<String> employeeWithAngularJSSkills = new ArrayList<>();
		
		for(Employee employee : employees) {
			if(employee.getSkills().contains(skill)) {
				employeeWithAngularJSSkills.add(employee.getName());
			}
		}
		return employeeWithAngularJSSkills;
	}

	/**
	 * Just for reference, don't name methods like this.
	 * @return
	 */
	public List<String> getEmployeeNamesWithMultipleSkillsImperative() {
		List<Employee> employees = EmployeeUtil.initialize();

		List<Employee> moreThanOneSkill = new ArrayList<>();
		for (Employee e : employees) {
			if (null != e.getSkills() && e.getSkills().size() > 1) {
				moreThanOneSkill.add(e);
			}
		}
		Collections.sort(moreThanOneSkill, EmployeeSorter.BY_EXPERIENCE);
		List<String> names = new ArrayList<>();
		for (Employee e : moreThanOneSkill) {
			names.add(e.getName());
		}
		return names;
	}

	public List<String> getEmployeeNamesWithMultipleSkillsStreams() {
		List<Employee> employees = EmployeeUtil.initialize();
		return employees.stream()
						//.filter(emp-> Objects.nonNull(emp.getSkills()))
				        .filter(emp -> null != emp.getSkills() && emp.getSkills().size() >1)
				        .sorted(EmployeeSorter.BY_EXPERIENCE)
				        .map( emp -> emp.getName())
				        .collect(Collectors.toList());
	}

	// distinct - Get unique names of unit that is based on employee with java skills.
	public List<String> getUniqueUnitNamesWithJavaSkill() {
		List<Employee> employees = EmployeeUtil.initialize();
		return employees.stream()
				        .filter(employee -> employee.getSkills().contains(Skill.JAVA))
				        .map(employee -> employee.getUnit().getUnitName())	
				        .distinct()
				        .collect(Collectors.toList());
	}

	public String findEmployeeNameByIdImperative(int id) {
		
		//mock data for now
		List<Employee> employees = EmployeeUtil.initialize();
		Employee e = null;
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				e = employee;
				break;
			}
		}
		/* Strike */
		// return e.getName();
		return e != null ? e.getName() : "Unknown";
	}

	public Optional<Employee> findEmployee(int id) {
		List<Employee> employees = EmployeeUtil.initialize();
		
		return employees.stream()
				        .filter(emp -> emp.getId() == id)
                        .findFirst();
	}

	public Optional<Employee> employeeBySkillNoStream(Skill skill) {
		Employee result = null;
		List<Employee> employees = EmployeeUtil.initialize();
		for (Employee employee : employees) {
			if (employee.getSkills().contains(skill)) {
				result = employee;
			}
		}
		return Optional.ofNullable(result);
	}

	public Optional<Employee> findAnyEmployeeBySkill(Skill skill) {

		List<Employee> employees = EmployeeUtil.initialize();
		
		return employees.stream()
				        .filter(e -> e.getSkills().contains(skill))
				        .findAny();		
	}
	
	public List<String> getTwoDevelopersWithSkill(Skill skill){
		List<Employee> employees = EmployeeUtil.initialize();
		
		return employees.stream()
		         		.filter(e ->e.getSkills().contains(skill))
		         		.map(e -> e.getName())
		         		.limit(2)
		         		.collect(Collectors.toList());
	}
	
	public List<String> getTwoDevelopersWithSkillOldWay(Skill skill){
		List<Employee> employees = EmployeeUtil.initialize();
		
		List<String> names = new ArrayList<>();
		int count = 0;
		for(Employee employee: employees) {
			if(employee.getSkills().contains(skill)) {
				names.add(employee.getName());
				count++;
				if(count ==2)
					break;
			}
				
		}
		return names;
	}
	
	
	
	public String findEmployeeWithSkillAndMinExp(Skill skill){
		List<Employee> employees = EmployeeUtil.initialize();
		return employees.stream()
		         		.filter(e -> e.getSkills().contains(skill))
		         		.min(Comparator.comparing(Employee::getExperience))
		         		.map(e-> e.getName())
		         		.orElse("No employee found");
	}
	
	//Grouping by unit name
	public Map<Unit,List<Employee>> findByUnit(){
		List<Employee> employees = EmployeeUtil.initialize();
		return employees.stream()
				        .collect(Collectors.groupingBy(Employee::getUnit));
	}
}
