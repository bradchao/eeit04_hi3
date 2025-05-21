package tw.brad.h3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class Brad04 {
	public static void main(String[] args) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			String sql = "SELECT * FROM member";
			NativeQuery query = session.createNativeQuery(sql);
			List list = query.getResultList();
			for (Object row: list) {
				Object[] row2 = (Object[]) row;
				Integer id = (Integer)row2[0];
				String account = (String)row2[1];
				System.out.printf("%d : %s\n", id, account);
			}
			
			transaction.commit();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
