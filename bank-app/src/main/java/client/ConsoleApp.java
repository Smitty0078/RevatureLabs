package client;

import java.util.Scanner;

public class ConsoleApp {
	
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
			greeting();
			input = scanner.next();
			parse(input);
			
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
				createNewAccount();
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
	public void createNewAccount() {
		System.out.println("create new account");
		//TODO: wire service object here...
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

	
	
	
	
}
