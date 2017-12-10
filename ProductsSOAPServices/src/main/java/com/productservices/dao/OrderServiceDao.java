package com.productservices.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productservices.bean.Order;
import com.productservices.repository.OrderRepository;

@Service
public class OrderServiceDao {
	
	@Autowired
	private OrderRepository orderDao;

	public void createOrder(Order order) {
		orderDao.save(order);
	}
}
