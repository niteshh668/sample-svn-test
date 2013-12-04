package com.nitesh.rms.accommodation.dao;

import java.util.ArrayList;
import java.util.List;

import com.nitesh.rms.bean.AccommodationDTO;
import com.nitesh.rms.bean.CountryInfoDTO;
import com.nitesh.rms.bean.GenericDTO;
import com.nitesh.rms.bean.RegistrationDTO;
import com.nitesh.rms.bean.StateInfoDTO;
import com.nitesh.rms.bean.UnitsDTO;
import com.nitesh.rms.spring.mapper.AccommodationInfoMapper;
import com.nitesh.rms.spring.mapper.CountryInfoMapper;
import com.nitesh.rms.spring.mapper.FacilitiesInfoMapper;
import com.nitesh.rms.spring.mapper.StateInfoMapper;
import com.nitesh.rms.spring.mapper.UnitInfoMapper;
import com.nitesh.rms.spring.mapper.UserInfoMapper;
import com.nitesh.rms.util.DBUtil;

public class AccommodationDAOImpl implements AccommodationDAO {

	private DBUtil dbUtil;

	public DBUtil getDbUtil() {
		return dbUtil;
	}

	public void setDbUtil(DBUtil dbUtil) {
		this.dbUtil = dbUtil;
	}

	@Override
	public GenericDTO retriveAccommodationDetails(GenericDTO dto) {
		// TODO Auto-generated method stub
		AccommodationDTO adto = (AccommodationDTO) dto;
		StringBuilder sb = new StringBuilder();

		try {
			sb.append(
					"select accommodation_id, accommodation_name,state_id from accommodation_info ")
					.append("where state_id=").append(adto.getStateId());
			List<AccommodationDTO> accommodationDetails = dbUtil
					.getJDBCTemplate().query(sb.toString(),
							new AccommodationInfoMapper());
			dto.setGenericList(accommodationDetails);
			System.out.println(accommodationDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public GenericDTO retriveAllAccommodationDetails(GenericDTO dto) {
		// TODO Auto-generated method stub
		dto = new AccommodationDTO();
		try {

			List<AccommodationDTO> accommodationDetails = dbUtil
					.getJDBCTemplate()
					.query("select accommodation_id, accommodation_name,state_id from accommodation_info",
							new AccommodationInfoMapper());
			dto.setGenericList(accommodationDetails);
			System.out.println(accommodationDetails);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;

	}

	@Override
	public List<StateInfoDTO> retriveStateInfo(int countryId) {

		StringBuilder sb = new StringBuilder();
		List<StateInfoDTO> stateInfoList = new ArrayList<StateInfoDTO>();
		try {

			sb.append("select state_id, country_id,state_code,state_name from state_info");
			if (countryId != 0)
				sb.append(" where country_id = ").append(countryId);
			stateInfoList = dbUtil.getJDBCTemplate().query(sb.toString(),
					new StateInfoMapper());
			System.out.println(stateInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stateInfoList;
	}

	@Override
	public List<CountryInfoDTO> retriveCountryDetails() {
		List<CountryInfoDTO> countryInfoList = new ArrayList<CountryInfoDTO>();
		try {
			countryInfoList = dbUtil
					.getJDBCTemplate()
					.query("select country_id, country_code,country_name from country_info",
							new CountryInfoMapper());
			System.out.println(countryInfoList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return countryInfoList;
	}

	@Override
	public GenericDTO viewAccommodationDetails(GenericDTO dto) {
		// TODO Auto-generated method stub
		StringBuilder query1 = new StringBuilder();
		StringBuilder query2 = new StringBuilder();
		List<UnitsDTO> lunits;
		List<String> lfacilities;
		AccommodationDTO adto = (AccommodationDTO) dto;
		try {
			query1.append(
					"select facilities_type from accommodation_info ai,facilities_info fi, facilities_per_accommodation fpa ")
					.append("where fpa.accommodation_id=ai.accommodation_id and fpa.facilities_id=fi.facilities_id and ai.accommodation_id=")
					.append(adto.getAccommodationId());
			lfacilities= dbUtil.getJDBCTemplate().query(query1.toString(), new FacilitiesInfoMapper()); 
			query2.append("select available_units, ui.unit_id, upa.total_units, unit_type from units_per_accommodation upa, unit_info ui ")
			.append("where upa.unit_id=ui.unit_id and upa.accommodation_id=").append(adto.getAccommodationId());
			lunits=dbUtil.getJDBCTemplate().query(query2.toString(), new UnitInfoMapper());
			
			adto.setLfacilities(lfacilities);
			adto.setLunits(lunits);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return adto;
	}

}
