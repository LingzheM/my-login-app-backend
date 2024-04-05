package com.example.myapp.dto;

public class PersonalInfoDTO {
	
	private String passportNumber;
	
	private String passportExpiryDate;
	
	private int visaDuration;
	
	private String visaExpiryDate;
	
	private String residenceStatus;
	
	private String myNumber;
	
	private String residenceNumber;
	
	public PersonalInfoDTO() {}

	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportExpiryDate() {
		return passportExpiryDate;
	}

	public void setPassportExpiryDate(String passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	public int getVisaDuration() {
		return visaDuration;
	}

	public void setVisaDuration(int visaDuration) {
		this.visaDuration = visaDuration;
	}

	public String getVisaExpiryDate() {
		return visaExpiryDate;
	}

	public void setVisaExpiryDate(String visaExpiryDate) {
		this.visaExpiryDate = visaExpiryDate;
	}

	public String getResidenceStatus() {
		return residenceStatus;
	}

	public void setResidenceStatus(String residenceStatus) {
		this.residenceStatus = residenceStatus;
	}

	public String getMyNumber() {
		return myNumber;
	}

	public void setMyNumber(String myNumber) {
		this.myNumber = myNumber;
	}

	public String getResidenceNumber() {
		return residenceNumber;
	}

	public void setResidenceNumber(String residenceNumber) {
		this.residenceNumber = residenceNumber;
	}

	@Override
	public String toString() {
		return "PersonalInfoDTO [passportNumber=" + passportNumber + ", passportExpiryDate=" + passportExpiryDate
				+ ", visaDuration=" + visaDuration + ", visaExpiryDate=" + visaExpiryDate + ", residenceStatus="
				+ residenceStatus + ", myNumber=" + myNumber + ", residenceNumber=" + residenceNumber + "]";
	}
	
	

}
