package com.nitesh.rms.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nitesh.rms.bean.RegistrationDTO;

public class UserInfoMapper implements RowMapper<RegistrationDTO>{

	public RegistrationDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		RegistrationDTO dto = new RegistrationDTO();
		dto.setAddress(rs.getString("ADDRESS"));
		dto.setEmail(rs.getString("EMAIL_ID"));
		dto.setFirstname(rs.getString("USER_NAME").split(" ")[0]);
		dto.setLastname(rs.getString("USER_NAME").split(" ")[1]);
		dto.setPassword(rs.getString("PASSWORD"));
		dto.setPhonenumber(rs.getString("PHONE"));
		
		return dto;
	}

}
