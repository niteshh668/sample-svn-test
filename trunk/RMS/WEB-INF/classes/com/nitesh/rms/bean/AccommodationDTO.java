package com.nitesh.rms.bean;

import java.util.List;

public class AccommodationDTO extends GenericDTO {
	private int accommodationId;
	private int stateId;
	private String accommodationName;
	private List<UnitsDTO> lunits;
	private List<String> lfacilities;
	public List<UnitsDTO> getLunits() {
		return lunits;
	}

	public void setLunits(List<UnitsDTO> lunits) {
		this.lunits = lunits;
	}

	public List<String> getLfacilities() {
		return lfacilities;
	}

	public void setLfacilities(List<String> lfacilities) {
		this.lfacilities = lfacilities;
	}

	public int getAccommodationId() {
		return accommodationId;
	}

	public void setAccommodationId(int accommodationId) {
		this.accommodationId = accommodationId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public String getAccommodationName() {
		return accommodationName;
	}

	public void setAccommodationName(String accommodationName) {
		this.accommodationName = accommodationName;
	}

}
