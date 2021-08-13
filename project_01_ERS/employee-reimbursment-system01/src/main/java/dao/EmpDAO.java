package dao;

import common.Employee;
import common.User;

public interface EmpDAO {

	public void create(Employee employee);
	public User getEmployee(String username, String password);
	
}
