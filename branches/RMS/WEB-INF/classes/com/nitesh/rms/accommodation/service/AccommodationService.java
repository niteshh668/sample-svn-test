package com.nitesh.rms.accommodation.service;

import java.util.List;

import com.nitesh.rms.bean.CountryInfoDTO;
import com.nitesh.rms.bean.GenericDTO;
import com.nitesh.rms.bean.StateInfoDTO;

public interface AccommodationService {

	public GenericDTO retriveAccommodationDetails(GenericDTO dto);
	
	public GenericDTO retriveAllAccommodationDetails(GenericDTO dto);

	public List<CountryInfoDTO> retriveCountryDetails();
	public GenericDTO viewAccommodationDetails(GenericDTO dto);
	
	public List<StateInfoDTO> retriveStateInfo(int countryId);
}
