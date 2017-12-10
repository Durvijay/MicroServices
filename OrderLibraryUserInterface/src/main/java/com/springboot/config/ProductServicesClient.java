package com.springboot.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.springboot.bean.Product;
import com.springboot.productservice.wsdl.GetfilteredProductRequest;
import com.springboot.productservice.wsdl.GetfilteredProductResponse;
import com.springboot.productservice.wsdl.Products;
import com.springboot.util.ProductUtil;


public class ProductServicesClient extends WebServiceGatewaySupport {

	public List<Product> getFilteredProductList(String description) {
		List<Product> list=new ArrayList<>();
		GetfilteredProductRequest request = new GetfilteredProductRequest();
		request.setDescription(description);

		GetfilteredProductResponse response = (GetfilteredProductResponse) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8080/ws",
						request,new SoapActionCallback("http://productservices.com/ProductsServicesOpertions/getFilteredProduct"));
		
		
		for (Products products : response.getProducts()) {
			list.add(ProductUtil.convertFromWsdlProduct(products));
		}

		return list;
	}

}
