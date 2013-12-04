package com.nitesh.rms.login.action;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.nitesh.rms.bean.LoginDTO;
import com.nitesh.rms.login.service.LoginService;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private LoginService lservice;
	private LoginDTO  ldto;
	public LoginAction()
	{
		System.out.println("Inside LOgin Action");
	}
	
	
	/*public LoginDTO getModel(){
		return ldto;
	}*/
	public LoginService getLservice() {
		return lservice;
	}

	public LoginDTO getLdto() {
		System.out.println("ajax called this method");
		return ldto;
	}

	public void setLdto(LoginDTO ldto) {
		this.ldto = ldto;
	}

	public void setLservice(LoginService lservice) {
		this.lservice = lservice;
	}

	public String login()
	{
		String result = SUCCESS;
		try{
			lservice.authenticate(ldto);
			
			System.out.println("Authenticating login credentials: "+ldto.getErrorMsg()+"--"+ldto.getSuccessMsg());
			if(ldto.getErrorMsg() != null){
				result = ERROR;
			}
			else{
				session.put("LoginDTO", ldto);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	
	public String sampleAjaxRequest(){
		JSONObject object = new JSONObject();
		object.put("message", "You have clicked Read More");
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("application/json");
		try{
		object.write(response.getWriter());
		}catch(Exception e){
			e.printStackTrace();
		}
		/*ldto = new LoginDTO();
		ldto.setSuccessMsg("You have clicked Read More");*/
		return null;
	}

	private Map<String,Object> session;
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}

}
