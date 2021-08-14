package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import common.Ticket;
import common.User;
import common.util.DBUtil;

public class TicketDAOImpl implements TicketDAO{

	@Override
	public void createTicket(Ticket t) {
		Session session = DBUtil.getInstance().getSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(t);
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
	public Ticket getTicket(int employeeId, int ticketNum) {
Session session = DBUtil.getInstance().getSession();
		
		Query query = session.createQuery("FROM common.Ticket where ticket_id = :tid and employee_id = :eid");
		query.setInteger("tid", ticketNum);
		query.setInteger("eid", employeeId);
		
		Ticket t = (Ticket) query.uniqueResult();
		
		session.close();
		return t;
	}

	@Override
	public List<Ticket> getAllTickets() {
		// TODO Auto-generated method stub
		return null;
	}

}
