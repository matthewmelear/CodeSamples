package com.priceit.dao;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.priceit.entities.Pricepoint;
//import com.priceit.mappers.KeyHolderFactory;
import com.priceit.mapper.PricepointMapper;
import com.priceit.utilities.Response;

@Component
public class PricepointDao {

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	/*@Autowired
	private KeyHolderFactory key;
	*/
	
	//@Autowired   beans now
	
	private PricepointMapper pricepointMapper; 
	private Response response;
	private Pricepoint pricepoint;
	

	public List<Pricepoint> getPricePoint(long id){	
		List<Pricepoint> viewPricepoints = new ArrayList<Pricepoint>();
		MapSqlParameterSource arguments = new MapSqlParameterSource();
		arguments.addValue("id", id);
		viewPricepoints = namedJdbcTemplate.query(Pricepoint.GET_PRICEPOINTS,arguments, pricepointMapper);
		return viewPricepoints;

	}
	public void setResponse(Response response) {
		this.response = response;
	}
	public void setPricepoint(Pricepoint pricepoint) {
		this.pricepoint = pricepoint;
	}
	public void setPricepointMapper(PricepointMapper testMapper) {
		this.pricepointMapper = testMapper;
	}

}

