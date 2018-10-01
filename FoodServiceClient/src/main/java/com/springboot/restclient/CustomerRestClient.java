package com.springboot.restclient;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.springboot.bean.Customer;
import com.springboot.bean.Payment;


public class CustomerRestClient {
	static String URL = "http://localhost:8080/HibernateRest/webapi/orderLibrary/";

	public Customer createRestRequestWithCustomer(Customer customer,String urlappend,HttpMethod requestType) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Customer> entity = new HttpEntity<Customer>(customer);
		ResponseEntity<Customer> responseEntity = restTemplate.exchange(URL+urlappend, requestType, entity, Customer.class);
		if (responseEntity.getStatusCode() == HttpStatus.ACCEPTED) {
			return responseEntity.getBody();
		} else {
			return null;
		}
	}
	
	public List<Customer> getRestRequestCustomers(String urlappend,HttpMethod requestType) {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<List<Customer>> responseEntity = restTemplate.exchange(URL+urlappend, requestType, null, new ParameterizedTypeReference<List<Customer>>() {});
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			return responseEntity.getBody();
		} else {
			return null;
		}
	}
	
	public List<Payment> getRestRequestPaymentWithId(Integer id,String urlappend,HttpMethod requestType) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Integer> entity = new HttpEntity<Integer>(id);
		ResponseEntity<List<Payment>> responseEntity = restTemplate.exchange(URL+urlappend, requestType, entity, new ParameterizedTypeReference<List<Payment>>() {});
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			return responseEntity.getBody();
		} else {
			return null;
		}
	}
	
	public Customer createRestRequestWithCustomerId(Integer id,String urlappend,HttpMethod requestType) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Integer> entity = new HttpEntity<Integer>(id);
		ResponseEntity<Customer> responseEntity = restTemplate.exchange(URL+urlappend, requestType, entity, Customer.class);
		if (responseEntity.getStatusCode() == HttpStatus.OK) {
			return responseEntity.getBody();
		} else {
			return null;
		}
	}
	
	public Payment createRestRequestPayment(Payment payment,String urlappend,HttpMethod requestType) {
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Payment> entity = new HttpEntity<Payment>(payment);
		ResponseEntity<Payment> responseEntity = restTemplate.exchange(URL+urlappend, requestType, entity, Payment.class);
		if (responseEntity.getStatusCode() == HttpStatus.ACCEPTED) {
			return responseEntity.getBody();
		} else {
			return null;
		}
	}
}
