package com.springboot.util;

import java.math.BigInteger;

import com.springboot.bean.Order;
import com.springboot.bean.Product;
import com.springboot.productservice.wsdl.Orders;
import com.springboot.productservice.wsdl.Products;



public class OrderUtil {

	public static Orders convertToWsdlProduct(Order order) {
		Orders orders = new Orders();
		if (order != null) {
			if (order.getCustomerId() != null)
				orders.setCustomerId(BigInteger.valueOf(order.getCustomerId()));
			if (order.getCustomerPaymentId() != null)
				orders.setCustomerPaymentId(BigInteger.valueOf(order.getCustomerPaymentId()));
			if (order.getId() != null)
				orders.setOrderId(BigInteger.valueOf(order.getId()));
			if (order.getProducts() != null)
				for (Product product : order.getProducts()) {
					orders.getProducts().add(ProductUtil.convertToWsdlProduct(product));
				}
		}
		return orders;
	}
	
	public static Order convertFromWsdlProduct(Orders order) {
		Order orders = new Order();
		if (order != null) {
			if (order.getCustomerId() != null)
				orders.setCustomerId(order.getCustomerId().intValue());
			if (order.getCustomerPaymentId() != null)
				orders.setCustomerPaymentId(order.getCustomerPaymentId().intValue());
			if (order.getOrderId() != null)
				orders.setId(order.getOrderId().intValue());
			if (order.getProducts() != null)
				for (Products product : order.getProducts()) {
					orders.getProducts().add(ProductUtil.convertFromWsdlProduct(product));
				}
		}
		return orders;
	}
}
