package com.example.myapp.dto;

public class KaishaInfoDTO {
	
	private String company;
	
	private String joinDate;
	
	private String leaveDate;
	
	private String occupationType;
	
	private String arrivalDateInJapan;
	
	private String remarks;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getLeaveDate() {
		return leaveDate;
	}

	public void setLeaveDate(String leaveDate) {
		this.leaveDate = leaveDate;
	}

	public String getOccupationType() {
		return occupationType;
	}

	public void setOccupationType(String occupationType) {
		this.occupationType = occupationType;
	}

	public String getArrivalDateInJapan() {
		return arrivalDateInJapan;
	}

	public void setArrivalDateInJapan(String arrivalDateInJapan) {
		this.arrivalDateInJapan = arrivalDateInJapan;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public String toString() {
		return "KaishaInfoDTO [company=" + company + ", joinDate=" + joinDate + ", leaveDate=" + leaveDate
				+ ", occupationType=" + occupationType + ", arrivalDateInJapan=" + arrivalDateInJapan + ", remark="
				+ remarks + "]";
	}
	
	

}
