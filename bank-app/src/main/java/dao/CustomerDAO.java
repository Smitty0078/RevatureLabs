package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
	
	public Customer customerSignIn(String username, String password) throws SQLException, Exception {
		System.out.println("customer sign in DAO layer");
		Connection conn = DBUtil.getInstance().getConnection();
		int id;
		String name = null;
		String uname = null;
		String pwd = null;
		double amt = 0;
		if(notNull(username) && notNull(password)) {
			PreparedStatement pstmt = conn.prepareStatement("SELECT * from bank.accounts WHERE username=? and password=?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				//System.out.println(rs.getString(1));
				id = rs.getInt(1);
				//System.out.println(rs.getString(2));
				name = rs.getString(2);
				//System.out.println(rs.getString(3));
				uname = rs.getString(3);
				//System.out.println(rs.getString(4));
				pwd = rs.getString(4);
				//System.out.println(rs.getString(5));
				amt = rs.getDouble(5);
			}
			if(notNull(uname))
			{
				if(notNull(pwd))
				{
					System.out.println("rs is null");
					Customer c = new Customer(name, uname, pwd, amt);
					return c;
				}
				else{
					//throw invalid password exception
					System.out.println("Invalid password...");
					throw new NullPointerException();
				}
			}
			else {
				//throw invalid username exception
				System.out.println("Invalid username...");
				throw new NullPointerException();
			}
			
		}
		return null;
	}

}
