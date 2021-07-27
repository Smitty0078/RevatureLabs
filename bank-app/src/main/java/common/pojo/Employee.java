package common.pojo;

//TODO: should employee extend User? Where should they be stored - if at all...
public class Employee {

	public Employee(int id, String name, String username, String password) {
		
	}
	
	public boolean approveOrDeny(String bankingHistory) {
		if(bankingHistory == "GOOD")
		{
			return true;
		}
		return false;
	}
	
}
