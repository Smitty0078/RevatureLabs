package client;

import common.Employee;
import common.User;
import service.UserService;

public class ErsApp {

	public static void main(String[] args) {
		System.out.println("Hello");
		UserService service = new UserService();
		User e = service.getEmployee("tst", "tst");
		
		System.out.println(e.toString());
	}
	
}
