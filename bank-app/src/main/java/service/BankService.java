package service;

import java.sql.SQLException;
import java.util.List;

import common.pojo.Customer;
import common.pojo.Transaction;
import dao.CustomerDAO;

public class BankService {
	
	private CustomerDAO custDAO = new CustomerDAO();
	
	//TODO: ADD PRE POST
	public int createCustomerAccount(Customer c) throws SQLException, Exception {
		System.out.println("create customer SERVICE layer");
		return custDAO.createCustomerAccount(c);
	}
	
	public Customer customerSignIn(String username, String password, List<String> messages) throws SQLException, Exception {
		return custDAO.customerSignIn(username, password, messages);
	}

	public int updateAccountBalance(Customer customer, double amt, String transaction) throws SQLException, Exception {
		System.out.println("DEPOSIT SERVICE LAYER");
		return custDAO.updateAccountBalance(customer, amt, transaction);
		
	}

	public List<Transaction> getTransactions(Customer c) throws SQLException, Exception {
		System.out.println("VIEW TRANSACTIONS SERVICE LAYER");
		return custDAO.getTransactions(c);
	}

	public int createTransaction(Transaction transaction) throws SQLException, Exception {
		System.out.println("CREATE TRANSACTION SERVICE LAYER");
		return custDAO.createTransaction(transaction);
	}
	
	
}
