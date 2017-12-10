package com.productservices.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservices.bean.Product;
import com.productservices.repository.ProductRepository;

@Service
public class ProductServiceDao {

	@Autowired
	private ProductRepository productRepositoryDao;

	public void addProduct(Product product) {
		productRepositoryDao.save(product);
	}

	public List<Product> getAllProducts() {
		List<Product> products = (List<Product>) productRepositoryDao.findAll();
		return products;
	}
	
	public List<Product> getFilteredProducts(String productDescription){
		List<Product> products = productRepositoryDao.findByDescriptionContaining(productDescription);
		return products;
	}
}
