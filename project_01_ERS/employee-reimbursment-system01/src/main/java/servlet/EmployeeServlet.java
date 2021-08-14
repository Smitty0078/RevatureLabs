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

import common.User;
import common.util.AppConstants;
import common.util.HttpUtil;
import service.UserService;

@WebServlet("/employee")
public class EmployeeServlet extends HttpServlet{

	private UserService service = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String jsonInString = null;
		ObjectMapper mapper = new ObjectMapper();

		String[] pathVariables = HttpUtil.getPathVariables(req);
		
		if(pathVariables == null || pathVariables.length == 0) {
			//get data from backend
			List<User> users = null; //service.findAll()
			//transform java object to JSON string
			jsonInString = mapper.writeValueAsString(users);
		} 
		// GET /employee/:id
		// fetch individual employee
		if(pathVariables != null && pathVariables.length == 2) {
			//get data from backend
			//get specific employee from id table
			//id = Integer.parseInt(pathVariables[1]
			//User u = service.getEmployeeById(id)
			//if (u != null){
			//	jsonInString = mapper.writeValueAsString(u);
			//} else{
			//	jsonInString = HttpUtil.getErrorMessage("No Record Found");
			//}
			
		}
		
		//send success response to client
		resp.getWriter().print(jsonInString);
		resp.setContentType(AppConstants.HTTP_JSON_CONTENT);
		resp.setStatus(AppConstants.HTTP_OK);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("hi");
		try {
			//get JSON data from HTTP body
			ObjectMapper mapper = new ObjectMapper();
			mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
			User user = mapper.readValue(HttpUtil.getJSONData(req), User.class);
			//persist data to backend
			service.create(user);
			//send success response to client
			String jsonResponse = mapper.writeValueAsString(user);
			resp.getWriter().print(jsonResponse);
			resp.setStatus(AppConstants.HTTP_OK);
		} catch (Exception e) {
			//send failure response to client
			resp.getWriter().print(HttpUtil.getErrorMessage(e.getMessage()));
			resp.setStatus(AppConstants.HTTP_ERROR);
		}

		resp.setContentType(AppConstants.HTTP_JSON_CONTENT);

	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] pathVariables = HttpUtil.getPathVariables(req);
		// GET /menus/:id
		// fetch individual menu item
		if(pathVariables != null && pathVariables.length == 2) {
			//get data from backend
			int id = Integer.parseInt(pathVariables[1]);
			//manager.delete(id);
			resp.setStatus(AppConstants.HTTP_OK);
		}
	}
	
	
}
