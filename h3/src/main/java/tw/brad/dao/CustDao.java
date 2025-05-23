package tw.brad.dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.h3.HibernateUtil;
import tw.brad.model.Cust;
import tw.brad.model.Order;

public class CustDao {
	public void save(Cust cust) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(cust);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}

	public void delete(Cust cust) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.remove(cust);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}		
	}

	public void update(Cust cust) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.merge(cust);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}		
	}
	
	public Cust getById(int id) {
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			
			Cust cust = session.get(Cust.class, id);
			//Hibernate.initialize(cust.getOrders());
			
			return cust;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}		
	}
	
	public Order getOrderById(int id) {
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			
			Order order = session.get(Order.class, id); 
			
			return order;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}		
		
	}
	
	public void removeOrderFromCust(long custId, long orderId) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			Cust cust = session.get(Cust.class, custId);
			Order targetOrder = null;
			for (Order order : cust.getOrders()) {
				if (order.getId() == orderId) {
					targetOrder = order;
					break;
				}
			}
			
			if (targetOrder != null) {
				cust.removeOrder(targetOrder);
			}
			
			session.merge(cust);
			
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}				
	} 
	
	
	
	
	
	
	
	
	
	
	
	
}
