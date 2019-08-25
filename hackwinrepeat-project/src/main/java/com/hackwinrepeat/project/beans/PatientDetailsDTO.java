package com.hackwinrepeat.project.beans;

import java.io.Serializable;

public class PatientDetailsDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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

	private long id;
	
	private String name;
	
	private String email;
	
	private String phone;
	
	private String diseaseA;
	
	private String diseaseB;
	
	private String diseaseC;
	
}
