package com.productservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.productservices.bean.Product;
import com.productservices.dao.ProductServiceDao;
import com.productservices.productsservicesopertions.GetAllProductsRequest;
import com.productservices.productsservicesopertions.GetAllProductsResponse;
import com.productservices.productsservicesopertions.GetfilteredProductRequest;
import com.productservices.productsservicesopertions.GetfilteredProductResponse;
import com.productservices.util.ProductUtil;

@Endpoint
public class ProductService {

	private static final String NAMESPACE_URI = "http://productservices.com/ProductsServicesOpertions";

	@Autowired
	private ProductServiceDao productServiceDao;


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllProducts")
	@ResponsePayload
	public GetAllProductsResponse getAllProducts(@RequestPayload GetAllProductsRequest request) {
		
		GetAllProductsResponse allProductsResponse =new GetAllProductsResponse();
		List<Product> list=productServiceDao.getAllProducts();
		for (Product product : list) {
			allProductsResponse.getProducts().add(ProductUtil.convertToWsdlProduct(product));
		}
		return allProductsResponse;
	}
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getFilteredProduct")
	@ResponsePayload
	public GetfilteredProductResponse getFilteredProduct(@RequestPayload GetfilteredProductRequest request) {
		
		GetfilteredProductResponse allProductsResponse =new GetfilteredProductResponse();
		List<Product> list=productServiceDao.getFilteredProducts(request.getDescription());
		for (Product product : list) {
			allProductsResponse.getProducts().add(ProductUtil.convertToWsdlProduct(product));
		}
		return allProductsResponse;
	}
}
