package com.nitesh.rms.login.service;

import com.nitesh.rms.bean.GenericDTO;
import com.nitesh.rms.bean.RegistrationDTO;
import com.nitesh.rms.generic.dao.GenericDAO;
import com.nitesh.rms.login.dao.LoginDAO;

public class LoginServiceImpl implements LoginService{
	
	private LoginDAO dao;
	
	
	public LoginDAO getDao() {
		return dao;
	}

	public void setDao(LoginDAO dao) {
		this.dao = dao;
	}

	public GenericDTO registerUser(GenericDTO dto) {
		RegistrationDTO rdto = (RegistrationDTO)dto;
		try{
			rdto.setFirstname(rdto.getFirstname()+" "+rdto.getLastname());
			dao.registerUser(rdto);
		}catch(Exception e){
			e.printStackTrace();
		}
		return rdto;
	}

	
	public GenericDTO authenticate(GenericDTO dto) {
		try{
			dao.authenticate(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public GenericDTO retrieveUserDetails(GenericDTO dto) {
		// TODO Auto-generated method stub
		try{
			dao.retrieveUserDetails(dto);
		}catch(Exception e){
			e.printStackTrace();
		}
		return dto;
	}

}
