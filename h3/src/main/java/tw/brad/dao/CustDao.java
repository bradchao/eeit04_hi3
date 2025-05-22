package tw.brad.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.h3.HibernateUtil;
import tw.brad.model.Cust;

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
			
			return session.get(Cust.class, id);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}		
	}
	
	
}
