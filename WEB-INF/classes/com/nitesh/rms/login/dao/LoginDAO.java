package com.nitesh.rms.login.dao;

import com.nitesh.rms.bean.GenericDTO;
import com.nitesh.rms.generic.dao.GenericDAO;

public interface LoginDAO extends GenericDAO{

	public GenericDTO registerUser(GenericDTO dto);

	public GenericDTO authenticate(GenericDTO dto);

	public GenericDTO retrieveUserDetails(GenericDTO dto); 
}
