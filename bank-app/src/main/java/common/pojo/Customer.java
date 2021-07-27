package common.pojo;

public class Customer extends User{

	private String bankingHistory; // can be GOOD or BAD
	private double balance;
	
	public Customer(String name, String username, String password, String bankingHistory) {
		super(name, username, password);
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
