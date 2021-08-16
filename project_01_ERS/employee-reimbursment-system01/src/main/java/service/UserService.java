package service;

import common.Employee;
import common.User;
import dao.EmpDAO;
import dao.EmpDAOImpl;

public class UserService {

	EmpDAO dao = new EmpDAOImpl();
	
	public void create(User e) {
		//add validation here
		dao.create(e);
	}
	
	public User getEmployee(int id, String username, String password) {
		//add validation here
		return dao.getEmployee(id, username, password);
	}

	public boolean login(int id, String username, String password) {
		if(dao.getEmployee(id, username, password) !=null )
		{
			return true;
		}
		return false;
	}
	
}
