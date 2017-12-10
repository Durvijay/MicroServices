package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/payment")
public class PaymentController {

	@RequestMapping(value="/DeletePayment", method = RequestMethod.GET)
	public String DeletePayment() {
		return "DeletePayment";
	}
	
	@RequestMapping(value="/GetPayment", method = RequestMethod.GET)
	public String GetPayment() {
		return "GetPayment";
	}
}
