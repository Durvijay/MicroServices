package com.springboot.validator;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.springboot.bean.Payment;

public class PaymentValidator implements Validator {

	private static final String REQUIRED = "required";

	@Override
	public void validate(Object obj, Errors errors) {
		Payment payment = (Payment) obj;

		if (!StringUtils.isAlpha(payment.getCardName())) {
			errors.rejectValue("cardName", REQUIRED, REQUIRED);
		}

		if (!StringUtils.isAlpha(payment.getCardType())) {
			errors.rejectValue("cardType", REQUIRED, REQUIRED);
		}
		if (!StringUtils.isNumeric(payment.getCardNumber())) {
			errors.rejectValue("cardNumber", REQUIRED, "CARD NO SHOULD BE NUMERIC");
		}
		if (payment.getCardNumber().length() != 16) {
			errors.rejectValue("cardNumber", REQUIRED, "CARD NO SHOULD BE 16 DIGITS");
		}

		if (!(null!=payment.getCustomer().getCustomerId() && payment.getCustomer().getCustomerId()>0)) {
			errors.rejectValue("customer.customerId", REQUIRED, REQUIRED);
		}

	}

	@Override
	public boolean supports(Class<?> arg0) {
		return Payment.class.isAssignableFrom(arg0);
	}

}
