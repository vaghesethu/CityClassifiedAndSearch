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
@Table(name="CITYDETAILS")
public class Citydetails implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="CityId",unique=true,nullable=false)
	private int cityId;
	
	@Column(name="AdminId",unique=false,nullable=false)
	private int adminId;
	
	@Column(name="Category",unique=false,nullable=false,length=30)
	private String category;
	
	@Column(name="Name",unique=false,nullable=false,length=30)
	private String name;
	
	@Column(name="Address",unique=false,nullable=false,length=50)
	private String address;
	
	@Column(name="City",unique=false,nullable=false,length=20)
	private String city;
	
	@Column(name="Link",unique=false,nullable=false,length=1000)
	private String link;

	//Getters And Setters
	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Citydetails [cityId=" + cityId + ", adminId=" + adminId + ", category=" + category + ", name=" + name
				+ ", address=" + address + ", city=" + city + ", link=" + link + "]";
	}
	
	
	
}
