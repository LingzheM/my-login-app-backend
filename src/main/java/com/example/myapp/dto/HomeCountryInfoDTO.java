package com.example.myapp.dto;

public class HomeCountryInfoDTO {
/**
 *     homeCountryAddress: string;
    emergencyContact: string;
 */
	private String homeCountryAddress;
	private String emergencyContact;
	
	public String getHomeCountryAddress() {
		return homeCountryAddress;
	}
	public void setHomeCountryAddress(String homeCountryAddress) {
		this.homeCountryAddress = homeCountryAddress;
	}
	public String getEmergencyContact() {
		return emergencyContact;
	}
	public void setEmergencyContact(String emergencyContact) {
		this.emergencyContact = emergencyContact;
	}
	@Override
	public String toString() {
		return "HomeCountryInfoDTO [homeCountryAddress=" + homeCountryAddress + ", emergencyContact=" + emergencyContact
				+ "]";
	}
	
	
}
