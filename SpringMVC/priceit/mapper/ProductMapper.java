package com.priceit.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import com.priceit.entities.Product;

//@Component
//public class ProductMapper implements RowMapper<Product>{
//
//	@Override
//	public Product mapRow(ResultSet rs, int rowNum)throws SQLException {
//		Product product = new Product();
//System.out.println("in mapper ");
//		product.setId(rs.getLong("id")); //column name  result set 
//		product.setName(rs.getString("name"));  
//		product.setDescription(rs.getString("description"));
//		product.setUpc(rs.getString("upc"));//getString
//		product.setImage(rs.getString("image"));
//		product.setManufacturer(rs.getString("manufacturer_name"));
//		product.setCategory(rs.getString("category"));
//		return product;
//	}
//}

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.priceit.entities.Product;



@Component
public class ProductMapper implements RowMapper<Product>{


	private Product product;

	
	@Override
	public Product mapRow(ResultSet rs, int rowNum)throws SQLException{
		product = new Product();
		product.setId(rs.getLong("id"));
		product.setName(rs.getString("name"));
		product.setDescription(rs.getString("description"));
		product.setUpc(rs.getString("upc"));
		product.setCategory(rs.getString("category"));
		product.setImage(rs.getString("image"));
		product.setManufacturer(rs.getString("manufacturer_name"));
		product.setCategory(rs.getString("category"));
	
		return product;
	}

	/*
	 * setters for setter injection
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}



