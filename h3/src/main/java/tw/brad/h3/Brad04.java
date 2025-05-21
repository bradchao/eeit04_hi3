package tw.brad.h3;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import tw.brad.model.Member;

public class Brad04 {
	public static void main(String[] args) {
		Transaction transaction = null;
		try(Session session = 
				HibernateUtil.getSessionFactory().openSession()){
			transaction = session.beginTransaction();
			
			String sql = "SELECT id, account,passwd,cname FROM member";
			NativeQuery<Member> query = 
				session.createNativeQuery(sql, Member.class);
			List<Member> list = query.getResultList();
			for (Member member: list) {
				System.out.printf("%d : %s\n", member.getId(), member.getAccount());
			}
			
			transaction.commit();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}
