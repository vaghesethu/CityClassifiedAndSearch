package com.cityclassifiedandsearch.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "classified")
public class Classified {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "classifiedid", unique = true, nullable = false)
	private int classifiedId;
	
	@Column(name = "userid", unique = false, nullable = false)
	private int userId;
	
	@Column(name = "classifiedtitle", unique = false, nullable = false)
	private String classifiedTitle;
	
	@Column(name = "description", unique = false, nullable = true)
	private String description;
	
	@Column(name = "classifiedCategory", unique = false, nullable = false)
	private String classifiedCatgory;
	
	public Classified() {
		super();
	}

	public Classified(int userId, String classifiedTitle, String description, String classifiedCatgory) {
		super();
		this.userId = userId;
		this.classifiedTitle = classifiedTitle;
		this.description = description;
		this.classifiedCatgory = classifiedCatgory;
	}

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

	public String getClassifiedCatgory() {
		return classifiedCatgory;
	}

	public void setClassifiedCatgory(String classifiedCatgory) {
		this.classifiedCatgory = classifiedCatgory;
	}

	@Override
	public String toString() {
		return "Classified [classifiedId=" + classifiedId + ", userId=" + userId + ", classifiedTitle="
				+ classifiedTitle + ", description=" + description + ", classifiedCatgory=" + classifiedCatgory + "]";
	}
}