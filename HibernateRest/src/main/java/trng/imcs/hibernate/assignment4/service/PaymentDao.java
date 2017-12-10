package trng.imcs.hibernate.assignment4.service;

import java.util.List;

import trng.imcs.hibernate.assignment4.bean.Payment;

public interface PaymentDao {
	List<Payment> findPaymentMehods(Integer custId);
	int deletePaymentMethods(Integer custId);
	Payment updatePaymentMethod(Payment paymentMethod);
	Payment newPaymentMethod(Payment paymentMethod);
}
