package com.nitesh.rms.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nitesh.rms.bean.AccommodationDTO;

public class AccommodationInfoMapper implements RowMapper<AccommodationDTO> {

	public AccommodationDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		AccommodationDTO dto = new AccommodationDTO();
		dto.setAccommodationId(rs.getInt("ACCOMMODATION_ID"));
		dto.setAccommodationName(rs.getString("ACCOMMODATION_NAME"));
		dto.setStateId(rs.getInt("STATE_ID"));

		return dto;
	}

}
