package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import common.util.AppConstants;
import common.pojo.Customer;
import common.util.DBUtil;

public class CustomerDAO {
	
	private boolean notNull(String value) {
		return value != null && !value.isEmpty();
	}

	public int createCustomerAccount(Customer c) throws SQLException, Exception {
		
		System.out.println("create customer DAO layer");
		Connection conn = DBUtil.getInstance().getConnection();
		
		PreparedStatement pstmt = conn.prepareStatement("insert into bank.accounts (id, name, username, password, amount) values (?, ?, ?, ?, ?)");
		pstmt.setInt(1, c.getId());
		pstmt.setString(2, c.getName());
		pstmt.setString(3, c.getUserName());
		pstmt.setString(4, c.getPassword());
		pstmt.setDouble(5, c.getBalance());
		int inserted = pstmt.executeUpdate();
		
		return inserted;
	}
	
	public Customer customerSignIn(String username, String password, List<String> messages) throws SQLException, Exception {
		Connection conn = DBUtil.getInstance().getConnection();
		int id;
		String name = null;
		String uname = null;
		String pwd = null;
		double amt = 0;
		if(notNull(username) && notNull(password)) {
			
			ResultSet rs = getAccount(username, password, conn);
			
			while(rs.next()) {
				id = rs.getInt(1);
				name = rs.getString(2);
				uname = rs.getString(3);
				pwd = rs.getString(4);
				amt = rs.getDouble(5);
			}
			if(notNull(uname) && notNull(pwd))
			{
				Customer c = new Customer(name, uname, pwd, amt);
				return c;
			}
			else {
				messages.add("Invalid Username Or Password");
			}
			
		}
		return null;
	}
	
	private ResultSet getAccount(String username, String password, Connection conn) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from bank.accounts WHERE username=? and password=?");
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}

	public int updateAccountBalance(Customer c, double amt, String transaction) throws SQLException, Exception {
		Connection conn = DBUtil.getInstance().getConnection();
		
		if(transaction == AppConstants.ACCOUNT_DEPOSIT) {
			deposit(c, amt);
		}
		else if(transaction == AppConstants.ACCOUNT_WITHDRAW) {
			withdrawl(c, amt);
		}

		PreparedStatement pstmt = conn.prepareStatement("UPDATE bank.accounts SET amount=? WHERE username=?");
		pstmt.setDouble(1, c.getBalance());
		pstmt.setString(2, c.getUserName());
		int rows = pstmt.executeUpdate();
		
		return rows;
	}
	
	private void deposit(Customer c, double amt) {
		c.setBalance(c.getBalance() + amt);
	}
	private void withdrawl(Customer c, double amt) {
		c.setBalance(c.getBalance() - amt);
	}

}
