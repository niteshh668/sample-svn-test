package com.nitesh.rms.accommodation.dao;

import java.util.List;

import com.nitesh.rms.bean.CountryInfoDTO;
import com.nitesh.rms.bean.GenericDTO;
import com.nitesh.rms.bean.StateInfoDTO;
import com.nitesh.rms.generic.dao.GenericDAO;

public interface AccommodationDAO extends GenericDAO{

public GenericDTO retriveAccommodationDetails(GenericDTO dto);
	
	public GenericDTO retriveAllAccommodationDetails(GenericDTO dto);
	
	public List<StateInfoDTO> retriveStateInfo(int countryId);
	public List<CountryInfoDTO> retriveCountryDetails();
	public GenericDTO viewAccommodationDetails(GenericDTO dto);
	
}
