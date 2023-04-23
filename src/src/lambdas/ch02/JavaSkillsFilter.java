package lambdas.ch02;

import lambdas.employee.Employee;
import lambdas.employee.Skill;

public class JavaSkillsFilter implements EmployeeFilter {

	@Override
	public boolean filterEmployee(Employee employee) {
		return employee.getSkills().contains(Skill.JAVA);
	}

}
