package com.productservices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productservices.bean.Product;
import com.productservices.dao.OrderServiceDao;
import com.productservices.dao.ProductServiceDao;

@SpringBootApplication
//@EnableJpaRepositories(basePackages= {"com.productservices.util"})
public class ProductsServicesApplication implements CommandLineRunner {

	@Autowired
	OrderServiceDao orderService;
	@Autowired
	ProductServiceDao productServiceDao;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ProductsServicesApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
    	/*Product product=new Product("Cooker", "HomeWare", "Homeware Cooker",45.89);
    	Product product1=new Product("Shampoo", "Beauty", "Head N Shoulder Shampoo ",6.09);
    	Product product2=new Product("Wild Life", "Books", "Wild Life book by author vijay",89.74);
    	Product product3=new Product("Fan", "Utilities", "Usha fan faster than anyone",30.54);
    	Product product4=new Product("Dettol Soap", "Beauty", "Dettol Soap",5.89);
    	Product product5=new Product("LUX Soap", "Beauty", "LUX Soap",5.89);
    	Product product6=new Product("VIM Soap", "Beauty", "VIM Soap",5.89);
    	Product product7=new Product("Pears Soap", "Beauty", "Pears Soap",5.89);
    	productServiceDao.addProduct(product);
    	productServiceDao.addProduct(product1);
    	productServiceDao.addProduct(product2);
    	productServiceDao.addProduct(product3);
    	productServiceDao.addProduct(product4);
    	productServiceDao.addProduct(product5);
    	productServiceDao.addProduct(product6);
    	productServiceDao.addProduct(product7);*/
    	
    	List<Product> list=productServiceDao.getFilteredProducts("soap");
    	printListOFPRoducts(list);
    	System.out.println("----------------------------Another Query--------------------------------------");
    	List<Product> list2=productServiceDao.getAllProducts();
    	printListOFPRoducts(list2);
    	
    }
    
    
    private void printListOFPRoducts(List<Product> list) {
    	for (Product product5 : list) {
			System.out.println(product5);
		}

	}

}