package com.virtusa.service.web.dto;

public class UserRegistrationDto {
	private String userName;
	private String userEmail;
	private String password;
	private String mobile;
	private String userAddress;
	private String userCity;
	private boolean enabled;
	
	public UserRegistrationDto() {
		super();
	}
	
	public UserRegistrationDto(String userName, String userEmail, String password, String mobile, String userAddress,
			String userCity, boolean enabled) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.mobile = mobile;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.enabled = enabled;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserEmail() {
		return userEmail;
	}
	
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMobile() {
		return mobile;
	}
	
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	public String getUserAddress() {
		return userAddress;
	}
	
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	
	public String getUserCity() {
		return userCity;
	}
	
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}
