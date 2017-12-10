package com.springboot.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class Customer {
	
	private Integer customerId;
	
	private String customerName;
	
	private Date dob;
	
	private Integer anualSalary;

	private Address address;

	private List<Payment> paymentMethod=new ArrayList<Payment>();

	
	public Address getAddress() {
		return address;
	}

	public Address setAddress(Address address) {
		this.address = address;
		return address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getAnualSalary() {
		return anualSalary;
	}

	public void setAnualSalary(Integer anualSalary) {
		this.anualSalary = anualSalary;
	}

	public List<Payment> getPaymentMethods() {
		return paymentMethod;
	}

	public void setPaymentMethod(List<Payment> paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", dob=" + dob
				+ ", anualSalary=" + anualSalary + ", address=" + address + "]";
	}

	

}
