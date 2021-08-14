package dao;

import common.Employee;
import common.User;

public interface EmpDAO {

	public void create(User employee);
	public User getEmployee(String username, String password);
	public boolean login(String username, String password);
	
	
	
}
