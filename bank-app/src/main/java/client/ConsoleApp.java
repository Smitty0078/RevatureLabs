package client;

import java.sql.SQLException;
import java.util.Scanner;

import common.pojo.Customer;
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
			
			/*uncomment for main implementation
			greeting();
			input = scanner.next();
			parse(input);
			*/
			
			createCustomerAccount();
			
			//comment out for main implementation
			exit=true;
		}
		
		
		scanner.close();
	}
	
//--------------------------------------------------------------	
/* Description:
 * Pre-conditions:
 * Post-conditions:	
 */
	public void greeting(){
		System.out.println("Welcome To Our Banking App!\n"
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
	public void parse(String input) {
		switch(input) {
			case "1":
				customerSignIn();
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
	public void customerSignIn() {
		System.out.println("customer sign in");
		//TODO: wire service object here...
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
		
		System.out.println("create customer CLIENT layer");
		
		//testing stuff
		//String daoTest = "daoTest";
		//double testBalance = 0.0;
		//Customer test = new Customer(daoTest, daoTest, daoTest, testBalance);
		//test.setBankingHistory(AppConstants.BANK_HISTORY_GOOD);
		
		Customer customer = getNewCustomer();
		System.out.println(customer.toString());
		
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
		
		name = getNewCustomerInput("first name");
		name += " "+getNewCustomerInput("last name");
		//TOD0: CHECK FOR EXISTING USERNAME
		username = getNewCustomerInput("username");
		password = getNewCustomerInput("password");
		startingBalance = getStartingBalance();
		
		Customer c = new Customer(name, username, password, startingBalance);
		return c;
	}

//--------------------------------------------------------------	
/* Description:
 * Pre-conditions:
 * Post-conditions:	
 */
	public String getNewCustomerInput(String custAttribute) {
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
	public double getStartingBalance() {
		boolean validated = false;
		String amount;
		double startingBalance = 0;
		do {
			try {
				amount = getNewCustomerInput("starting account balance");
				startingBalance = Double.valueOf(amount);
				validated = true;
			} catch(NumberFormatException e) {
				System.out.println("Please enter a decimal value.\n");
			}
		}while(!validated);
		return startingBalance;
	}
	

	
	
	
}
