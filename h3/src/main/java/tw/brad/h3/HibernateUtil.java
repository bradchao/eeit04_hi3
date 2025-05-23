package tw.brad.h3;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import tw.brad.model.Course;
import tw.brad.model.Cust;
import tw.brad.model.Gift;
import tw.brad.model.Member;
import tw.brad.model.MemberInfo;
import tw.brad.model.Order;
import tw.brad.model.Student;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration config = new Configuration();
				config.configure("hibernate.cfg.xml");
				
				config.addAnnotatedClass(Member.class);
				config.addAnnotatedClass(MemberInfo.class);
				config.addAnnotatedClass(Gift.class);
				config.addAnnotatedClass(Cust.class);
				config.addAnnotatedClass(Order.class);
				config.addAnnotatedClass(Student.class);
				config.addAnnotatedClass(Course.class);
				
				sessionFactory = config.buildSessionFactory();
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		return sessionFactory;
	}
}
