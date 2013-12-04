package com.nitesh.rms.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nitesh.rms.bean.CountryInfoDTO;
import com.nitesh.rms.bean.RegistrationDTO;

public class CountryInfoMapper implements RowMapper<CountryInfoDTO> {

	public CountryInfoDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		CountryInfoDTO dto = new CountryInfoDTO();
		
		dto.setCountryName(rs.getString("COUNTRY_NAME"));
		dto.setCountryId(rs.getInt("COUNTRY_ID"));
		dto.setCountryCode(rs.getString("COUNTRY_CODE"));
		
		return dto;
	}

}
