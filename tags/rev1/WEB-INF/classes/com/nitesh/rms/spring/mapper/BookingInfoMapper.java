package com.nitesh.rms.spring.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.nitesh.rms.bean.AccommodationDTO;
import com.nitesh.rms.bean.BookingDTO;

public class BookingInfoMapper implements RowMapper<BookingDTO>{

	@Override
	public BookingDTO mapRow(ResultSet rs, int arg1) throws SQLException {
		BookingDTO dto = new BookingDTO();
		dto.setUnitType(rs.getString("UNIT_TYPE"));
		dto.setAccommodationName(rs.getString("ACCOMMODATION_NAME"));
		dto.setBookingDate(rs.getDate("BOOING_DATE"));
		dto.setCheckInDate(rs.getDate("CHECKIN_DATE"));
		dto.setCheckOutDate(rs.getDate("CHECKOUT_DATE"));

		return dto;
	}

}
