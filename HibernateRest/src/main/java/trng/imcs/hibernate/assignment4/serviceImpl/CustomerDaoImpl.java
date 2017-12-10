package trng.imcs.hibernate.assignment4.serviceImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import trng.imcs.hibernate.assignment4.bean.Customer;
import trng.imcs.hibernate.assignment4.service.CustomerDao;
import trng.imcs.hibernate.assignment4.util.HibernateUtils;

public class CustomerDaoImpl  implements CustomerDao{
	SessionFactory sessionFactory = null;

	private CustomerDao customerDAO;
	public Customer saveCustomer(Customer customer) {
		return customerDAO.saveCustomer(customer);
	}
	
	public Customer saveCustomer1(Customer customer) {
		if (sessionFactory == null)
			sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(customer);
		session.getTransaction().commit();
		session.close();
		return customer;
	}

	public Customer findCustomer(Integer custId) {
		if (sessionFactory == null)
			sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Customer customer = session.get(Customer.class, custId);
		customer.getAddress();
		session.close();
		return customer;
	}

	public Customer findCustomerFullData(Integer custId) {
		if (sessionFactory == null)
			sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Customer customer = session.get(Customer.class, custId);
		customer.getAddress();
		customer.getPaymentMethods().size();
		session.close();
		return customer;
	}

	public Customer deleteCustomer(Integer custId) {
		if (sessionFactory == null)
			sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Customer customer;
		if ((customer = session.get(Customer.class, custId)) != null) {
			session.delete(customer);
			session.getTransaction().commit();
		}
		
		session.close();
		return null;

	}

	public Customer updateCustomer(Customer customer) {
		if (sessionFactory == null)
			sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.update(customer);
		session.close();
		return customer;
	}

	public List<Customer> getAllCustomers() {
		if (sessionFactory == null)
			sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("FROM Customer");
		List<Customer> result = query.list();
		session.close();
		return result;
	}


}
