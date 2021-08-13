package common;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity(name="ticket")
public class Ticket implements Serializable{

	@Id
	@Column
	private int id;
	@Column
	private int employee_id;
	@Column
	private double amount;
	

	public Ticket(int id, int employee_id, double amount) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUsername() {
		return employee_id;
	}

	public void setUsername(int employee_id) {
		this.employee_id = employee_id;
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
				&& Objects.equals(employee_id, other.employee_id);
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", employee_id=" + employee_id + ", amount=" + amount + "]";
	}
	
	
	
	

	
	
}
