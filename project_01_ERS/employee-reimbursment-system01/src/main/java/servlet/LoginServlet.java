package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import common.Employee;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		ObjectMapper mapper = new ObjectMapper();
		//Employee employee = mapper.readValue(HttpUtil.getJSONData(req), Employee.class);
		
	}
	
}
