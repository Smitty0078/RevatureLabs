package dao;

import java.util.List;

import common.Ticket;

public interface TicketDAO {

	public void createTicket(Ticket t);
	public Ticket getTicket(int employeeId, int ticketNum);
	public List<Ticket> getAllTickets(int employeeId);
	
	
}
