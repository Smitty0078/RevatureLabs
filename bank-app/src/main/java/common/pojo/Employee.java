package common.pojo;

import common.util.AppConstants;

//TODO: should employee extend User? Where should they be stored - if at all...
public class Employee {

	public Employee() {}
	
	public boolean approveOrDeny(String bankingHistory) {
		if(bankingHistory.equals(AppConstants.BANK_HISTORY_GOOD))
		{
			return true;
		}
		return false;
	}
	
}
