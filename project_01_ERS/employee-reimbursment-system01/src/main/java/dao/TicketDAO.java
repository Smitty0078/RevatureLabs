package dao;

import java.util.List;
import java.util.Set;

import common.Ticket;

public interface TicketDAO {

	public void createTicket(Ticket t);
	public Ticket getTicket(int employeeId, int ticketNum);
	public Set<Ticket> getAllTickets(int employeeId);
	
	
}
