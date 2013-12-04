package com.nitesh.rms.booking.dao;

import java.sql.Types;
import java.util.Date;
import java.util.List;

import com.nitesh.rms.bean.BookingDTO;
import com.nitesh.rms.spring.mapper.BookingInfoMapper;
import com.nitesh.rms.util.DBUtil;

public class BookingDAOImpl implements BookingDAO {

	private DBUtil dbUtil;

	public DBUtil getDbUtil() {
		return dbUtil;
	}

	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Override
	public BookingDTO bookAccommodation(BookingDTO bdto) {
		// TODO Auto-generated method stub
		
		try{
			
			StringBuilder sb1= new StringBuilder();
			sb1.append("update units_per_accommodation set available_units=available_units-1 where unit_id="+bdto.getUnitId()+" and accommodation_id="+bdto.getAccommodationId());
				dbUtil.getJDBCTemplate().update(sb1.toString());	
			System.out.println(bdto.getCheckInDate());
			System.out.println(bdto.getCheckOutDate());
			StringBuilder sb= new StringBuilder();
			sb.append("insert into booking_info (accommodation_id,unit_id,user_id,booing_date,checkin_date,checkout_date) ")
			 .append("values (?,?,?,?,?,?)");
			Object[] parms = new Object[]{bdto.getAccommodationId(),
					bdto.getUnitId(),bdto.getUserId(),new Date(),bdto.getCheckInDate(),bdto.getCheckOutDate()};
			int[] types = new int[]{Types.INTEGER, Types.INTEGER, Types.VARCHAR,Types.DATE, Types.DATE, Types.DATE};
			dbUtil.getJDBCTemplate().update(sb.toString(),parms,types);
	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		
		return bdto;
		}

	@Override
	public BookingDTO getMyBookings(BookingDTO bdto) {
		// TODO Auto-generated method stub
		StringBuilder sb1= new StringBuilder();
		List<BookingDTO> lbooking;
		try{
			sb1.append("select accommodation_name, unit_type,booing_date,checkin_date,checkout_date  from accommodation_info a, unit_info ui, booking_info usi where a.accommodation_id=usi.accommodation_id and ui.unit_id= usi.unit_id and usi.user_id=").append(bdto.getUserId());
	lbooking = dbUtil.getJDBCTemplate().query(sb1.toString(), new BookingInfoMapper());
	bdto.setGenericList(lbooking);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return bdto;
	}
}
