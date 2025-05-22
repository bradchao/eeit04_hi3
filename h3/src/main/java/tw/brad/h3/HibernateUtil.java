package tw.brad.h3;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import tw.brad.model.Gift;
import tw.brad.model.Member;
import tw.brad.model.MemberInfo;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	//private static StandardServiceRegistry registry;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				Configuration config = new Configuration();
				config.configure("hibernate.cfg.xml");
				
				config.addAnnotatedClass(Member.class);
				config.addAnnotatedClass(MemberInfo.class);
				config.addAnnotatedClass(Gift.class);
				
//				registry = new StandardServiceRegistryBuilder()
//						.applySettings(config.getProperties())
//						.build();
//				sessionFactory = config.buildSessionFactory(registry);
				
				sessionFactory = config.buildSessionFactory();
				
			}catch(Exception e) {
				System.out.println(e);
			}
		}
		return sessionFactory;
	}
}
