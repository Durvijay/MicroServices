package trng.imcs.hibernate.assignment4.util;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import trng.imcs.hibernate.assignment4.bean.Address;
import trng.imcs.hibernate.assignment4.bean.Customer;
import trng.imcs.hibernate.assignment4.bean.Payment;
import trng.imcs.hibernate.assignment4.resources.CustomerServiceImpl;
import trng.imcs.hibernate.assignment4.service.CustomerService;

public class OperationsUtil {
	Scanner s = new Scanner(System.in);

	static CustomerService customerService = new CustomerServiceImpl();
	static final String USER_MESSAGE = "Enter Customer ID :";

	public void showCustomerOptions() {
		while (true) {
			System.out.println("1. Fetch all the PaymentMethods for given customer.");
			System.out.println("2. Fetch Customer along with Address and Payment methods.");
			System.out.println("3. Fetch Customer along with Address but no Payment methods.");
			System.out.println("4. Delete Customer and all associated information.");
			System.out.println("5. Update customer payment methods with new information.");
			System.out.println("6. Delete a Payment method of a customer.");
			System.out.println("7. Exit.");
			int i = 0;
			try {
				i = s.nextInt();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Try valid number");
			}

			switch (i) {
			case 1:
				System.out.println(USER_MESSAGE);
				List<Payment> payment = customerService.findPaymentMehods(s.nextInt());
				System.out.println(payment);
				break;
			case 2:
				System.out.println(USER_MESSAGE);
				Customer customerFullData = customerService.findCustomerFullData(s.nextInt());
				System.out.println(customerFullData);
				break;
			case 3:
				System.out.println(USER_MESSAGE);
				Customer customer = customerService.findCustomer(s.nextInt());
				System.out.println(customer);
				break;
			case 4:
				System.out.println(USER_MESSAGE);
				customerService.deleteCustomer(s.nextInt());
				break;
			case 5:

				Payment paymentMethod = getPaymentDetailsFromUser();
				Payment paymentMethod2 = getPaymentDetailsFromUser();
				Customer customerUpdate = new Customer();
				customerUpdate.getPaymentMethods().add(paymentMethod);
				customerUpdate.getPaymentMethods().add(paymentMethod2);
				paymentMethod.setCustomer(customerUpdate);
				paymentMethod2.setCustomer(customerUpdate);

				customerService.updatePaymentMethod(paymentMethod);
				customerService.updatePaymentMethod(paymentMethod2);
				break;
			case 6:
				System.out.println(USER_MESSAGE);
				customerService.deletePaymentMethods(s.nextInt());
				break;
			case 7:
				HibernateUtils.getSessionFactory().close();
				System.exit(0);
			default:
				System.out.println("Enter Only valid options");
			}
		}
	}

	public void insertDefaultCustomerDetails() {
		Payment paymentMethod2 = new Payment();
		paymentMethod2.setCardNumber("123456789888");
		paymentMethod2.setCardType("MasterCard");
		paymentMethod2.setCardName("Vijay");

		Payment paymentMethod = new Payment();
		paymentMethod.setCardNumber("5555684125223");
		paymentMethod.setCardType("Visa");
		paymentMethod.setCardName("Sammart");

		Customer customer = new Customer();
		customer.setCustomerName("Vijay");
		customer.setAnualSalary(156253);
		customer.setDob(new Date());
		customer.getPaymentMethods().add(paymentMethod2);
		customer.getPaymentMethods().add(paymentMethod);
		paymentMethod.setCustomer(customer);
		paymentMethod2.setCustomer(customer);
		Address address = new Address();
		address.setCity("Dallas");
		address.setState("Texas");
		address.setCountry("USA");
		customer.setAddress(address);
		customerService.updateAddress(address);
		customerService.createCustomer(customer);

		customerService.updatePaymentMethod(paymentMethod);
		customerService.updatePaymentMethod(paymentMethod2);

		System.out.println(customer);

	}

	public Payment getPaymentDetailsFromUser() {
		System.out.println("Enter Card Name: ");
		String cardName = s.next();
		Payment paymentMethod = new Payment();
		paymentMethod.setCardName(cardName);

		System.out.println("Enter Card Number: ");
		String cardNumber = s.next();
		paymentMethod.setCardNumber(cardNumber);

		System.out.println("Enter Card Number: ");
		String cardType = s.next();
		paymentMethod.setCardType(cardType);
		return paymentMethod;
	}

	public void displayAllCustomers() {
		List<Customer> customersList=customerService.getAllCustomers();
		for (Customer customer : customersList) {
			System.out.println("11558---"+customer);
		}
	}
}
