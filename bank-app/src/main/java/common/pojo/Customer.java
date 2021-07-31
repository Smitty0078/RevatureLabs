package common.pojo;

public class Customer extends User{

	private String bankingHistory; // can be GOOD or BAD
	private double balance;
	
	public Customer(String name, String username, String password, double startingBalance) {
		super(name, username, password);
		this.balance = startingBalance;
	}

	public String getBankingHistory() {
		return bankingHistory;
	}
	
	public void setBankingHistory(String history){
		this.bankingHistory = history;
	}
	
	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public void requestCreation(String name, String history, Employee e) {
		
	}

	@Override
	public String toString() {
		String customer = super.toString();
		customer += " Customer = [balance="+balance+" bankingHistory="+bankingHistory+"]";
		return customer;
	}
	
	
	
}
