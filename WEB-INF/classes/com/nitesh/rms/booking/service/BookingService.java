package com.nitesh.rms.booking.service;

import com.nitesh.rms.bean.BookingDTO;

public interface BookingService {

	public BookingDTO bookAccommodation(BookingDTO bdto);
	public BookingDTO getMyBookings(BookingDTO bdto);

}
