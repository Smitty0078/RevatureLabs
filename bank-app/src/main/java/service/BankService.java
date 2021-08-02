package service;

import java.sql.SQLException;
import java.util.List;

import common.pojo.Customer;
import common.pojo.Transaction;
import dao.CustomerDAO;

public class BankService {
	
	private CustomerDAO custDAO = new CustomerDAO();
	
//--------------------------------------------------------------	
/* Description: Accesses DAO to create a new customer
 * Pre-conditions: Customer account doesn't exist yet and request has been approved
 * Post-conditions:	Customer account is created and returned
 */
	public int createCustomerAccount(Customer c) throws SQLException, Exception {
		System.out.println("create customer SERVICE layer");
		return custDAO.createCustomerAccount(c);
	}
	
//--------------------------------------------------------------	
/* Description: Accesses DAO for customer account sign in
 * Pre-conditions: Customer account exists and username and password are correct
 * Post-conditions:	Customer account is returned
 */
	public Customer getCustomerAccount(String username, String password, List<String> messages) throws SQLException, Exception {
		return custDAO.getCustomerAccount(username, password, messages);
	}
	
//--------------------------------------------------------------	
/* Description: Accesses DAO to retrieve customer account used for checking if 
 * 				username exists within accounts table
 * Pre-conditions: None
 * Post-conditions:	None
 */
	public Customer getCustomerAccount(String username) throws SQLException, Exception {
		return custDAO.getCustomerAccount(username);
		
	}
	
//--------------------------------------------------------------	
/* Description: Accesses DAO to make deposits or withdraws to the customer account
 * Pre-conditions: Customer is signed in or a pending transaction is approved
 * Post-conditions:	Customer account balance is updated accordingly
 */
	public int updateAccountBalance(Customer customer, double amt, String transaction) throws SQLException, Exception {
		return custDAO.updateAccountBalance(customer, amt, transaction);
		
	}

//--------------------------------------------------------------	
/* Description: Accesses DAO to retrieve any pending transactions that need to be approved
 * Pre-conditions: Customer is signed in
 * Post-conditions:	Any transactions are returned for the customer
 */
	public List<Transaction> getTransactions(Customer c) throws SQLException, Exception {
		return custDAO.getTransactions(c);
	}

//--------------------------------------------------------------	
/* Description: Accesses DAO to create a new transaction in the transactions table
 * Pre-conditions: Customer has selected to transfer funds
 * Post-conditions:	New transaction is created
 */
	public int createTransaction(Transaction transaction) throws SQLException, Exception {
		return custDAO.createTransaction(transaction);
	}

	
//--------------------------------------------------------------	
/* Description: Accesses DAO when accepting any pending transactions
 * Pre-conditions: Customer has accepted the transfer transaction request
 * Post-conditions:	Reciever and sender accounts are adjusted accordingly
 */
	public void acceptTransaction(Customer customer, Transaction t) throws SQLException, Exception {
		custDAO.acceptTransaction(customer, t);
	}

//--------------------------------------------------------------	
/* Description: Accesses DAO to retrieve max id number from transaction table
 * Pre-conditions: None
 * Post-conditions:	Max id number returned
 */
	public int setIdCtr(String tablename) throws SQLException, Exception{
		return custDAO.setIdCtr(tablename);
		
	}

	
//--------------------------------------------------------------	
/* Description: Accesses DAO to search the account database for already existing user
 * Pre-conditions: None
 * Post-conditions:	Customer account returned if there is one
 */
	public Customer checkForExistingUser(String username) throws SQLException, Exception {
		return custDAO.getCustomerAccount(username);
	}

//--------------------------------------------------------------	
/* Description: Accesses DAO to retrieve an account to view the balance
 * Pre-conditions: None
 * Post-conditions:	Account balance returned.
 */
	public double getBalance(String userName) throws SQLException, Exception {
		Customer c = custDAO.getCustomerAccount(userName);
		return c.getBalance();
	}

	
	
	
}
