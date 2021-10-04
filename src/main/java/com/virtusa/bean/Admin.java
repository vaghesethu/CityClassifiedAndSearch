package com.virtusa.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="ADMIN")
public class Admin implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="AdminId",unique=true,nullable=false)
	private int adminId;
	
	@Column(name="AdminEmail",unique=true,nullable=false,length=30)
	private String adminEmail;
	
	@Column(name="AdminPassword",unique=false,nullable=false,length=15)
	private String adminPassword;
	
	//Getters And Setters
	public int getAdminid() {
		return adminId;
	}
	
	public void setAdminid(int adminId) {
		this.adminId = adminId;
	}
	
	public String getAdminemail() {
		return adminEmail;
	}
	
	public void setAdminemail(String adminEmail) {
		this.adminEmail = adminEmail;
	}
	
	public String getAdminpassword() {
		return adminPassword;
	}
	
	public void setAdminpassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminEmail=" + adminEmail + ", adminPassword=" + adminPassword + "]";
	}
	
	
}
