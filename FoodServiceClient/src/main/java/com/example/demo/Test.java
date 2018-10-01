package com.example.demo;

import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;

import com.springboot.bean.Product;
import com.springboot.config.ProductServicesClient;
import com.springboot.controller.CustomerControler;

public class Test {
	static CustomerControler controler = new CustomerControler();

	public static void main(String[] args) {
		/*//controler.deleteCustomerDetailById(170);
		controler.getAllCustomerDetails();
		controler.getPaymentsOfCustomer(38);
		controler.findCustomerResult(38);
		Customer customer=new Customer();
		customer.setCustomerName("Surya bhai");
		controler.registerCustomer(customer);*/
		System.out.println("sf");
		ProductServicesClient client=new ProductServicesClient();
		List<Product> list=client.getFilteredProductList("soap");
		print(list);
		
	}

	

	private static void print(List<Product> list) {
		for (Product product : list) {
			System.out.println(product);
		}
		
	}

	

}
