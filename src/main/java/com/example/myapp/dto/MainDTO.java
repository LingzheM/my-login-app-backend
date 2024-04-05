package com.example.myapp.dto;

public class MainDTO {
	
	private BasicInfoDTO basicInfoDTO;
	
	private PersonalInfoDTO personalInfoDTO;
	
	public PersonalInfoDTO getPersonalInfoDTO() {
		return personalInfoDTO;
	}

	public void setPersonalInfoDTO(PersonalInfoDTO personalInfoDTO) {
		this.personalInfoDTO = personalInfoDTO;
	}

	public MainDTO() {
		
	}

	public BasicInfoDTO getBasicInfoDTO() {
		return basicInfoDTO;
	}

	public void setBasicInfoDTO(BasicInfoDTO basicInfoDTO) {
		this.basicInfoDTO = basicInfoDTO;
	}

	@Override
	public String toString() {
		return "MainDTO [basicInfoDTO=" + basicInfoDTO + ", getBasicInfoDTO()=" + basicInfoDTO.toString() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
