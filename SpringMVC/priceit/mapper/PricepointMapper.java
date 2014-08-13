package com.priceit.mapper;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.priceit.entities.Pricepoint;

	@Component
	public class PricepointMapper implements RowMapper<Pricepoint> {
		
		
		private Pricepoint pricepoint;  //bean
		
		@Override
		public Pricepoint mapRow(ResultSet rs, int rowNum) throws SQLException{
			Pricepoint pricepoint = new Pricepoint();
			pricepoint.setPricepointId(rs.getInt("id"));
			pricepoint.setPrice(rs.getBigDecimal("price")); //column name  result set
			pricepoint.setDate(rs.getDate("date"));
			pricepoint.setStatus_name(rs.getString("status_name"));
			pricepoint.setSale_end_date(rs.getDate("sale_end_date")); 
			pricepoint.setProduct_name(rs.getString("product_name"));
			pricepoint.setStore(rs.getString("store"));
			pricepoint.setProductId(rs.getInt("productId"));

			return pricepoint;
		}

		public void setPricepoint(Pricepoint pricepoint) {
			this.pricepoint = pricepoint;
		}
		
	}

