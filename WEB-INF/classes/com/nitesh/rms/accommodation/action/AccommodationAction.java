package com.nitesh.rms.accommodation.action;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.nitesh.rms.accommodation.service.AccommodationService;
import com.nitesh.rms.bean.AccommodationDTO;
import com.nitesh.rms.bean.CountryInfoDTO;
import com.nitesh.rms.bean.StateInfoDTO;
import com.nitesh.rms.logger.RMSLogger;
import com.opensymphony.xwork2.ActionSupport;

public class AccommodationAction extends ActionSupport {

	/**
	 * 
	 */
	private int country;
	private int state;

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
	}

	RMSLogger logger = RMSLogger.getRMSLogger("RMS");
	private List<CountryInfoDTO> countryInfo;
	private List<AccommodationDTO> accommodationInfo;
	private List<StateInfoDTO> stateinfo;

	public List<CountryInfoDTO> getCountryInfo() {
		return countryInfo;
	}

	public void setCountryInfo(List<CountryInfoDTO> countryInfo) {
		this.countryInfo = countryInfo;
	}

	public List<StateInfoDTO> getStateinfo() {
		return stateinfo;
	}

	public void setStateinfo(List<StateInfoDTO> stateinfo) {
		this.stateinfo = stateinfo;
	}

	private AccommodationService aservice;
	private AccommodationDTO adto;

	public AccommodationService getAservice() {
		return aservice;
	}

	public List<AccommodationDTO> getAccommodationInfo() {
		return accommodationInfo;
	}

	public void setAccommodationInfo(List<AccommodationDTO> accommodationInfo) {
		this.accommodationInfo = accommodationInfo;
	}

	public void setAservice(AccommodationService aservice) {
		this.aservice = aservice;
	}

	private static final long serialVersionUID = 1L;

	public List<CountryInfoDTO> retriveCountryDetails() {
		return null;
	}

	public List<StateInfoDTO> retriveStateInfo(int countryId) {
		return null;
	}

	public String retriveAccommodationDetails() {
		// if(logger.isInfoEnabled())
		logger.info("Inside retriveAccommodationDetails");
		// if(logger.isDebugEnabled())
		logger.debug("debugging in retriveAccommodationDetails");

		logger.error("error in retriveAccommodationDetails");
		String result = null;
		try {
			if (flag == null) {
				countryInfo = aservice.retriveCountryDetails();
				stateinfo = aservice.retriveStateInfo(country);
				result = SUCCESS;
			} else if (flag != null && flag.equals("ajax")) {
				System.out.println(state);
				if (state == 0)
					adto = (AccommodationDTO) aservice
							.retriveAllAccommodationDetails(adto);
				else {
					
					adto= new AccommodationDTO();
					adto.setStateId(state);
					adto = (AccommodationDTO) aservice
							.retriveAccommodationDetails(adto);
					
				}
				accommodationInfo = adto.getGenericList();
				JSONObject jobj = new JSONObject();
				JSONArray jarray = JSONArray.fromObject(accommodationInfo);
				jobj.put("total", Math.ceil(accommodationInfo.size() / 20.0));
				jobj.put("page", 1);
				jobj.put("records", accommodationInfo.size());
				jobj.put("rows", jarray);
				System.out.println(jobj);
				HttpServletResponse response = ServletActionContext
						.getResponse();
				response.setContentType("application/json");
				jobj.write(response.getWriter());
			}
		} catch (Exception e) {
			logger.error("error while fetching accommodation details", e);
		}
		return result;

	}

	public AccommodationDTO getAdto() {
		return adto;
	}

	public void setAdto(AccommodationDTO adto) {
		this.adto = adto;
	}

	public String viewAccommodationDetails()
	{
		System.out.println(adto.getAccommodationId());
		aservice.viewAccommodationDetails(adto);
		return SUCCESS;
	}
	
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

}
