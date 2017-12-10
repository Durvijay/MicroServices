package trng.imcs.hibernate.assignment4.service;

import java.util.List;

import trng.imcs.hibernate.assignment4.bean.Address;
import trng.imcs.hibernate.assignment4.bean.Customer;
import trng.imcs.hibernate.assignment4.bean.Payment;

public interface CustomerService {
	void updateAddress(Address address);
	void updateCustomer(Customer customer);
	Customer deleteCustomer(Integer custId);
	int deletePaymentMethods(Integer custId);
	
	Payment updatePaymentMethod(Payment paymentMethod);
	List<Payment> findPaymentMehods(Integer custId);
	Customer createCustomer(Customer customer);
	Customer findCustomerFullData(Integer custId);
	Customer findCustomer(Integer custId);
	List<Customer> getAllCustomers();
}
