package com.nitesh.rms.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nitesh.rms.bean.RegistrationDTO;
import com.nitesh.rms.bean.StateInfoDTO;

public class StateInfoMapper implements RowMapper<StateInfoDTO> {

	/**
	 * @param args
	 */
	public StateInfoDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		StateInfoDTO dto = new StateInfoDTO();
		
		dto.setCountryId(rs.getInt("COUNTRY_ID"));
		dto.setStateCode(rs.getString("STATE_CODE"));
		dto.setStateId(rs.getInt("STATE_ID"));
		dto.setStateName(rs.getString("STATE_NAME"));
		
		
		
		return dto;
	}

}
