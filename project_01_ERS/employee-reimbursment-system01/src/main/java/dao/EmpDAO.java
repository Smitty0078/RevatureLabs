package dao;

import common.Employee;

public interface EmpDAO {

	public void create(Employee employee);
	public Employee getEmployee(String username, String password);
	
}
