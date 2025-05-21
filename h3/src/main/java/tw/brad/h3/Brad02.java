package tw.brad.h3;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.model.Member;


public class Brad02 {
	public static void main(String[] args) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()){
			Transaction transaction = session.beginTransaction();
			
			String sql = "INSERT INTO member (account,passwd,cname)" + 
						" VALUES (:account, :passwd, :cname)";
			NativeQuery<Member> query =
				session.createNativeQuery(sql, Member.class);
			query.setParameter("account", "brad111");
			query.setParameter("passwd", "brad222");
			query.setParameter("cname", "brad333");
			
			int n = query.executeUpdate();
			
			transaction.commit();
			
			System.out.println(n);
			
			
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
