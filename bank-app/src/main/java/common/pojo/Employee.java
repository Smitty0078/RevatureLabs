package common.pojo;

//TODO: should employee extend User? Where should they be stored - if at all...
public class Employee {

	public Employee() {}
	
	public boolean approveOrDeny(String bankingHistory) {
		if(bankingHistory == "GOOD")
		{
			return true;
		}
		return false;
	}
	
}
