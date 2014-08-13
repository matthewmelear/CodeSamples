package com.priceit.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.priceit.entities.Store;

public class StoreMapper implements RowMapper{

	@Override
	public Store mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Store store = new Store();
		store.setName(resultSet.getString("name"));
		return store;
	}

}
