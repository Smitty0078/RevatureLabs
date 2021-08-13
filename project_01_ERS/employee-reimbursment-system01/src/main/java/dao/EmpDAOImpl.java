package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.Employee;
import common.util.DBUtil;

public class EmpDAOImpl implements EmpDAO {

	@Override
	public void create(Employee employee) {
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
