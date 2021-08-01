package testing;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import client.ConsoleApp;
import common.pojo.Customer;
import common.pojo.Transaction;
import common.pojo.User;
import dao.CustomerDAO;

public class BankTest {
	
	
	@Test
	public void evaluateSetIdCtr() throws SQLException, Exception {
		CustomerDAO c = new CustomerDAO();
		
		int accountId = c.setIdCtr("accounts");
		Assert.assertEquals("3", String.valueOf(accountId));
		
		int tranId = c.setIdCtr("transactions");
		Assert.assertEquals("4", String.valueOf(tranId));
		
	}
	
	@Test
	public void evaluateCreateCustomerAccount() {
		CustomerDAO dao = new CustomerDAO();
		ConsoleApp app = new ConsoleApp();
		app.setIdCounters("accounts", "transactions");
		Customer c = new Customer("name", "uname", "pwd", 0);
		c.setId(User.getIdCtr());
		try {
			dao.createCustomerAccount(c);
		} catch (SQLException e) {
			Assert.assertTrue(true); //because account already exists
		} catch (Exception e) {
			Assert.assertTrue(true); //^^
		}
	}
	
	@Test
	public void evaluateGetCustomerAccount() {
		CustomerDAO dao = new CustomerDAO();
		List<String> messages = null;
		
		//trys to get existing account
		try {
			Customer c = dao.getCustomerAccount("tst", "tst", messages);
			Assert.assertTrue(true);
		} catch (SQLException e) {
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
		//trys to get non-existing account
		try {
			Customer c = dao.getCustomerAccount("noaccount", "noaccount", messages);
			Assert.assertTrue(false);
		} catch (SQLException e) {
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		
		//tests overloaded method
		try {
			Customer c = dao.getCustomerAccount("tst");
			Assert.assertTrue(true);
		} catch (SQLException e) {
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
		//tests overloaded method
		try {
			Customer c = dao.getCustomerAccount("noaccount");
			if (!c.getUserName().equals(null)) {
				Assert.assertTrue(false);
			}
		} catch (SQLException e) {
			Assert.assertTrue(true);
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@Test
	public void evaluateUpdateAccountBalance() {
		CustomerDAO dao = new CustomerDAO();
		List<String> messages = null;
		Customer c = null;
		try {
			c = dao.getCustomerAccount("tst", "tst", messages);
		} catch (SQLException e) {
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
		//deposit
		try {
			dao.updateAccountBalance(c, 100, "DEPOSIT");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
		//withdraw
		try {
			dao.updateAccountBalance(c, 50, "WITHDRAW");
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
		//should not execute
		try {
			dao.updateAccountBalance(c, 100, "not a type");
		} catch (Exception e) {
			Assert.assertTrue(true);
		}
		
	}
	
	@Test
	public void evaluateGetTransactions() {
		CustomerDAO dao = new CustomerDAO();
		List<String> messages = null;
		
		Customer c = null;
		try {
			c = dao.getCustomerAccount("tst", "tst", messages);
		} catch (SQLException e) {
			Assert.assertTrue(false);
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
		List<Transaction> transactions = null;
		try {
			transactions = dao.getTransactions(c);
			for(Transaction t : transactions) {
				System.out.println(t.toString());
			}
		} catch (Exception e) {
			Assert.assertTrue(false);
		}
		
	}
	
	@Test
	public void evaluateCreateTransaction() {
		//do this
	}
	
	@Test
	public void evaluateAcceptTransaction() {
		//do this
	}
	
	@Test
	public void evaluateGetSenderAccount() {
		//do this
	}
}