package com.priceit.entities;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.sql.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Component;

@Component
public class Product {


//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", upc= " + upc + " name=" + name + ",description=" + description +",category=" + category + ",manufacturer_name =" + manufacturer_name + "]";
//		
//		
//	}

	private long id;
	private String name;
	private String description;
	private String upc;
	private String category;
	private String manufacturer_name;
	private String image;
	private String manufacturer;
	
	public static final String CREATE_PRODUCT = "INSERT INTO product (name, description, upc, category, image, manufacturer_name) VALUES (:name, :description, :upc, :category, :image, :manufacturerName)";
	public static final String GET_PRODUCT_BY_NAME = "SELECT * FROM product WHERE name = :name";
	public static final String GET_PRODUCT_BY_UPC = "SELECT * FROM product WHERE upc = :upc";
	public static final String GET_PRODUCT = "SELECT * FROM product WHERE name = :name";
	public static final String GET_PRODUCT_BY_ID = "SELECT * FROM product WHERE id = :id";
	public static final String GET_FUZZY_MATCH = "SELECT * FROM product WHERE lower(name) LIKE :name Limit 10";

	
	public Product(){	
	}
	
	public Product(String name, String description, String upc, String category, String image, String manufacturer_name){
		this.name = name;
		this.description = description;
		this.upc = upc;
		this.category = category;
		this.image = image;
		this.manufacturer = manufacturer_name;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {


		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getManufacturer() {

		return manufacturer_name;
	}
//	public void setManufacturer(String manufacturer) {
//		this.manufacturer_name = manufacturer;
//	}
//
//	}
//		return manufacturer;
//	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}


	public String getManufacturer_name() {
		return manufacturer;
	}

	public void setManufacturer_name(String manufacturer_name) {
		this.manufacturer = manufacturer_name;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", image="
				+ image + ", upc=" + upc + ", manufacturer="+ manufacturer + "]";
	}
}

