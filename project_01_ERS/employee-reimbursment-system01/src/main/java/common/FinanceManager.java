package common;

import common.util.AppConstants;

public class FinanceManager extends User{

	public FinanceManager(int id, String name, String username, String password) {
		super(id, name, username, password, AppConstants.ADMIN);
	}
	
}
