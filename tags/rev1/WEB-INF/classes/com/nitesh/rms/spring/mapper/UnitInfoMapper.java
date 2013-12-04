package com.nitesh.rms.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nitesh.rms.bean.UnitsDTO;

public class UnitInfoMapper implements RowMapper<UnitsDTO> {

	public UnitsDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		UnitsDTO dto = new UnitsDTO();

		dto.setAvailableUnits(rs.getInt("AVAILABLE_UNITS"));
		dto.setTotalUnits(rs.getInt("TOTAL_UNITS"));
		dto.setUnitId(rs.getInt("UNIT_ID"));
		dto.setUnitType(rs.getString("UNIT_TYPE"));

		return dto;
	}
}
