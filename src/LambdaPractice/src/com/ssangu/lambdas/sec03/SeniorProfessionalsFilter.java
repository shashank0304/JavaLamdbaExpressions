package com.ssangu.lambdas.sec03;

import lambdas.employee.Employee;

public class SeniorProfessionalsFilter implements EmployeeFilter {

	@Override
	public boolean employeeFilter(Employee emp) {
		// TODO Auto-generated method stub
		return emp.getExperience() > 10;
	}

}
