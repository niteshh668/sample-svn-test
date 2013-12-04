package com.nitesh.rms.accommodation.service;

import java.util.List;

import org.springframework.dao.support.DaoSupport;

import com.nitesh.rms.accommodation.dao.AccommodationDAO;
import com.nitesh.rms.bean.CountryInfoDTO;
import com.nitesh.rms.bean.GenericDTO;
import com.nitesh.rms.bean.RegistrationDTO;
import com.nitesh.rms.bean.StateInfoDTO;
import com.nitesh.rms.bean.UnitsDTO;
import com.nitesh.rms.generic.dao.GenericDAO;
import com.nitesh.rms.login.dao.LoginDAO;

public class AccommodationServiceImpl implements AccommodationService {

	private AccommodationDAO adao;

	public AccommodationDAO getAdao() {
		return adao;
	}

	public void setAdao(AccommodationDAO adao) {
		this.adao = adao;
		
	}

	@Override
	public GenericDTO retriveAccommodationDetails(GenericDTO dto) {
		
		return adao.retriveAccommodationDetails(dto);
	}

	@Override
	public GenericDTO retriveAllAccommodationDetails(GenericDTO dto) {
		// TODO Auto-generated method stub
		try {
			dto = adao.retriveAllAccommodationDetails(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public List<CountryInfoDTO> retriveCountryDetails() {
		return adao.retriveCountryDetails();
 
	}

	@Override
	public List<StateInfoDTO> retriveStateInfo(int countryId) {
		// TODO Auto-generated method stub
		return adao.retriveStateInfo(countryId);
	}

	@Override
	public GenericDTO viewAccommodationDetails(GenericDTO dto) {
		// TODO Auto-generated method stub
		
		return adao.viewAccommodationDetails(dto);
	}

}
