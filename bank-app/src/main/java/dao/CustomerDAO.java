package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import common.util.AppConstants;
import common.pojo.Customer;
import common.pojo.Transaction;
import common.util.DBUtil;

public class CustomerDAO {
	
	private boolean notNull(String value) {
		return value != null && !value.isEmpty();
	}

//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	public int setIdCtr(String tablename) throws SQLException, Exception {
		Connection conn = DBUtil.getInstance().getConnection();
		
		Statement stmt = conn.createStatement();
		String sql = "SELECT MAX(id) from bank."+tablename;
		ResultSet rs = stmt.executeQuery(sql);
		//PreparedStatement pstmt = conn.prepareStatement("SELECT MAX(id) from bank.? ");
		//pstmt.setString(1, tablename);
		//ResultSet rs = pstmt.executeQuery();
		int idCtr = 0;
		
		while(rs.next()) {
			idCtr = rs.getInt(1);
		}
		
		return idCtr;
		
	}
	
	//--------------------------------------------------------------	
	/* Description: 
	 * Pre-conditions: 
	 * Post-conditions:	
	 */
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
	
	//--------------------------------------------------------------	
	/* Description: 
	 * Pre-conditions: 
	 * Post-conditions:	
	 */
	public Customer getCustomerAccount(String username, String password, List<String> messages) throws SQLException, Exception {
		Connection conn = DBUtil.getInstance().getConnection();
		int id = 0;
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
				c.setId(id);
				return c;
			}
			else {
				messages.add("Invalid Username Or Password");
			}
			
		}
		return null;
	}
	
//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	public Customer getCustomerAccount(String username) throws SQLException, Exception {
		Connection conn = DBUtil.getInstance().getConnection();
		Customer c = new Customer(username, 0);
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM bank.accounts WHERE username=?;");
		pstmt.setString(1, username);
		ResultSet rs = pstmt.executeQuery();
		c = setCustomerFields(c, rs);
		
		return c;
	}

//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	private Customer setCustomerFields(Customer c, ResultSet rs) throws SQLException {
		int id = 0;
		String name = null;
		String uname = null;
		String password = null;
		double amt = 0;
		
		while(rs.next()) {
			id = rs.getInt(1);
			name = rs.getString(2);
			uname = rs.getString(3);
			password = rs.getString(4);
			amt = rs.getDouble(5);
		}
		
		if(notNull(uname) && notNull(password))
		{
			c = new Customer(name, uname, password, amt);
			c.setId(id);
			return c;
		}
		System.out.println("Account not found");
		return c;
	}
	
	//--------------------------------------------------------------	
	/* Description: 
	 * Pre-conditions: 
	 * Post-conditions:	
	 */
	private ResultSet getAccount(String username, String password, Connection conn) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("SELECT * from bank.accounts WHERE username=? and password=?");
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		return rs;
	}
	
	//--------------------------------------------------------------	
	/* Description: 
	 * Pre-conditions: 
	 * Post-conditions:	
	 */
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
	
	//--------------------------------------------------------------	
	/* Description: 
	 * Pre-conditions: 
	 * Post-conditions:	
	 */
	private void deposit(Customer c, double amt) {
		c.setBalance(c.getBalance() + amt);
	}
	
	//--------------------------------------------------------------	
	/* Description: 
	 * Pre-conditions: 
	 * Post-conditions:	
	 */
	private void withdrawl(Customer c, double amt) {
		c.setBalance(c.getBalance() - amt);
	}
	
	//--------------------------------------------------------------	
	/* Description: 
	 * Pre-conditions: 
	 * Post-conditions:	
	 */
	public List<Transaction> getTransactions(Customer c) throws SQLException, Exception {
		Connection conn = DBUtil.getInstance().getConnection();
		List<Transaction> transactions = new ArrayList<Transaction>();
		
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM bank.transactions WHERE reciever=?");
		
		pstmt.setString(1, c.getUserName());
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()){				//     id            reciever          sender           amount           status           type
			Transaction t = new Transaction(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDouble(4), rs.getString(5), rs.getString(6));
			transactions.add(t);
		}
		
		return transactions;
		
	}

//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	public int createTransaction(Transaction t) throws SQLException, Exception {
		Connection conn = DBUtil.getInstance().getConnection();

		PreparedStatement pstmt = conn.prepareStatement("INSERT INTO bank.transactions (id, reciever, sender, amount, status, type) values (?, ?, ?, ?, ?, ?)");
		pstmt.setInt(1, t.getId());
		pstmt.setString(2, t.getReciever());
		pstmt.setString(3, t.getSender());
		pstmt.setDouble(4, t.getAmount());
		pstmt.setString(5, t.getStatus());
		pstmt.setString(6, t.getType());
		int rows = pstmt.executeUpdate();
		
		return rows;
	}

	
//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	public void acceptTransaction(Customer reciever, Transaction t) throws SQLException, Exception {
		Connection conn = DBUtil.getInstance().getConnection();
		//get the sending customer
		Customer sender = getSenderAccount(conn, t.getSender());
		
		System.out.println(reciever.toString());
		System.out.println(sender.toString());
		
		//deposit / withdraw for the receiving customer
		if(t.getType().equals(AppConstants.ACCOUNT_DEPOSIT)) {
			updateAccountBalance(reciever, t.getAmount(), AppConstants.ACCOUNT_DEPOSIT);
			reciever.setBalance(reciever.getBalance() + t.getAmount());
			updateAccountBalance(sender, t.getAmount(), AppConstants.ACCOUNT_WITHDRAW);
		//withdraw / deposit for the sending customer
		}else if(t.getType().equals(AppConstants.ACCOUNT_WITHDRAW)) {
			updateAccountBalance(reciever, t.getAmount(), AppConstants.ACCOUNT_WITHDRAW);
			reciever.setBalance(reciever.getBalance() - t.getAmount());
			updateAccountBalance(sender, t.getAmount(), AppConstants.ACCOUNT_DEPOSIT);
		}
		
		
		//update status to successful.
		PreparedStatement pstmt = conn.prepareStatement("UPDATE bank.transactions SET status=? WHERE id=?");
		pstmt.setString(1, AppConstants.TRANSACTION_SUCCESSFUL);
		pstmt.setInt(2, t.getId());
		pstmt.executeUpdate();
		t.setType(AppConstants.TRANSACTION_SUCCESSFUL);
		
		
	}
	
//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	public Customer getSenderAccount(Connection conn, String sender) throws SQLException {
		PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM bank.accounts WHERE username=?");
		pstmt.setString(1, sender);
		
		ResultSet rs = pstmt.executeQuery();
		int id = 0;
		String name = null;
		String uname = null;
		String pwd = null;
		double amt = 0;
		
		while(rs.next()) {
			uname = rs.getString(3);
			amt = rs.getDouble(5);
		}
			Customer c = new Customer(uname, amt);
			c.setId(id);
			return c;
	}

	

}
