package com.example.myapp.dto;

public class ContractInfoDTO {
	private String addressZip;
	private String addressStreet;
	private String addressDetails;
	private String nearestStation;
	private String phoneNumber;
	private String email;
	private String wechatId;
	private String lineId;
	public String getAddressZip() {
		return addressZip;
	}
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}
	public String getAddressStreet() {
		return addressStreet;
	}
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}
	public String getAddressDetails() {
		return addressDetails;
	}
	public void setAddressDetails(String addressDetails) {
		this.addressDetails = addressDetails;
	}
	public String getNearestStation() {
		return nearestStation;
	}
	public void setNearestStation(String nearestStation) {
		this.nearestStation = nearestStation;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getWechatId() {
		return wechatId;
	}
	public void setWechatId(String wechatId) {
		this.wechatId = wechatId;
	}
	public String getLineId() {
		return lineId;
	}
	public void setLineId(String lineId) {
		this.lineId = lineId;
	}
	@Override
	public String toString() {
		return "ContractInfoDTO [addressZip=" + addressZip + ", addressStreet=" + addressStreet + ", addressDetails="
				+ addressDetails + ", nearestStation=" + nearestStation + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", wechatId=" + wechatId + ", lineId=" + lineId + "]";
	}
	
	
}
