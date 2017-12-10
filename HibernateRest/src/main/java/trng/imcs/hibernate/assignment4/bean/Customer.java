package trng.imcs.hibernate.assignment4.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	@Id
	@Column(name = "customerId")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	private String customerName;
	
	private Date dob;
	
	private Integer anualSalary;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "addressId")
	private Address address;

	@OneToMany(cascade = CascadeType.ALL,mappedBy="customer",fetch = FetchType.LAZY)
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
