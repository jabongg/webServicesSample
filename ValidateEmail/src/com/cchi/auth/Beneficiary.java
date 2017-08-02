package com.cchi.auth;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "BeneficiaryDetails")
public class Beneficiary {
	private String name;
	private String email;
	private String passportNumber;
	private String visaNumber;
	
	public Beneficiary() {
		
	}
	
	public Beneficiary(String name, String email, String passportNumber,
			String visaNumber) {
		super();
		this.name = name;
		this.email = email;
		this.passportNumber = passportNumber;
		this.visaNumber = visaNumber;
	}
	
	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@XmlElement(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement(name="passportNumber")
	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	@XmlElement(name="visaNumber")
	public String getVisaNumber() {
		return visaNumber;
	}
	public void setVisaNumber(String visaNumber) {
		this.visaNumber = visaNumber;
	}

}
