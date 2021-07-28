package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import common.pojo.Customer;
import common.util.DBUtil;

public class CustomerDAO {

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

}
