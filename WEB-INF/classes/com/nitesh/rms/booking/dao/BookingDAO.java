package com.nitesh.rms.booking.dao;

import com.nitesh.rms.bean.BookingDTO;
import com.nitesh.rms.generic.dao.GenericDAO;

public interface BookingDAO extends GenericDAO {

public BookingDTO getMyBookings(BookingDTO bdto);

public BookingDTO bookAccommodation(BookingDTO bdto);

}
