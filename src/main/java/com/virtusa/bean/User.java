package com.virtusa.bean;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userid", unique = true, nullable = false)
	private int userId;
	
	@Column(name = "username", unique = false, nullable = false, length = 20)
	private String userName;
	
	@Column(name = "useremail", unique = true, nullable = false, length = 30)
	private String userEmail;
	
	@Column(name = "password", unique = false, nullable = false, length = 60)
	private String password;
	
	@Column(name = "mobile", unique = false, nullable = true, length = 10)
	private String mobile;
	
	@Column(name = "useraddress", unique = false, nullable = true, length = 30)
	private String userAddress;
	
	@Column(name = "usercity", unique = false, nullable = true, length=10)
	private String userCity;
	
	@Column(name = "enabled")
	private char enabled;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "usersroles",
			joinColumns = @JoinColumn(
		            name = "userid", referencedColumnName = "userid"),
			inverseJoinColumns = @JoinColumn(
				            name = "roleid", referencedColumnName = "id"))
	
	private Collection<Role> roles;

	public User() {
		super();
	}

	public User(String userName, String userEmail, String password, String mobile, String userAddress,
			String userCity, char enabled, Collection<Role> roles) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.password = password;
		this.mobile = mobile;
		this.userAddress = userAddress;
		this.userCity = userCity;
		this.enabled = enabled;
		this.roles = roles;
	}

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

	public char getEnabled() {
		return enabled;
	}

	public void setEnabled(char enabled) {
		this.enabled = enabled;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userEmail=" + userEmail + ", password="
				+ password + ", mobile=" + mobile + ", userAddress=" + userAddress + ", userCity=" + userCity
				+ ", enabled=" + enabled + ", roles=" + roles + "]";
	}
}
