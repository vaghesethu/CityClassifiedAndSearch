package com.virtusa.bean;

import java.io.Serializable;
import java.util.Set;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="USER")
public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="UserId",unique=true,nullable=false)
	private int userId;
	
	@Column(name="UserName",unique=false,nullable=false,length=100)
	private String userName;
	
	@Column(name="UserEmail",unique=true,nullable=false,length=100)
	private String userEmail;
	
	@Column(name="Password",unique=false,nullable=false,length=100)
	private String password;
	
	@Column(name="Mobile",unique=true,nullable=false,length=10)
	private String mobile;
	
	@Column(name="userAddress",unique=true,nullable=false,length=100)
	private String userAddress;
	
	@Column(name="UserCity",unique=true,nullable=false,length=20)
	private String userCity;
	
	@Column(name="Role",unique=false,nullable=false,length=20)
	private String Role;
	
	@Column(name="enabled",nullable=false)
	private boolean enabled;

	@OneToMany
	@JoinColumn(name="UserId")
	private Set<Classified> classified;

	//Getters And Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	
	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Classified> getClassified() {
		return classified;
	}

	public void setClassified(Set<Classified> classified) {
		this.classified = classified;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", password="
				+ password + ", mobile=" + mobile + ", userAddress=" + userAddress + ", userCity=" + userCity
				+ ", Role=" + Role + ", enabled=" + enabled + ", classified=" + classified + "]";
	}

	
		
}
