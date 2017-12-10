package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrderLibraryUserInterfaceApplication {

	public static void main(String[] args) {
		//new OperationsUtil().insertDefaultCustomerDetails();
		SpringApplication.run(OrderLibraryUserInterfaceApplication.class, args);
	}
}
