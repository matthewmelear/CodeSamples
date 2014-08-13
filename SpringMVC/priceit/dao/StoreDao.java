package com.priceit.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.priceit.entities.Store;
import com.priceit.mapper.StoreMapper;

@Component
public class StoreDao {

	@Autowired
	NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public void insertStore(Store store){
		String sql = "INSERT INTO store (name, street, city, state, zip) VALUES (:name, :street, :city, :state, :zip)";
		SqlParameterSource parameterNames = new MapSqlParameterSource("name", store.getName()).addValue("street", store.getStreet())
															.addValue("city", store.getCity()).addValue("state", store.getState())
															.addValue("zip", store.getZip());
		namedJdbcTemplate.update(sql, parameterNames);
	}

	public void updateStore(Store store) {
		String sql = "UPDATE store SET name = :name, street = :street, city = :city, state = :state, zip = :zip WHERE id = :id";
		SqlParameterSource parameterNames = new MapSqlParameterSource("name", store.getName()).addValue("street", store.getStreet())
															.addValue("city", store.getCity()).addValue("state", store.getState())
															.addValue("zip", store.getZip()).addValue("id", store.getId());
		namedJdbcTemplate.update(sql, parameterNames);
	}
	
	public void deleteStore(int id) {
		String sql = "DELETE from store WHERE id = :id";
		SqlParameterSource parameterNames = new MapSqlParameterSource("id", id);
		namedJdbcTemplate.update(sql, parameterNames);
	}
	
	public List<Store> getAllStores(){
		String sql = "SELECT * FROM store";
		return (List<Store>) namedJdbcTemplate.query(sql, new StoreMapper());
	}

	public Store getStoreById(int newId) {
		String sql = "SELECT * FROM store where id = :id";
		SqlParameterSource parameterNames = new MapSqlParameterSource("id", newId);
		return namedJdbcTemplate.queryForObject(sql, parameterNames, new StoreMapper());
	}
}
