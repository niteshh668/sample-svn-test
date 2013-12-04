package com.nitesh.rms.login.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class SessionCheckInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public String intercept(ActionInvocation invoke) throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		System.out.println(request.getRequestURL());
		HttpSession session= request.getSession();
		if(request.getRequestURI().contains("BookingAction"))
		{
		String accommodation =  request.getParameter("accommodationId");
		String unitId =  request.getParameter("unitId");
		session.setAttribute("accommodationId",accommodation);
		session.setAttribute("unitId",unitId);
			if (session.getAttribute("LoginDTO")==null)
				return "DisplayLogin";
		}
		if(request.getRequestURI().contains("bookAccommodationAction"))
		{
			if (session.getAttribute("LoginDTO")==null)
				return "Rooms";
		}
		
		
		return invoke.invoke();
		
	}

}
