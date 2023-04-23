package lambdas.ch02;

import lambdas.employee.Employee;
import lambdas.employee.Unit;

public class EDCFilter implements EmployeeFilter {

	@Override
	public boolean filterEmployee(Employee employee) {
		return employee.getUnit()== Unit.EDC;
	}

}
