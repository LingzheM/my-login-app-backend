package com.example.myapp.vo;

public class EmployeeVO {
	
	private Integer id;
	
	private String company;
	
	private String employeeName;
	
	private String gender;
	
	public EmployeeVO(Integer id, String company, String employeeName, String gender, String positionType,
			String joinDate, String leaveDate) {
		super();
		this.id = id;
		this.company = company;
		this.employeeName = employeeName;
		this.gender = gender;
		this.positionType = positionType;
		this.joinDate = joinDate;
		this.leaveDate = leaveDate;
	}

	private String positionType;
	
	private String joinDate;
	
	private String leaveDate;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPositionType() {
		return positionType;
	}

	public void setPositionType(String positionType) {
		this.positionType = positionType;
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

}
