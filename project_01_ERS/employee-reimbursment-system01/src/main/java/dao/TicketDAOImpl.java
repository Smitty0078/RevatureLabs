package dao;

import java.util.List;
import java.util.Set;

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
	public Set<Ticket> getAllTickets(int employeeId) {
		Session session = DBUtil.getInstance().getSession();
		
		System.out.println("employee id: "+employeeId);
		
	
		Query query = session.createQuery("select * from common.Ticket where employee_id = :eid");
		query.setInteger("eid", employeeId);
		
		Set<Ticket> t = (Set<Ticket>) query.uniqueResult();
		
		for(Ticket t2 : t) {
			System.out.println(t2.toString());
		}
		
		//Transaction tx = session.beginTransaction();
		//List<Ticket> t = (List<Ticket>) session.createQuery("FROM ers.ticket").list();
		
//		Query query = session.createQuery("FROM common.Ticket where employee_id = :eid");
//		query.setInteger("employee_id", employeeId);
//		
//		//List<Ticket> 
		
		//session.close();
		return null;
	}

}
