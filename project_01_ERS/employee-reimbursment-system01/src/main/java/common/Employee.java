package common;

import common.util.AppConstants;

public class Employee extends User{

	public Employee(int id, String name, String username, String password) {
		super(id, name, username, password, AppConstants.NOT_ADMIN);

	}
	
}
