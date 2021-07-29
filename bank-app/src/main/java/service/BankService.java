package service;

import java.sql.SQLException;

import common.pojo.Customer;
import dao.CustomerDAO;

public class BankService {
	
	private CustomerDAO custDAO = new CustomerDAO();
	
	//TODO: ADD PRE POST
	public int createCustomerAccount(Customer c) throws SQLException, Exception {
		System.out.println("create customer SERVICE layer");
		return custDAO.createCustomerAccount(c);
	}
	
	public Customer customerSignIn(String username, String password) throws SQLException, Exception {
		System.out.println("customer sign in SERVICE layer");
		return custDAO.customerSignIn(username, password);
	}
	
	
}
