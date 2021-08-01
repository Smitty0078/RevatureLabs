package common.pojo;

import common.util.AppConstants;

public class Transaction {

	private static int idCtr = 3;
	private int id;
	private String reciever;
	private String sender;
	private double amount;
	private String status;
	private String type;

	
	
	public Transaction(int id, String reciever, String sender, double amount, String status, String type) {
		super();
		this.id = id;
		this.reciever = reciever;
		this.sender = sender;
		this.amount = amount;
		this.status = status;
		this.type = type;
	}

	
	//used for creating new transaction
	public Transaction(String reciever, String sender, double amount, String status, String type) {
		super();
		this.id = idCtr;
		this.reciever = reciever;
		this.sender = sender;
		this.amount = amount;
		this.status = status;
		this.type = type;
		incrementIdCtr();
	}



	public Transaction() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReciever() {
		return reciever;
	}

	public void setReciever(String reciever) {
		this.reciever = reciever;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	public static int getIdCtr() {
		return idCtr;
	}


	public static void setIdCtr(int idCtr) {
		Transaction.idCtr = idCtr;
	}


	private void incrementIdCtr() {
		idCtr++;
	}
	
	public String printPendingTransaction() {
		String message = null;
		if(type.equals(AppConstants.ACCOUNT_WITHDRAW)) {
			message="You have a request to transfer $"+amount+" to "+sender;
		}else if(type.equals(AppConstants.ACCOUNT_DEPOSIT)) {
			message= sender+" has requested to send you $"+amount;
		}
		return message;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", reciever=" + reciever + ", sender=" + sender + ", amount=" + amount
				+ ", status=" + status + ", type="+ type + "]";
	}
	
	
	
	
}
