package com.example.myapp.dto;

import java.util.List;

public class SalaryInfoDTO {
	
	private BankInfo bankInfo;
	
	private List<SalaryHistory> salaryHistory;
	
	
	
	@Override
	public String toString() {
		return "SalaryInfoDTO [bankInfo=" + bankInfo.toString() + ", salaryHistorySize=" + salaryHistory.size() + "]";
	}


	public BankInfo getBankInfo() {
		return bankInfo;
	}


	public void setBankInfo(BankInfo bankInfo) {
		this.bankInfo = bankInfo;
	}


	public List<SalaryHistory> getSalaryHistory() {
		return salaryHistory;
	}


	public void setSalaryHistory(List<SalaryHistory> salaryHistory) {
		this.salaryHistory = salaryHistory;
	}


	public static class BankInfo {
		private String bankCode;
		private String bankName;
		private String branchCode;
		private String branchName;
		private String accountType;
		private String accountNumber;
		private String accountHolderName;
		public String getBankCode() {
			return bankCode;
		}
		public void setBankCode(String bankCode) {
			this.bankCode = bankCode;
		}
		public String getBankName() {
			return bankName;
		}
		public void setBankName(String bankName) {
			this.bankName = bankName;
		}
		public String getBranchCode() {
			return branchCode;
		}
		public void setBranchCode(String branchCode) {
			this.branchCode = branchCode;
		}
		public String getBranchName() {
			return branchName;
		}
		public void setBranchName(String branchName) {
			this.branchName = branchName;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getAccountHolderName() {
			return accountHolderName;
		}
		public void setAccountHolderName(String accountHolderName) {
			this.accountHolderName = accountHolderName;
		}
		@Override
		public String toString() {
			return "BankInfo [bankCode=" + bankCode + ", bankName=" + bankName + ", branchCode=" + branchCode
					+ ", branchName=" + branchName + ", accountType=" + accountType + ", accountNumber=" + accountNumber
					+ ", accountHolderName=" + accountHolderName + "]";
		}
		
		
	}
	

	public static class SalaryHistory {
		private String startMonth;
		private String endMonth;
		private int basicSalary;
		private int skillSalary;
		private String employmentInsuranceNumber;
		private String pensionNumber;
		private int pensionBaseAmount;
		private String healthInsuranceNumber;
		private String remark;
		public String getStartMonth() {
			return startMonth;
		}
		public void setStartMonth(String startMonth) {
			this.startMonth = startMonth;
		}
		public String getEndMonth() {
			return endMonth;
		}
		public void setEndMonth(String endMonth) {
			this.endMonth = endMonth;
		}
		public int getBasicSalary() {
			return basicSalary;
		}
		public void setBasicSalary(int basicSalary) {
			this.basicSalary = basicSalary;
		}
		public int getSkillSalary() {
			return skillSalary;
		}
		public void setSkillSalary(int skillSalary) {
			this.skillSalary = skillSalary;
		}
		public String getEmploymentInsuranceNumber() {
			return employmentInsuranceNumber;
		}
		public void setEmploymentInsuranceNumber(String employmentInsuranceNumber) {
			this.employmentInsuranceNumber = employmentInsuranceNumber;
		}
		public String getPensionNumber() {
			return pensionNumber;
		}
		public void setPensionNumber(String pensionNumber) {
			this.pensionNumber = pensionNumber;
		}
		public int getPensionBaseAmount() {
			return pensionBaseAmount;
		}
		public void setPensionBaseAmount(int pensionBaseAmount) {
			this.pensionBaseAmount = pensionBaseAmount;
		}
		public String getHealthInsuranceNumber() {
			return healthInsuranceNumber;
		}
		public void setHealthInsuranceNumber(String healthInsuranceNumber) {
			this.healthInsuranceNumber = healthInsuranceNumber;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}
		@Override
		public String toString() {
			return "SalaryHistory [startMonth=" + startMonth + ", endMonth=" + endMonth + ", basicSalary=" + basicSalary
					+ ", skillSalary=" + skillSalary + ", employmentInsuranceNumber=" + employmentInsuranceNumber
					+ ", pensionNumber=" + pensionNumber + ", persionBaseAmount=" + pensionBaseAmount
					+ ", healthInsuranceNumber=" + healthInsuranceNumber + ", remark=" + remark + "]";
		}
		
		
	}
}
