package com.ssangu.lambdas.sec03;

import lambdas.employee.Employee;
import lambdas.employee.Skill;

public class JavaSkillsFilter implements EmployeeFilter {

	@Override
	public boolean employeeFilter(Employee emp) {
		// TODO Auto-generated method stub
		return emp.getSkills().contains(Skill.JAVA);
	}

}
