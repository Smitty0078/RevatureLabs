package common;

import java.util.Objects;

public class Ticket {

	private int id;
	private String username;
	private double amount;
	
	

	public Ticket(int id, String username, double amount) {
		super();
		this.id = id;
		this.username = username;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ticket other = (Ticket) obj;
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount) && id == other.id
				&& Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", username=" + username + ", amount=" + amount + "]";
	}
	
	
	
	

	
	
}
