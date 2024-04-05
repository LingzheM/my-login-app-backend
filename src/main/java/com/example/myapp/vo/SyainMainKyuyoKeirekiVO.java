package com.example.myapp.vo;

import com.example.myapp.dto.BasicInfoDTO;
import com.example.myapp.dto.KaishaInfoDTO;
import com.example.myapp.dto.PersonalInfoDTO;


public class SyainMainKyuyoKeirekiVO {
	private BasicInfoDTO basicInfo;
	
	private PersonalInfoDTO personalInfo;
	
	private KaishaInfoDTO kaishaInfo;

	public BasicInfoDTO getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(BasicInfoDTO basicInfo) {
		this.basicInfo = basicInfo;
	}

	public PersonalInfoDTO getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfoDTO personalInfo) {
		this.personalInfo = personalInfo;
	}

	public KaishaInfoDTO getKaishaInfo() {
		return kaishaInfo;
	}

	public void setKaishaInfo(KaishaInfoDTO kaishaInfo) {
		this.kaishaInfo = kaishaInfo;
	}


	
	
}
