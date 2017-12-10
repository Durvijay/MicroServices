package trng.imcs.hibernate.assignment4.serviceImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import trng.imcs.hibernate.assignment4.bean.Address;
import trng.imcs.hibernate.assignment4.service.AddressDao;
import trng.imcs.hibernate.assignment4.util.HibernateUtils;

public class AddressDaoImpl implements AddressDao {
	SessionFactory sessionFactory = null;

	public Address updateAddress(Address address) {
		if (sessionFactory == null)
			sessionFactory = HibernateUtils.getSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.saveOrUpdate(address);
		session.getTransaction().commit();
		session.close();
		return address;
	}

	public int deleteAddress(Long custId) {
		Session session=null;
		try{
			if (sessionFactory == null)
				sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();

			Address customer = session.load(Address.class, custId);
			session.delete(customer);
			session.close();
			return 1;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session!=null){
				session.close();
			}
		}
		
		return 0;
	}

}
