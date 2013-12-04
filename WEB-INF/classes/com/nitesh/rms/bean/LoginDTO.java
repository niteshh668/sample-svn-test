package com.nitesh.rms.bean;

public class LoginDTO extends GenericDTO {

	private String username;
	private String password;
	public LoginDTO()
	{
		System.out.println("Inside Login DTO");
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
