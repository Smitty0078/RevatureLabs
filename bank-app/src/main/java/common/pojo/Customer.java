package common.pojo;

public class Customer extends Account{

	private String bankingHistory; // can be GOOD or BAD
	
	public Customer(String name, String username, String password, int id, String bankingHistory) {
		super(name, username, password, id);
		this.bankingHistory = bankingHistory;
	}

	public String getBankingHistory() {
		return bankingHistory;
	}
	
	public void setBankingHistory(String history){
		this.bankingHistory = history;
	}
	
	public void requestCreation(String name, String history, Employee e) {
		
	}
	
}
