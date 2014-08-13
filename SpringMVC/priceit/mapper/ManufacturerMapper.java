package com.priceit.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.priceit.entities.Manufacturer;

public class ManufacturerMapper implements RowMapper{

	@Override
	public Manufacturer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setName(resultSet.getString("name"));
		return manufacturer;
	}
	
}
