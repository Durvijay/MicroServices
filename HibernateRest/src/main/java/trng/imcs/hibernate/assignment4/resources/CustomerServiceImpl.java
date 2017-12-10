package trng.imcs.hibernate.assignment4.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import trng.imcs.hibernate.assignment4.bean.Address;
import trng.imcs.hibernate.assignment4.bean.Customer;
import trng.imcs.hibernate.assignment4.bean.Payment;
import trng.imcs.hibernate.assignment4.service.AddressDao;
import trng.imcs.hibernate.assignment4.service.CustomerDao;
import trng.imcs.hibernate.assignment4.service.CustomerService;
import trng.imcs.hibernate.assignment4.service.PaymentDao;
import trng.imcs.hibernate.assignment4.serviceImpl.AddressDaoImpl;
import trng.imcs.hibernate.assignment4.serviceImpl.CustomerDaoImpl;
import trng.imcs.hibernate.assignment4.serviceImpl.PaymentDaoImpl;

@Path("orderLibrary")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CustomerServiceImpl implements CustomerService {
	CustomerDao customerDaoImpl = new CustomerDaoImpl();
	AddressDao addressDaoImpl = new AddressDaoImpl();
	PaymentDao paymentDaoImpl = new PaymentDaoImpl();

	@GET
    public String getIt() {
        return "Got it!";
    }
	public void updateAddress(Address address) {
		addressDaoImpl.updateAddress(address);
	}

	public void updateCustomer(Customer customer) {
		customerDaoImpl.updateCustomer(customer);

	}
	@DELETE
	@Path("/customers/{custId}")
	public Customer deleteCustomer(@PathParam("custId") Integer custId) {
		return customerDaoImpl.deleteCustomer(custId);

	}
	@DELETE
	@Path("/{custId}/Payments")
	public int deletePaymentMethods(@PathParam("custId") Integer custId) {
		return paymentDaoImpl.deletePaymentMethods(custId);
	}
	
	@PUT
	@Path("/customer")
	public Customer createCustomer(Customer customer) {
		return customerDaoImpl.saveCustomer(customer);
	}

	@POST
	@Path("/payment")
	public Payment updatePaymentMethod(Payment paymentMethod) {
		return paymentDaoImpl.updatePaymentMethod(paymentMethod);
	}

	@PUT
	@Path("/payment")
	public Payment newPaymentMethod(Payment paymentMethod) {
		return paymentDaoImpl.newPaymentMethod(paymentMethod);
	}
	
	@GET
	@Path("/customer/{custId}")
	public Customer findCustomerFullData(@PathParam("custId") Integer custId) {
		return customerDaoImpl.findCustomerFullData(custId);
	}
	@GET
	@Path("/customers/{custId}")
	public Customer findCustomer(@PathParam("custId") Integer custId) {
		return customerDaoImpl.findCustomer(custId);
	}

	@GET
	@Path("/customers/{custId}/payments")
	public List<Payment> findPaymentMehods(@PathParam("custId") Integer custId) {
		return paymentDaoImpl.findPaymentMehods(custId);
	}

	@GET
	@Path("/customers")
	public List<Customer> getAllCustomers() {
		return customerDaoImpl.getAllCustomers();
	}

}
