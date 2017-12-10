package trng.imcs.hibernate.assignment4;

import trng.imcs.hibernate.assignment4.util.OperationsUtil;

public class CustomerApp {

	public static void main(String[] args) {

		OperationsUtil operations = new OperationsUtil();
		operations.insertDefaultCustomerDetails();
		//operations.showCustomerOptions();
		operations.displayAllCustomers();

	}
}
