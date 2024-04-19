package com.example.myapp.vo;

import java.util.List;

public class CustomerInfoAndStaffVO {

	private Integer id;
    private CustomerBasicInfo basicInfo;
    private TransferInfo transfer;
    private List<AffairPersonInfo> affair;
    private BillingSettings billing;


    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CustomerBasicInfo getBasicInfo() {
		return basicInfo;
	}

	public void setBasicInfo(CustomerBasicInfo basicInfo) {
		this.basicInfo = basicInfo;
	}

	public TransferInfo getTransfer() {
		return transfer;
	}

	public void setTransfer(TransferInfo transfer) {
		this.transfer = transfer;
	}

	public List<AffairPersonInfo> getAffair() {
		return affair;
	}

	public void setAffair(List<AffairPersonInfo> affair) {
		this.affair = affair;
	}

	public BillingSettings getBilling() {
		return billing;
	}

	public void setBilling(BillingSettings billing) {
		this.billing = billing;
	}

	public static class CustomerBasicInfo {
        private String customerFullName;
        private String customerName;
        private String addressZip;
        private String address1;
        private String address2;
        private String phone;
        private String fax;
        private String homePage;
        private String remark;
		public String getCustomerFullName() {
			return customerFullName;
		}
		public void setCustomerFullName(String customerFullName) {
			this.customerFullName = customerFullName;
		}
		public String getCustomerName() {
			return customerName;
		}
		public void setCustomerName(String customerName) {
			this.customerName = customerName;
		}
		public String getAddressZip() {
			return addressZip;
		}
		public void setAddressZip(String addressZip) {
			this.addressZip = addressZip;
		}
		public String getAddress1() {
			return address1;
		}
		public void setAddress1(String address1) {
			this.address1 = address1;
		}
		public String getAddress2() {
			return address2;
		}
		public void setAddress2(String address2) {
			this.address2 = address2;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getFax() {
			return fax;
		}
		public void setFax(String fax) {
			this.fax = fax;
		}
		public String getHomePage() {
			return homePage;
		}
		public void setHomePage(String homePage) {
			this.homePage = homePage;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}

        
    }

    public static class TransferInfo {
        private String bankCode;
        private String bankName;
        private String branchCode;
        private String branchName;
        private int accountType;
        private String accountNumber;
        private String name;
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
		public int getAccountType() {
			return accountType;
		}
		public void setAccountType(int accountType) {
			this.accountType = accountType;
		}
		public String getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(String accountNumber) {
			this.accountNumber = accountNumber;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

        
    }

    public static class AffairPersonInfo {
        private int to;
        private int cc;
        private String firstName;
        private String lastName;
        private String email;
        private String belong;
        private String position;
        private String phone;
        private String remark;
		public int getTo() {
			return to;
		}
		public void setTo(int to) {
			this.to = to;
		}
		public int getCc() {
			return cc;
		}
		public void setCc(int cc) {
			this.cc = cc;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getBelong() {
			return belong;
		}
		public void setBelong(String belong) {
			this.belong = belong;
		}
		public String getPosition() {
			return position;
		}
		public void setPosition(String position) {
			this.position = position;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getRemark() {
			return remark;
		}
		public void setRemark(String remark) {
			this.remark = remark;
		}

        
    }

    public static class BillingSettings {
        private int isMailInvoice;
        private int isFileName;
        private int isCaseName;
        private int isDelivery;
        private int invoiceProviding;
        private int billingUnit;
        private int officeDesignation;
        private int officeAccount;
		public int getIsMailInvoice() {
			return isMailInvoice;
		}
		public void setIsMailInvoice(int isMailInvoice) {
			this.isMailInvoice = isMailInvoice;
		}
		public int getIsFileName() {
			return isFileName;
		}
		public void setIsFileName(int isFileName) {
			this.isFileName = isFileName;
		}
		public int getIsCaseName() {
			return isCaseName;
		}
		public void setIsCaseName(int isCaseName) {
			this.isCaseName = isCaseName;
		}
		public int getIsDelivery() {
			return isDelivery;
		}
		public void setIsDelivery(int isDelivery) {
			this.isDelivery = isDelivery;
		}
		public int getInvoiceProviding() {
			return invoiceProviding;
		}
		public void setInvoiceProviding(int invoiceProviding) {
			this.invoiceProviding = invoiceProviding;
		}
		public int getBillingUnit() {
			return billingUnit;
		}
		public void setBillingUnit(int billingUnit) {
			this.billingUnit = billingUnit;
		}
		public int getOfficeDesignation() {
			return officeDesignation;
		}
		public void setOfficeDesignation(int officeDesignation) {
			this.officeDesignation = officeDesignation;
		}
		public int getOfficeAccount() {
			return officeAccount;
		}
		public void setOfficeAccount(int officeAccount) {
			this.officeAccount = officeAccount;
		}

       
    }
	
}
