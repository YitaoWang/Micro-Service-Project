package com.hackwinrepeat.project.beans;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="patient")
public class PatientEntity implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, length=50)
	private String name;
	
	@Column(nullable=false, length=120)
	private String email;
	
	@Column(nullable=false, length=12)
	private String phone;
	
	@Column(nullable=false, length=12)
	private String diseaseA;
	
	@Column(nullable=false, length=12)
	private String diseaseB;
	
	@Column(nullable=false, length=12)
	private String diseaseC;
	

	public String getDiseaseA() {
		return diseaseA;
	}

	public void setDiseaseA(String diseaseA) {
		this.diseaseA = diseaseA;
	}

	public String getDiseaseB() {
		return diseaseB;
	}

	public void setDiseaseB(String diseaseB) {
		this.diseaseB = diseaseB;
	}

	public String getDiseaseC() {
		return diseaseC;
	}

	public void setDiseaseC(String diseaseC) {
		this.diseaseC = diseaseC;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
