package client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import common.pojo.Customer;
import common.pojo.Employee;
import common.pojo.Transaction;
import common.pojo.User;
import common.util.AppConstants;
import service.BankService;


public class ConsoleApp {
	
	private BankService service = new BankService();
	private static boolean exit = false; 
	private Scanner scanner;
	
/* Description: Method that runs the app
 * Pre-conditions: none
 * Post-conditions:	scanner object is closed
 */
	public void start() {
		String input;
		scanner = initializeScanner();
		setIdCounters("accounts", "transactions");
		while(!exit) {
			appGreeting();
			input = scanner.next();
			parse(input, scanner);
		}
		
		
		scanner.close();
	}
	
	public Scanner initializeScanner() {
		return new Scanner(System.in);
	}
	
//--------------------------------------------------------------	
/* Description: Retrieves the max id of the accounts table and transactions table
 * Pre-conditions: none
 * Post-conditions:	Set the idCtrs to max+1
 */
public void setIdCounters(String accounts, String transactions) {
		try {
			User.setIdCtr(service.setIdCtr(accounts) + 1);
			System.out.println("user.idCtr = "+User.getIdCtr());
			Transaction.setIdCtr(service.setIdCtr(transactions) + 1);
			System.out.println("tran.idCtr = "+Transaction.getIdCtr());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//--------------------------------------------------------------	
/* Description: Prints greeting and asks user what they would like to do
 * Pre-conditions: none
 * Post-conditions:	none
 */
	public void appGreeting(){
		System.out.println("\nWelcome To Our Banking App!\n"
							+ "\nWhat would you like to do?\n"
							+ "Customer Sign In:      ENTER 1\n"
							+ "Employee Sign In:      ENTER 2\n"
							+ "Register New Account:  ENTER 3\n"
							+ "Exit:                  ENTER 4");
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
				employeeSignIn(scanner);
				break;
			case "3":
				registerNewCustomerAccount(scanner);
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
		
		username = getInput("username", scanner);
		password = getInput("password", scanner);
		
		try {
			Customer customer = service.getCustomerAccount(username, password, messages);
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
				if(t.getStatus().equals(AppConstants.TRANSACTION_PENDING)) {
					handleTransaction(customer, t, scanner);
				}
			}
			
		}else {
			System.out.println("No transactions available.");
		}
		
	}

//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	private void handleTransaction(Customer customer, Transaction t, Scanner scanner) {
		boolean validated = false;
		
		do {
			System.out.println(t.printPendingTransaction() + "\nWhat would you like to do?\n" + "Accept: ENTER 1\n"
					+ "Deny:   ENTER 2\n");
			String input = scanner.next();
			if (input.equals("1")) {
				System.out.println("ACCEPTING REQUEST");
				try {
					service.acceptTransaction(customer, t);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				validated = true;
			} else if (input.equals("2")) {
				System.out.println("DENYING REQUEST");
				validated = true;
			} 
		} while (!validated);
		
				
	}

	//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	private void transfer(Customer customer, Scanner scanner) {
		System.out.println("transfer");
		boolean validated = false;
		String sender = customer.getUserName();
		String status = AppConstants.TRANSACTION_PENDING;
		Transaction transaction = null;
		do {
			String reciever = getInput("transfer reciever username", scanner);
			double amount = getDoubleInput("transfer amount", scanner);
			String type = getTransactionType(reciever, scanner);
			transaction = new Transaction(reciever, sender, amount, status, type);
			System.out.println("Please review the following transaction:\n" + transaction.toString() + "\nIs this correct?\n"
					+ "ENTER 1 for Yes\n" + "ENTER 2 for No\n" + "Enter 3 for Cancel\n");
			String choice = scanner.next();
			if (choice.equals("1")) {
				validated = true;
			} else if (choice.equals("2")) {
				System.out.println("Restarting transaction...");
				validated = false;
			} else if (choice.equals("3")) {
				return;
			}else {
				System.out.println("Invalid input. Restarting Transaction...");
			}
		} while (!validated);
		
		try {
			int rows = service.createTransaction(transaction);
			Transaction.incrementIdCtr();
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

	private String getTransactionType(String user, Scanner scanner) {
			System.out.println("\nWhich transaction would you like:\n" 
					          + "Transfer Funds To " + user + ": Enter 1\n"
					          + "Request Funds From " + user + ": Enter 2\n");
			String input = scanner.next();
			if(input.equals("1")) {
				return String.valueOf(AppConstants.ACCOUNT_DEPOSIT);
			}else if(input.equals("2")) {;
				return String.valueOf(AppConstants.ACCOUNT_WITHDRAW);
			}
			return null;
	}

	//--------------------------------------------------------------	
/* Description: 
 * Pre-conditions: 
 * Post-conditions:	
 */
	private void withdraw(Customer customer, Scanner scanner) {
		double amt = 0;
		int rowsAffected;
		//this handles negative values
		do {
			amt = getDoubleInput("amount to withdrawl", scanner);
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
			amt = getDoubleInput("amount to deposit", scanner);
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
			try {
				Double balance = service.getBalance(customer.getUserName());
				System.out.println("The current account balance is: $" + balance);
				customer.setBalance(balance);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

//--------------------------------------------------------------	
/* Description: Called when user has selected to sign in as an employee
 * Pre-conditions: input = 2
 * Post-conditions:	TODO: update if needed
 */
	public void employeeSignIn(Scanner scanner) {
		System.out.println("employee sign in");
		String username = getInput("username", scanner);
		String password = getInput("password", scanner);
		
		if(username.equals(AppConstants.EMPLOYEE_ADMIN_USERNAME) && password.equals(AppConstants.EMPLOYEE_ADMIN_PASSWORD)) {
			employeeMenu(scanner);
		}else {
			System.out.println("Invalid username or password");
		}
		
	}
	
//--------------------------------------------------------------	
/* Description:
 * Pre-conditions: 
 * Post-conditions:	
 */
	private void employeeMenu(Scanner scanner) {
		boolean signout = false;
		do {
			System.out.println("\nWhat would you like to do?\n" 
								+ "View Customer Balance:          ENTER 1\n"
								+ "Review New Account Requests:    ENTER 2\n" 
								+ "Sign out:                       ENTER 3\n");
			String input = scanner.next();
			if (input.equals("1")) {
				System.out.println("viewing balance...");
				String username = getInput("customer username", scanner);
				Customer c = null;
				try {
					c = service.getCustomerAccount(username);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				viewBalance(c);
			} else if (input.equals("2")) {
				System.out.println("reviewing requests...");
			} else if (input.equals("3")) {
				signout = true;
			} else {
				System.out.println("Invalid input...");
			} 
		} while (!signout);
	}

//--------------------------------------------------------------	
/* Description:
 * Pre-conditions: 
 * Post-conditions:	
 */
	public void registerNewCustomerAccount(Scanner scanner){
		Customer tmp = null;
		Customer customer = getNewCustomer(scanner);
		Employee admin = new Employee();
		System.out.println("Please enter your banking history:\n"
						 + "Good History: ENTER 1\n"
						 + "Bad History:  ENTER 2\n");
		String history = scanner.next();
		if(history.equals("1")) {
			customer.setBankingHistory(AppConstants.BANK_HISTORY_GOOD);
		}else if(history.equals("2")) {
			customer.setBankingHistory(AppConstants.BANK_HISTORY_BAD);
		}
		
		System.out.println(customer.toString());
		
		if(admin.approveOrDeny(customer.getBankingHistory())) {
			System.out.println("approved");
			try {
				 tmp = service.checkForExistingUser(customer.getUserName());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(tmp.toString());
			if(tmp == null) {
				System.out.println("Creating new customer account");
				createCustomerAccount(customer);
			}else {
				System.out.println("The username "+customer.getUserName()+" already exists...\n");
			}
				
		}else {
			System.out.println("Denied...\n");
		}
	}
	
	//--------------------------------------------------------------	
/* Description: Called when user has selected to create a new account
 * Pre-conditions: input = 3
 * Post-conditions:	TODO: update if needed
 */
	public void createCustomerAccount(Customer customer) {
		
		int result;
		try {
			//TODO: CALL EMPLOYEE METHOD TO APPOROVE OR DENY BASED ON BANKING HISTORy
			customer.setId(User.getIdCtr());
			result = service.createCustomerAccount(customer);
			System.out.println("num of rows affected: "+result);
			User.incrementIdCtr();
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
	public Customer getNewCustomer(Scanner scanner) {
		String name;
		String username;
		String password;
		double startingBalance = 0;
		
		name = getInput("first name", scanner);
		//TODO: USE STRINGBUILDER HERE
		name += " "+getInput("last name", scanner);
		//TOD0: CHECK FOR EXISTING USERNAME
		username = getInput("username", scanner);
		password = getInput("password", scanner);
		startingBalance = getDoubleInput("starting account balance", scanner);
		
		Customer c = new Customer(name, username, password, startingBalance);
		return c;
	}

//--------------------------------------------------------------	
/* Description:
 * Pre-conditions:
 * Post-conditions:	
 */
	public String getInput(String custAttribute, Scanner scanner) {
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
	public double getDoubleInput(String message, Scanner scanner) {
		boolean validated = false;
		String amount;
		double startingBalance = 0;
		do {
			try {
				amount = getInput(message, scanner);
				startingBalance = Double.valueOf(amount);
				validated = true;
			} catch(NumberFormatException e) {
				System.out.println("Please enter a decimal number value.\n");
			}
		}while(!validated);
		return startingBalance;
	}
	

	
	
	
}
