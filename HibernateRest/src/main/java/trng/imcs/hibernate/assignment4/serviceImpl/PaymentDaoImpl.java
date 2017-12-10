package trng.imcs.hibernate.assignment4.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import trng.imcs.hibernate.assignment4.bean.Payment;
import trng.imcs.hibernate.assignment4.service.PaymentDao;
import trng.imcs.hibernate.assignment4.util.HibernateUtils;

public class PaymentDaoImpl implements PaymentDao {
	SessionFactory sessionFactory = null;

	public List<Payment> findPaymentMehods(Integer custId) {
		if (sessionFactory == null)
			sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Payment where customerId=:custId");
		query.setParameter("custId", custId);
		List<Payment> payment = query.list();
		session.close();
		return payment;
	}

	public int deletePaymentMethods(Integer custId) {
		
			if (sessionFactory == null)
				sessionFactory = HibernateUtils.getSessionFactory();
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.createQuery("Delete FROM Payment where customerId =:custId");
			int x = query.executeUpdate();
			session.getTransaction().commit();
			session.close();
			return x;
		
	}

	public Payment updatePaymentMethod(Payment paymentMethod) {
		if (sessionFactory == null)
			sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(paymentMethod);
		session.getTransaction().commit();
		session.close();
		return paymentMethod;
	}
	
	public Payment newPaymentMethod(Payment paymentMethod) {
		if (sessionFactory == null)
			sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(paymentMethod);
		session.getTransaction().commit();
		session.close();
		return paymentMethod;
	}

}
