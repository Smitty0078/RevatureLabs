package client;

import common.Employee;
import common.Ticket;
import common.User;
import service.TicketService;
import service.UserService;

public class ErsApp {

	public static void main(String[] args) {
		System.out.println("Hello");
		//UserService service = new UserService();
		//User e = service.getEmployee("sdfsdf", "sdfsdf");
		
		//User e2 = new User (2, "Bobby Hill", "uname1", "pwd", false);
		//service.create(e2);
		
		//System.out.println(e.toString());
		
		TicketService tservice = new TicketService();
		//Ticket t = tservice.getTicket(0, 0);
		
		//System.out.println(t.toString());
		
		//Ticket t2 = new Ticket(3, 0, 75.00, "this is hibernate test");
		
		//tservice.createTicket(t2);
		
		
	}
	
}
