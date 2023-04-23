package com.ssangu.lambdas.sec03;

import lambdas.employee.Employee;
import lambdas.employee.Unit;

public class EDCFilter implements EmployeeFilter{

	@Override
	public boolean employeeFilter(Employee emp) {
		
		return emp.getUnit() == Unit.EDC;
	}
	
	
	
}
