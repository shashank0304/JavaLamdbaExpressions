package com.ssangu.lambdas.sec03;

import lambdas.employee.Employee;

@FunctionalInterface
public interface EmployeeFilter {
	
	public boolean employeeFilter(Employee emp);
}
