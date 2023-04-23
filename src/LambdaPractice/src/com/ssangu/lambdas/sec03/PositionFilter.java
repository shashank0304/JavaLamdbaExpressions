package com.ssangu.lambdas.sec03;

import lambdas.employee.ContractType;
import lambdas.employee.Employee;

public class PositionFilter implements EmployeeFilter {

	@Override
	public boolean employeeFilter(Employee emp) {
		// TODO Auto-generated method stub
		return emp.getContractType() == ContractType.CONTRACT;
	}

}
