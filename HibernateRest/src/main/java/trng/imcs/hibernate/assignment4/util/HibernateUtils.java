package trng.imcs.hibernate.assignment4.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	private HibernateUtils() {
	}


	private static final SessionFactory sessionFactory = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
		try {
	            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	            return configuration.buildSessionFactory();
	            
		} catch (Exception ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

}
