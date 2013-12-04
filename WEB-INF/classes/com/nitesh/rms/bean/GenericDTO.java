package com.nitesh.rms.bean;

import java.io.Serializable;
import java.util.List;

public class GenericDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorMsg;
	private String successMsg;
	private List genericList;
	
	public List getGenericList() {
		return genericList;
	}

	public void setGenericList(List genericList) {
		this.genericList = genericList;
	}

	public GenericDTO()
	{
		errorMsg=null;
		successMsg=null;
		System.out.println("Inside Generic DTO");
	}
	
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getSuccessMsg() {
		return successMsg;
	}
	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}
}
