package com.virtusa.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "citydetails")
public class CityDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cityid", unique = true, nullable = false)
	private int cityId;
	
	@Column(name = "userid", unique = false, nullable = false)
	private int userId;
	
	@Column(name = "city", unique = false, nullable = false)
	private String city;
	
	@Column(name = "category", unique = false, nullable = false)
	private String category;
	
	@Column(name = "name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "address", unique = false, nullable = false)
	private String address;
	
	@Column(name = "link", unique = false, nullable = true)
	private String link;
	
	public CityDetails() {
		super();
	}

	public CityDetails(int userId, String city, String category, String name, String address, String link) {
		super();
		this.userId = userId;
		this.city = city;
		this.category = category;
		this.name = name;
		this.address = address;
		this.link = link;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserid(int userId) {
		this.userId = userId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "CityDetails [cityId=" + cityId + ", userId=" + userId + ", city=" + city + ", category=" + category
				+ ", name=" + name + ", address=" + address + ", link=" + link + "]";
	}
}