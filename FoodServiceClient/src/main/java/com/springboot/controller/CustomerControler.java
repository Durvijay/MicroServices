package com.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springboot.bean.Customer;
import com.springboot.bean.Payment;
import com.springboot.bean.Product;
import com.springboot.config.ProductServicesClient;
import com.springboot.restclient.CustomerRestClient;
import com.springboot.validator.PaymentValidator;

@Controller
@RequestMapping(value="/customer")
public class CustomerControler {
	
	CustomerRestClient restClient=new CustomerRestClient();
	ProductServicesClient soapClient=new ProductServicesClient();
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public String registrationPage() {
		return "registration";
	}
	
	@RequestMapping(value="/DeleteCustomer", method = RequestMethod.GET)
	public String DeleteCustomer() {
		return "DeleteCustomer";
	}
	
	@RequestMapping(value="/GetPaymentView", method = RequestMethod.GET)
	public String getPaymentView() {
		return "PayementDetailsView";
	}
	
	@RequestMapping(value="/DeleteCustomerById", method = RequestMethod.GET)
	public ModelAndView deleteCustomerDetailById(@RequestParam Integer custId) {
		Customer customer=restClient.createRestRequestWithCustomerId(custId, "customers/"+custId, HttpMethod.DELETE);
		ModelAndView modelAndView=new ModelAndView("DeleteCustomer");
		if(customer==null)
			modelAndView.addObject("DeletedCustomer","Customer Deleted Successfully");
		else
			modelAndView.addObject("DeletedCustomer","Something went wrong on deletion");
		return modelAndView;
	}
	@RequestMapping(value="/displayAllCustomers", method = RequestMethod.GET)
	public ModelAndView getAllCustomerDetails() {
		List<Customer> customersList = restClient.getRestRequestCustomers("customers", HttpMethod.GET);
		for (Customer customer : customersList) {
			System.out.println(customer);
		}
		ModelAndView modelAndView=new ModelAndView("displayAllCustomers");
		modelAndView.addObject("customers",customersList);
		System.out.println(customersList.size());
		return modelAndView;
	}
	
	@RequestMapping(value="/findPaymentsDetails", method = RequestMethod.GET)
	public ModelAndView getPaymentsOfCustomer(@RequestParam Integer custId) {
		List<Payment> paymentList = restClient.getRestRequestPaymentWithId(custId,"customers/"+custId+"/payments", HttpMethod.GET);
		for (Payment payment : paymentList) {
			System.out.println(payment);
		}
		ModelAndView modelAndView=new ModelAndView("PayementDetailsView");
		modelAndView.addObject("payments",paymentList);
		return modelAndView;
	}
	
	@RequestMapping(value="/UpdateCustomer", method = RequestMethod.GET)
	public String UpdateCustomer() {
		return "UpdateCustomer";
	}
	
	@RequestMapping(value="/findCustomerView", method = RequestMethod.GET)
	public String displayCustomerFindPage() {
		return "findCustomerDetails";
	}
	@RequestMapping(value="/findCustomerDetails", method = RequestMethod.GET)
	public ModelAndView findCustomerResult(@RequestParam Integer custId) {
		Customer c = restClient.createRestRequestWithCustomerId(custId,"customer/"+custId, HttpMethod.GET);
		List<Customer> customer=new ArrayList();
		customer.add(c);
		ModelAndView modelAndView=new ModelAndView("findCustomerDetails");
		modelAndView.addObject("customers",customer);
		System.out.println(c);
		return modelAndView;
	}
	
	@RequestMapping(value="/displayCreateCustomer", method = RequestMethod.GET)
	public ModelAndView displayCreateCustomer() {
		ModelAndView modelAndView=new ModelAndView("registration");
		modelAndView.addObject("NewCustomer",new Customer());
		return modelAndView;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public ModelAndView registerCustomer(@ModelAttribute(value="NewCustomer") com.springboot.bean.Customer customer) {
		System.out.println(customer);
		customer = restClient.createRestRequestWithCustomer(customer, "customer", HttpMethod.PUT);
		List<com.springboot.bean.Customer> customerList=new ArrayList();
		customerList.add(customer);
		ModelAndView modelAndView=new ModelAndView("registration");
		modelAndView.addObject("message", "Customer Data Inserted Successfully");
		modelAndView.addObject("customers",customerList);
		return modelAndView;
	}
	@InitBinder("payment")
    public void initPaymentBinder(WebDataBinder dataBinder) {
        dataBinder.setValidator(new PaymentValidator());
    }
	@RequestMapping(value="/BuyProducts", method=RequestMethod.GET)
	public ModelAndView displayBuyProductsPage(){
		ModelAndView modelAndView=new ModelAndView("BuyProducts");
		List<Customer> customerList=restClient.getRestRequestCustomers("customers", HttpMethod.GET);
		modelAndView.addObject("customers",customerList);
		return modelAndView;
	}
	
	@RequestMapping(value="/BuyProducts", method=RequestMethod.GET)
	public ModelAndView getAllProducts(String description){
		ModelAndView modelAndView=new ModelAndView("BuyProducts");
		List<Product> productList=soapClient.getFilteredProductList(description);
		modelAndView.addObject("filteredproducts",productList);
		return modelAndView;
	}
	@RequestMapping(value="/AddPayment", method = RequestMethod.GET)
	public ModelAndView displayAddPayement() {
		ModelAndView modelAndView=new ModelAndView("AddPayment");
		modelAndView.addObject("payment",new Payment());
		return modelAndView;
	}
	
	@RequestMapping(value="/addPaymentMethod", method = RequestMethod.GET)
	public ModelAndView addPaymentMethod(@Valid @ModelAttribute Payment payment, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
            model.put("payment", payment);
            return new ModelAndView("AddPayment");
        } else {
			payment = restClient.createRestRequestPayment(payment,"",HttpMethod.PUT);
			ModelAndView modelAndView=new ModelAndView("AddPayment");
			modelAndView.addObject("message","Added Scuccessfuly");
			return modelAndView;
        }
	}

}
