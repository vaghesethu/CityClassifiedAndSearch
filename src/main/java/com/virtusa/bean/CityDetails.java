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

	//not yet mapped/implemented
	//private int userId;
	//foreign key(userid) references user(userid)
	
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

	public CityDetails(int cityId, String city, String category, String name, String address, String link) {
		super();
		this.cityId = cityId;
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
		return "CityDetails [cityId=" + cityId + ", city=" + city + ", category=" + category + ", name=" + name
				+ ", address=" + address + ", link=" + link + "]";
	}
}