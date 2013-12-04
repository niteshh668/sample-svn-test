package com.nitesh.rms.booking.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.nitesh.rms.bean.BookingDTO;
import com.nitesh.rms.bean.LoginDTO;
import com.nitesh.rms.booking.service.BookingService;
import com.opensymphony.xwork2.ActionSupport;

public class BookingAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private BookingDTO bdto;
	public BookingDTO getBdto() {
		return bdto;
	}

	public void setBdto(BookingDTO bdto) {
		this.bdto = bdto;
	}

	private BookingService bservice;
	public BookingService getBservice() {
		return bservice;
	}

	public void setBservice(BookingService bservice) {
		this.bservice = bservice;
	}

	private static final long serialVersionUID = 1L;

	public String bookAccommodation()
	{ 
		String accommodationId= (String)session.get("accommodationId");
		String unitId=(String)session.get("unitId");
		LoginDTO ldto=(LoginDTO)session.get("LoginDTO");
		String userId= ldto.getUsername();
		System.out.println(accommodationId);
		System.out.println(unitId);
		System.out.println(userId);
				bdto.setAccommodationId(Integer.parseInt(accommodationId));
		bdto.setUnitId(Integer.parseInt(unitId));
		bdto.setUserId(userId);
		bdto = bservice.bookAccommodation(bdto);
		
		return SUCCESS;
	}
	private Map<String,Object> session;
	
	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.session=arg0;
	}
	public String getMyBookings()
	{
		if(!"NotAjax".equals(requestType)){
			LoginDTO ldto=(LoginDTO)session.get("LoginDTO");
			String userId= ldto.getUsername();
			bdto.setUserId(userId);
			bdto=bservice.getMyBookings(bdto);
		}
		return SUCCESS;
		
	}
private String requestType;
public String getRequestType() {
	return requestType;
}

public void setRequestType(String requestType) {
	this.requestType = requestType;
}

}
