package tw.brad.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import tw.brad.apis.BCrypt;
import tw.brad.h3.HibernateUtil;
import tw.brad.model.Gift;
import tw.brad.model.Member;

public class GiftDao {
	
	public void save(Gift gift) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.persist(gift);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}
	}
	
	public void delete(Gift gift) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.remove(gift);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}		
	}

	public void update(Gift gift) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			session.merge(gift);
			
			transaction.commit();
		}catch(Exception e) {
			System.out.println(e);
			if (transaction != null) {
				transaction.rollback();
			}
		}		
	}
	
	public Gift getById(int id) {
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			
			return session.get(Gift.class, id);
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}		
	}
	
	public List<Gift> getAll(){
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			String hql = "FROM Gift";
			return session.createQuery(hql, Gift.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}				
	}
	
	public List<Gift> getHql(String hql){
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			return session.createQuery(hql, Gift.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}				
	}
	
	public List<Gift> getSQL(String sql){
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			return session.createNativeQuery(sql, Gift.class).getResultList();
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}				
	}
	
	
}
