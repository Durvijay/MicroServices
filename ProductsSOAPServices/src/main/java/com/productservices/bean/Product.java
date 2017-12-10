package com.productservices.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
