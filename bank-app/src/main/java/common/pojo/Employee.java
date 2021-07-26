package common.pojo;

public class Employee extends Account {

	public Employee(String name, String username, String password, int id) {
		super(name, username, password, id);
	}
	
	public boolean approveOrDeny(String bankingHistory) {
		if(bankingHistory == "GOOD")
		{
			return true;
		}
		return false;
	}
	
}
