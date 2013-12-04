package com.nitesh.rms.login.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;



import com.nitesh.rms.bean.RegistrationDTO;
import com.nitesh.rms.login.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class RegisterUserAction extends ActionSupport{
	
	
	private RegistrationDTO rdto = new RegistrationDTO() ;
	
	public RegistrationDTO getRdto() {
		return rdto;
	}
	public void setRdto(RegistrationDTO rdto) {
		this.rdto = rdto;
	}
	
	private List<RegistrationDTO> registrationList;
	
	public List<RegistrationDTO> getRegistrationList() {
		return registrationList;
	}
	public void setRegistrationList(List<RegistrationDTO> registrationList) {
		this.registrationList = registrationList;
	}

	private LoginService gservice;
	public LoginService getGservice() { 
		return gservice;
	}
	public void setGservice(LoginService gservice) {
		this.gservice = gservice;
	}
	
	public String execute(){
		String result = null;
		try{
			gservice.registerUser(rdto);
			registrationList = rdto.getGenericList();
			if(rdto.getErrorMsg() != null){
				result = ERROR;
			}else{
				result = ERROR;
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public String retrieveUserDetails()
	{
		
		try{
			gservice.retrieveUserDetails(rdto);
			JSONObject jobj=new JSONObject();
			registrationList = rdto.getGenericList();
			JSONArray jarray= JSONArray.fromObject(registrationList);
			jobj.put("total", Math.ceil(registrationList.size()/20.0));
			jobj.put("page", 1);
			jobj.put("records", registrationList.size());
			jobj.put("rows", jarray);
			System.out.println(jobj);
			HttpServletResponse response = ServletActionContext.getResponse();
			response.setContentType("application/json");
			jobj.write(response.getWriter());
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	public void validate(){
		if(rdto.getFirstname() == null || rdto.getFirstname().trim().length() == 0){
			addFieldError("rdto.firstname", "First Name should not be null");
		}
		if(rdto.getLastname() == null || rdto.getLastname().trim().length() == 0){
			addFieldError("rdto.lastname", "Last Name should not be null");
		}
	}
}
