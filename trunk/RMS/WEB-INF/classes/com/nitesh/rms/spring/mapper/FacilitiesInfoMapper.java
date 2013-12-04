package com.nitesh.rms.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FacilitiesInfoMapper implements RowMapper<String> {

	@Override
	public String mapRow(ResultSet arg0, int arg1) throws SQLException {
		
		
		
		return arg0.getString("FACILITIES_TYPE");
	}

}
