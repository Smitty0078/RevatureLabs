package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.Employee;
import common.User;
import common.util.DBUtil;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public void create(User employee) {
		Session session = DBUtil.getInstance().getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(employee);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;// new RuntimeException(e.getCause());
		}

		session.close();
		
		
	}

	@Override
	public User getEmployee(String username, String password) {
		Session session = DBUtil.getInstance().getSession();
		
		Query query = session.createQuery("FROM common.User where username = :uname and password = :pswd");
		query.setString("uname", username);
		query.setString("pswd", password);
		
		User e = (User) query.uniqueResult();
		
		session.close();
		return e;
	}
	
	

}
