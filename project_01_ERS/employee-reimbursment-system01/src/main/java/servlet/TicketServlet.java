package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import common.Ticket;
import common.User;
import common.util.AppConstants;
import common.util.HttpUtil;
import service.TicketService;

@WebServlet("/tickets")
public class TicketServlet extends HttpServlet{

	private TicketService service = new TicketService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jsonInString = null;
		ObjectMapper mapper = new ObjectMapper();

		String[] pathVariables = HttpUtil.getPathVariables(req);
		
		try {
			User user = mapper.readValue(HttpUtil.getJSONData(req), User.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		/*
		if(pathVariables == null || pathVariables.length == 0) {
			//get data from backend
			List<Ticket> tickets = service.getAllTickets();
			//transform java object to JSON string
			jsonInString = mapper.writeValueAsString(tickets);
		} 
		// GET /employee/:id
		// fetch individual ticket
		if(pathVariables != null && pathVariables.length == 2) {
			//get data from backend
			//get specific ticket from id table
			//id = Integer.parseInt(pathVariables[1]
			//Ticket t = service.getEmployeeById(id)
			//if (u != null){
			//	jsonInString = mapper.writeValueAsString(t);
			//} else{
			//	jsonInString = HttpUtil.getErrorMessage("No Record Found");
			//}
			
		}
		
		//send success response to client
		resp.getWriter().print(jsonInString);
		resp.setContentType(AppConstants.HTTP_JSON_CONTENT);
		resp.setStatus(AppConstants.HTTP_OK);
		*/
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//get JSON data from HTTP body
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			Ticket ticket = mapper.readValue(HttpUtil.getJSONData(req), Ticket.class);
			//persist data to backend
			service.createTicket(ticket);
			//send success response to client
			String jsonResponse = mapper.writeValueAsString(ticket);
			resp.getWriter().print(jsonResponse);
			resp.setStatus(AppConstants.HTTP_OK);
		} catch (Exception e) {
			//send failure response to client
			resp.getWriter().print(HttpUtil.getErrorMessage(e.getMessage()));
			resp.setStatus(AppConstants.HTTP_ERROR);
		}

		resp.setContentType(AppConstants.HTTP_JSON_CONTENT);

	}
	
}
