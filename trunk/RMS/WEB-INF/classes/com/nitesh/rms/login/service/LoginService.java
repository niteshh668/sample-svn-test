package com.nitesh.rms.login.service;

import com.nitesh.rms.bean.GenericDTO;

public interface LoginService {

	public GenericDTO registerUser(GenericDTO dto);
	
	public GenericDTO authenticate(GenericDTO dto);

	public GenericDTO retrieveUserDetails(GenericDTO rdto);
}
