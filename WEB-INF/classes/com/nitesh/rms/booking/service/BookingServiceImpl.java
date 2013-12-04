package com.nitesh.rms.booking.service;

import com.nitesh.rms.bean.BookingDTO;
import com.nitesh.rms.booking.dao.BookingDAO;

public class BookingServiceImpl implements BookingService {

	
	private BookingDAO bdao;

	public BookingDAO getBdao() {
		return bdao;
	}

	public void setBdao(BookingDAO bdao) {
		this.bdao = bdao;
	}

	@Override
	public BookingDTO bookAccommodation(BookingDTO bdto) {
		// TODO Auto-generated method stub
		return bdao.bookAccommodation(bdto);
	}

	@Override
	public BookingDTO getMyBookings(BookingDTO bdto) {
		// TODO Auto-generated method stub
		return bdao.getMyBookings(bdto);
	}
	
	
	
	
}
