package common;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity(name="ticket")
public class Ticket implements Serializable{

	@Id
	@Column(name="ticket_id")
	private int id;
	@Column
	private int employee_id;
	@Column(name="ticket_amount")
	private double amount;
	@Column
	private String description;
	

	public Ticket(int id, int employee_id, double amount, String description) {
		super();
		this.id = id;
		this.employee_id = employee_id;
		this.amount = amount;
		this.description = description;
	}
	
	public Ticket() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		return Double.doubleToLongBits(amount) == Double.doubleToLongBits(other.amount)
				&& Objects.equals(description, other.description) && employee_id == other.employee_id && id == other.id;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", employee_id=" + employee_id + ", amount=" + amount + ", description="
				+ description + "]";
	}
	
	
	

	
	
	
	
	

	
	
}
