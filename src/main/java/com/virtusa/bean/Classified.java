package com.virtusa.bean;

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
	
	@Column(name = "classifiedtitle", unique = false, nullable = false)
	private String classifiedTitle;
	
	@Column(name = "classifiedCategory", unique = false, nullable = false)
	private String classifiedCatgory;
	
	public Classified() {
		super();
	}

	public Classified(User user, String classifiedTitle, String classifiedCatgory) {
		super();
		this.classifiedTitle = classifiedTitle;
		this.classifiedCatgory = classifiedCatgory;
	}

	public int getClassifiedId() {
		return classifiedId;
	}

	public void setClassifiedId(int classifiedId) {
		this.classifiedId = classifiedId;
	}

	public String getClassifiedTitle() {
		return classifiedTitle;
	}

	public void setClassifiedTitle(String classifiedTitle) {
		this.classifiedTitle = classifiedTitle;
	}

	public String getClassifiedCatgory() {
		return classifiedCatgory;
	}

	public void setClassifiedCatgory(String classifiedCatgory) {
		this.classifiedCatgory = classifiedCatgory;
	}

	@Override
	public String toString() {
		return "Classified [classifiedId=" + classifiedId + ", classifiedTitle=" + classifiedTitle
				+ ", classifiedCatgory=" + classifiedCatgory + "]";
	}
}