package com.virtusa.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="CLASSIFIED")
public class Classified implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ClassifiedId",unique=true,nullable=false)
	private int classifiedId;
	
	@Column(name="UserId",unique=false,nullable=false)
	private int userId;
	
	@Column(name="ClassifiedCategory",unique=false,nullable=false,length=30)
	private String classifiedCategory;
	
	@Column(name="ClassifiedTitle",unique=false,nullable=false,length=30)
	private String classifiedTitle;
	
	@Column(name="Description",unique=false,nullable=false,length=500)
	private String description;
	
	@ManyToOne
	private User user;

	//Getters And Setters
	public int getClassifiedId() {
		return classifiedId;
	}

	public void setClassifiedId(int classifiedId) {
		this.classifiedId = classifiedId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getClassifiedCategory() {
		return classifiedCategory;
	}

	public void setClassifiedCategory(String classifiedCategory) {
		this.classifiedCategory = classifiedCategory;
	}

	public String getClassifiedTitle() {
		return classifiedTitle;
	}

	public void setClassifiedTitle(String classifiedTitle) {
		this.classifiedTitle = classifiedTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Classified [classifiedId=" + classifiedId + ", userId=" + userId + ", classifiedCategory="
				+ classifiedCategory + ", classifiedTitle=" + classifiedTitle + ", description=" + description
				+ ", user=" + user + "]";
	}
	
}
