package com.example.myapp.dto;

public class GraduationInfoDTO {

	/**
	 * highestEducation: string;
    schoolName: string;
    major: string;
    graduationDate: string;
	 */
	private String highestEducation;
	private String schoolName;
	private String major;
	private String graduationDate;
	public String getHighestEducation() {
		return highestEducation;
	}
	public void setHighestEducation(String highestEducation) {
		this.highestEducation = highestEducation;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getGraduationDate() {
		return graduationDate;
	}
	public void setGraduationDate(String graduationDate) {
		this.graduationDate = graduationDate;
	}
	@Override
	public String toString() {
		return "GraduationInfoDTO [highestEducation=" + highestEducation + ", schoolName=" + schoolName + ", major="
				+ major + ", graduationDate=" + graduationDate + "]";
	}
	
	
}
