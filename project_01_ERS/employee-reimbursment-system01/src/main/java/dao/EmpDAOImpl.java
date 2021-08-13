package dao;

import org.hibernate.Session;
import org.hibernate.Query;

import common.Employee;
import common.util.DBUtil;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public void create(Employee employee) {
		Session session = DBUtil.getInstance().getSession();
		
		
	}

	@Override
	public Employee signIn(String username, String password) {
		Session session = DBUtil.getInstance().getSession();
		
		Query query = session.createQuery("FROM common.User where username = :username and password = :password");
		query.setString("username", username);
		query.setString("password", password);
		
		Employee e = (Employee) query.uniqueResult();
		
		session.close();
		return null;
	}

}
