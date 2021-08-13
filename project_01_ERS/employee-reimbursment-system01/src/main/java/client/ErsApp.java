package client;

import common.Employee;
import common.User;
import service.UserService;

public class ErsApp {

	public static void main(String[] args) {
		System.out.println("Hello");
		UserService service = new UserService();
		User e = service.getEmployee("sdfsdf", "sdfsdf");
		
		//User e2 = new User (2, "Bobby Hill", "uname1", "pwd", false);
		//service.create(e2);
		
		//System.out.println(e.toString());
	}
	
}
