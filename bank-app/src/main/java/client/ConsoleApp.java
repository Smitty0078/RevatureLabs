package client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.pojo.Customer;
import common.pojo.Transaction;
import common.util.AppConstants;
import service.BankService;

public class ConsoleApp {
	
	private BankService service = new BankService();
	private static boolean exit = false; 
	private Scanner scanner;
/* Description:
 * Pre-conditions:
 * Post-conditions:	
 */
	public void start() {
		String input;
		scanner = new Scanner(System.in);
		while(!exit) {
			appGreeting();
			input = scanner.next();
			parse(input, scanner);
		}
		
		
		scanner.close();
	}
	
//--------------------------------------------------------------	
/* Description:
 * Pre-conditions:
 * Post-conditions:	
 */
	public void appGreeting(){
		System.out.println("\nWelcome To Our Banking App!\n"
							+ "\nWhat would you like to do?\n"
							+ "Customer Sign In:   ENTER 1\n"
							+ "Employee Sign In:   ENTER 2\n"
							+ "Create New Account: ENTER 3\n"
							+ "Exit:               ENTER 4");
	}
	
//--------------------------------------------------------------	
/* Description: Receives user input, and executes switch statement
 * 				to affect flow of control
 * Pre-conditions: Input must be passed as a string value
 * Post-conditions:	none
 */
	public void parse(String input, Scanner scanner) {
		switch(input) {
			case "1":
				customerSignIn(scanner);
				break;
			case "2":
				employeeSignIn();
				break;
			case "3":
				createCustomerAccount();
				break;
			case "4":
				exit();
				break;
			default:
				invalidInput();
		}
	}
	
//--------------------------------------------------------------	
/* Description: Called when user has selected to sign in as a customer
 * Pre-conditions: Input = 1
 * Post-conditions:	TODO: update if needed
 */
	public void customerSignIn(Scanner scanner) {
		String username;
		String password;
		List<String> messages = new ArrayList<String>();
		
		username = getInput("username");
		password = getInput("password");
		
		try {
			Customer customer = service.customerSignIn(username, password, messages);
			if(messages.isEmpty()){
				customerMenu(customer, scanner);
			}else {
				printSignInMessages(messages);
				//recursion provides a solution to account not found
				customerSignIn(scanner);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//--------------------------------------------------------------	
/* Description:
 * Pre-conditions:
 * Post-conditions:
 */	
	public void printSignInMessages(List<String> messages) {
		System.out.println("Account not found: ");
		for(String s : messages){
			System.out.println(s);
		}
	}
	
//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */	
	private void customerMenu(Customer customer, Scanner scanner) {
		boolean signout = false;
		do {
			System.out.println("\nWhat would you like to do?\n"
							 + "View Balance:          ENTER 1\n"
							 + "Deposit:               ENTER 2\n"
							 + "Withdraw:              ENTER 3\n"
							 + "View Transactions:     ENTER 4\n"
							 + "Transfer Funds:        ENTER 5\n"
							 + "Sign out:              ENTER 6\n");
			
			String input = scanner.next();
			signout = parseCustomerOption(input, customer);
		}while(!signout);
	}

//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	private boolean parseCustomerOption(String input, Customer customer) {
			switch(input) {
			case "1":
				viewBalance(customer);
				break;
			case "2":
				deposit(customer, scanner);
				break;
			case "3":
				withdraw(customer, scanner);
				break;
			case "4":
				viewTransactions(customer, scanner);
				break;
			case "5":
				transfer(customer, scanner);
				break;
			case "6":
				System.out.println("Signing off...");
				return true;
			default:
				invalidInput();
		}
			return false;
	}
	
	//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	public void viewTransactions(Customer customer, Scanner scanner) {
		System.out.println("VIEW TRANSACTIONS CLIENT LAYER");
		List<Transaction> transactions = null;
		try {
			transactions = service.getTransactions(customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!transactions.isEmpty()) {
			for(Transaction t : transactions) {
				System.out.println(t.toString());
				if(t.getStatus() == AppConstants.TRANSACTION_PENDING) {
					System.out.println("In comparison statement PENDING");
					//handleTransaction(customer, t);
				}
			}
			
			//TODO: SEARCH FOR PENDING TRANSACTIONS HANDLE THEM HERE!!!
		}else {
			System.out.println("No transactions available.");
		}
		
	}

	private void handleTransaction(Customer customer, Transaction t) {
		// TODO Auto-generated method stub
		
	}

	//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	private void transfer(Customer customer, Scanner scanner) {
		System.out.println("transfer");
		String reciever = getInput("transfer reciever username");
		String sender = customer.getUserName();
		double amount = getDoubleInput("transfer amount");
		String status = AppConstants.TRANSACTION_PENDING;
		String type = getTransactionTypt(reciever, scanner);
		
		
		
		//deposit to receiving account
		//withdrawl from sending account
	}

private String getTransactionTypt(String user, Scanner scanner) {
	boolean valid = false;
	String type = null;
	do {
			System.out.println("\nWhich transaction would you like:\n" 
					          + "Request Funds From " + user + ": Enter 1\n"
					          + "Transfer Funds To " + user + ": Enter 2\n");
			String input = scanner.next();
			if(input == "1") {
				type = AppConstants.ACCOUNT_WITHDRAW;
				valid = true;
			}else if(input == "2") {
				type = AppConstants.ACCOUNT_DEPOSIT;
				valid = true;
			}
		} while (!valid);
		return type;
	}

	//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	private void withdraw(Customer customer, Scanner scanner2) {
		double amt = 0;
		int rowsAffected;
		//this handles negative values
		do {
			amt = getDoubleInput("amount to withdrawl");
			if(amt <= 0)
				System.out.println("Invalid input: cannot withdrawl a negative amount.");
		}while(amt <= 0.0);
		try {
			rowsAffected = service.updateAccountBalance(customer, amt, AppConstants.ACCOUNT_WITHDRAW);
			System.out.println("rows affected: "+rowsAffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	//--------------------------------------------------------------	
/* Description:
 * Pre-conditions: 
 * Post-conditions:	
 */
	private void deposit(Customer customer, Scanner scanner) {
		// TODO Auto-generated method stub
		double amt = 0;
		int rowsAffected;
		//this handles negative values
		do {
			amt = getDoubleInput("amount to deposit");
			if(amt <= 0)
				System.out.println("Invalid input: cannot deposit a negative amount.");
		}while(amt <= 0.0);
		try {
			rowsAffected = service.updateAccountBalance(customer, amt, AppConstants.ACCOUNT_DEPOSIT);
			System.out.println("rows affected: "+rowsAffected);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//--------------------------------------------------------------	
/* Description: Displays the balance data retrieved.
 * Pre-conditions: Customer is not null
 * Post-conditions:	Customer balance is printed to the console
 */
	private void viewBalance(Customer customer) {
			System.out.println("The current account balance is: $"+customer.getBalance());
			//TODO: ADD QUERY LINK WITH SERVICE / DAO
	}

//--------------------------------------------------------------	
/* Description: Called when user has selected to sign in as an employee
 * Pre-conditions: input = 2
 * Post-conditions:	TODO: update if needed
 */
	public void employeeSignIn() {
		System.out.println("employee sign in");
		//TODO: wire service object here...
	}
	
//--------------------------------------------------------------	
/* Description: Called when user has selected to create a new account
 * Pre-conditions: input = 3
 * Post-conditions:	TODO: update if needed
 */
	public void createCustomerAccount() {
		
		Customer customer = getNewCustomer();
		//check for username already exists
		System.out.println(customer.toString());
		
		//TODO: ADD APPROVE OR DENY EMPLOYEE METHOD HERE
		int result;
		try {
			//TODO: CALL EMPLOYEE METHOD TO APPOROVE OR DENY BASED ON BANKING HISTORy
			result = service.createCustomerAccount(customer);
			System.out.println("num of rows affected: "+result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
//--------------------------------------------------------------	
/* Description: Called when user has selected to exit the app
 * Pre-conditions: User input = 4
 * Post-conditions:	exit loop control variable set to true
 */
	public void exit() {
		System.out.println("Exiting...");
		exit = true;
	}
	
//--------------------------------------------------------------	
/* Description:
 * Pre-conditions:
 * Post-conditions:	
 */
	public void invalidInput() {
		System.out.println("Invalid input.");
	}
	
//--------------------------------------------------------------	
/* Description:
 * Pre-conditions:
 * Post-conditions:	
 */
	public Customer getNewCustomer() {
		String name;
		String username;
		String password;
		double startingBalance = 0;
		
		name = getInput("first name");
		//TODO: USE STRINGBUILDER HERE
		name += " "+getInput("last name");
		//TOD0: CHECK FOR EXISTING USERNAME
		username = getInput("username");
		password = getInput("password");
		startingBalance = getDoubleInput("starting account balance");
		
		Customer c = new Customer(name, username, password, startingBalance);
		return c;
	}

//--------------------------------------------------------------	
/* Description:
 * Pre-conditions:
 * Post-conditions:	
 */
	public String getInput(String custAttribute) {
		String input;
		System.out.println("Please enter your "+custAttribute+" :");
		input = scanner.next();
		return input;
	}
	
//--------------------------------------------------------------	
/* Description:
 * Pre-conditions:
 * Post-conditions:	
 */
	public double getDoubleInput(String message) {
		boolean validated = false;
		String amount;
		double startingBalance = 0;
		do {
			try {
				amount = getInput(message);
				startingBalance = Double.valueOf(amount);
				validated = true;
			} catch(NumberFormatException e) {
				System.out.println("Please enter a decimal number value.\n");
			}
		}while(!validated);
		return startingBalance;
	}
	

	
	
	
}
