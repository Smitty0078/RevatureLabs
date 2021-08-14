package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.Employee;
import common.User;
import common.util.AppConstants;
import common.util.HttpUtil;
import service.UserService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private UserService service = new UserService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			//get JSON data from HTTP body
			ObjectMapper mapper = new ObjectMapper();
			User user = mapper.readValue(HttpUtil.getJSONData(req), User.class);
			//persist data to backend
			boolean success = service.login(user.getUsername(), user.getPassword()); //do login here
			//send success response to client
			
			resp.getWriter().print( "{\"status\":"+ (success ? "\"success\"" : "\"failure\"") + "}");
			resp.setStatus(AppConstants.HTTP_OK);
		} catch (Exception e) {
			//send failure response to client
			resp.getWriter().print(HttpUtil.getErrorMessage(e.getMessage()));
			resp.setStatus(AppConstants.HTTP_ERROR);
		}

		resp.setContentType(AppConstants.HTTP_JSON_CONTENT);
	}
	
}
