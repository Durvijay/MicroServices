package com.productservices.util;

import java.math.BigInteger;

import com.productservices.bean.Product;
import com.productservices.products.Products;

public class ProductUtil {

	public static Products convertToWsdlProduct(Product product) {
		Products products=new Products();
		if (product != null) {
			if (product.getDescription() != null)
				products.setProductDescription(product.getDescription());
			if (product.getId() != null) {
				products.setProductId(BigInteger.valueOf(product.getId()));
			}
			if(product.getName()!=null) {
				products.setProductName(product.getName());
			}
			if(product.getPrices()!=null) {
				products.setPrice(product.getPrices());
			}
			if(product.getTypeCode()!=null) {
				products.setTypeCode(product.getTypeCode());
			}
		}
		return products;
	}
	
	public static Product convertFromWsdlProduct(Products products) {
		Product product=new Product();
		if (products != null) {
			if (products.getProductDescription() != null)
				product.setDescription(products.getProductDescription());
			if (products.getProductId() != null) {
				product.setId(products.getProductId().intValue());
			}
			if(products.getProductName()!=null) {
				product.setName(products.getProductName());
			}
			if(products.getPrice()>0) {
				product.setPrices(products.getPrice());
			}
			if(products.getTypeCode()!=null) {
				product.setTypeCode(products.getTypeCode());
			}
		}
		return product;
	}
	
}
