package com.productservices.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.productservices.bean.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	List<Product> findByDescriptionContaining(String description);
	
	List<Product> findAll();
	
}
