package com.springboot.bean;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
	
	private Integer id;
	private String name;
	private String typeCode;
	private String description;
	private Double prices;
	
	public Product(String name, String typeCode, String description,Double prices) {
		super();
		this.name = name;
		this.typeCode = typeCode;
		this.description = description;
		this.prices = prices;
	}


	public Product() {
		super();
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", typeCode=" + typeCode + ", description=" + description
				+ ", prices=" + prices + "]";
	}
	
}
