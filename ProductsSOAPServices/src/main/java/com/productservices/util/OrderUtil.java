package com.productservices.util;

import java.math.BigInteger;

import com.productservices.bean.Order;
import com.productservices.bean.Product;
import com.productservices.products.Orders;
import com.productservices.products.Products;

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
