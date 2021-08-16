package service;

import java.util.List;
import java.util.Set;

import common.Ticket;
import dao.TicketDAO;
import dao.TicketDAOImpl;

public class TicketService {

	TicketDAO dao = new TicketDAOImpl();
	
	public void createTicket(Ticket t){
		dao.createTicket(t);
	}
	
	public Ticket getTicket(int employeeId, int ticketNum) {
		return dao.getTicket(employeeId, ticketNum);
	}
	
	public Set<Ticket> getAllTickets(int employeeId){
		return dao.getAllTickets(employeeId);
	}
	
}
