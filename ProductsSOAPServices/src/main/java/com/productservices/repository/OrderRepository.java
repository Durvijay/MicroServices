package com.productservices.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.productservices.bean.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order,Long>{

	public Order findById(Integer id);
	
	<S extends Order> S save(S entity);
}
