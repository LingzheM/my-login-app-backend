package com.example.myapp.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.CustomerInformation;
import com.example.myapp.entity.StaffDetail;
import com.example.myapp.mapper.CustomerInformationRepository;
import com.example.myapp.mapper.StaffDetailRepository;
import com.example.myapp.vo.CustomerInfoAndStaffVO;
import com.example.myapp.vo.CustomerInfoAndStaffVO.CustomerBasicInfo;
import com.example.myapp.vo.CustomerInfoVO;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerInformationService {
	
	@Autowired
	private CustomerInformationRepository customerInformationRepository;
	@Autowired
	private StaffDetailRepository staffDetailRepository;
	
	public List<CustomerInfoVO> selectAllCustomerInformation() {
		List<CustomerInfoVO> customerInformationVOList = new ArrayList<>();
		List<CustomerInformation> customerInformationList = customerInformationRepository.findAll();
		log.info("[取引先]　数量: {}", customerInformationList.size());
		for (CustomerInformation customerInformation : customerInformationList) {
			CustomerInfoVO customerInformationVO = new CustomerInfoVO();
			customerInformationVO.setId(customerInformation.getTorihikiId());
			customerInformationVO.setName(customerInformation.getTorihikiNameAll());
			customerInformationVO.setManager("A");
			customerInformationVO.setPhone(customerInformation.getTel());
			customerInformationVO.setEmail(customerInformation.getFax());
			customerInformationVOList.add(customerInformationVO);
		}
		return customerInformationVOList;
	}
	
	public List<CustomerInfoVO> selectCustomerInfomationByCondition(String name, Integer source) {
	    // 如果名称为空，转换为空字符串来匹配所有记录
	    String searchName = (name != null) ? name : "";
	    List<CustomerInformation> customers = customerInformationRepository.findByTorihikiNameAllContainingAndHonsya(searchName, source);
	    List<CustomerInfoVO> customerInformationVOList = new ArrayList<>();
		log.info("[検索した取引先]　数量: {}", customers.size());
		for (CustomerInformation customerInformation : customers) {
			CustomerInfoVO customerInformationVO = new CustomerInfoVO();
			customerInformationVO.setId(customerInformation.getTorihikiId());
			customerInformationVO.setName(customerInformation.getTorihikiNameAll());
			customerInformationVO.setManager("A");
			customerInformationVO.setPhone(customerInformation.getTel());
			customerInformationVO.setEmail(customerInformation.getFax());
			customerInformationVOList.add(customerInformationVO);
		}
		return customerInformationVOList;
	}


	/**
	 * torihiki_idによって、取引先と担当者を検索
	 * @param customerId
	 * @return
	 */
	public CustomerInfoAndStaffVO selectCustomerInfoAndStaffsByCustomerId(Integer customerId) {
		CustomerInfoAndStaffVO customerInfoAndStaffVO = new CustomerInfoAndStaffVO();
		log.info("[取引先を検索]");
		Optional<CustomerInformation> optional = customerInformationRepository.findById(customerId);
		if (!optional.isEmpty()) {
			CustomerInformation customer = optional.get();
			// 填充基本信息
			CustomerInfoAndStaffVO.CustomerBasicInfo basicInfo = updateCustomerBasicInfoFromEntity(customer);
			customerInfoAndStaffVO.setBasicInfo(basicInfo);
			// 填充billing信息
			customerInfoAndStaffVO.setBilling(new CustomerInfoAndStaffVO.BillingSettings());
			updateBillingSettingsFromEntity(customer, customerInfoAndStaffVO.getBilling());
			// 填充transfer
			customerInfoAndStaffVO.setTransfer(new CustomerInfoAndStaffVO.TransferInfo());
			updateTransferInfoFromEntity(customer, customerInfoAndStaffVO.getTransfer());
			
		}
		log.info("取引先の担当者を検索");
		List<StaffDetail> staffDetails = staffDetailRepository.findByTorihikiId(customerId);
		// 填充affair
		List<CustomerInfoAndStaffVO.AffairPersonInfo> affairs = updateAffairPersonInfoFromEntityList(staffDetails);
		customerInfoAndStaffVO.setAffair(affairs);
		
		return customerInfoAndStaffVO;
	}
	

	/**
	 * 保存や更新取引先と担当者
	 * @param customerInfoAndStaffVO
	 * @return
	 */
	@Transactional
	public boolean saveCustomerInfoAndStaffs(CustomerInfoAndStaffVO customerInfoAndStaffVO) {
		try {
			CustomerInformation customerInformation = new CustomerInformation();
			List<StaffDetail> staffDetail = null;
			if (customerInfoAndStaffVO != null) {
				updateEntityWithCustomerBasicInfo(customerInformation, customerInfoAndStaffVO.getBasicInfo());
				updateEntityWithTransferInfo(customerInformation, customerInfoAndStaffVO.getTransfer());
				updateEntityWithBillingSettings(customerInformation, customerInfoAndStaffVO.getBilling());
				staffDetail = updateEntityListWithAffairPersonInfo(customerInfoAndStaffVO.getAffair());
				// 保存CustomerInformation实体并自动填充ID
				customerInformation = customerInformationRepository.save(customerInformation);

			}
			// 获取保存后的ID
	        Integer torihikiId = customerInformation.getTorihikiId();
	        // 更新每个StaffDetail实体的torihikiId并保存
	        for (StaffDetail detail : staffDetail) {
	            detail.setTorihikiId(torihikiId);
	            staffDetailRepository.save(detail);
	        }
	        log.info("[取引先保存]　success");
	        return true;
		} catch(Exception e) {
			log.error("[error], {}", e.getMessage().toString());
			return false;
		}
		
	}
	
	@Transactional
	public boolean updateCustomerInfoAndStaffs(CustomerInfoAndStaffVO customerInfoAndStaffVO) {
	    try {
	        // 首先检查是否提供了有效的ID
	        if (customerInfoAndStaffVO == null || customerInfoAndStaffVO.getId() == null) {
	            log.error("[リクエストがないです]");
	            return false;
	        }

	        // 尝试查找现有的CustomerInformation
	        CustomerInformation customerInformation = customerInformationRepository.findById(customerInfoAndStaffVO.getId())
	            .orElse(null);

	        if (customerInformation == null) {
	            log.error("[更新すべきIdはさが探しません]ID: {}", customerInfoAndStaffVO.getId());
	            return false;
	        }

	        // 更新现有客户信息
	        updateEntityWithCustomerBasicInfo(customerInformation, customerInfoAndStaffVO.getBasicInfo());
	        updateEntityWithTransferInfo(customerInformation, customerInfoAndStaffVO.getTransfer());
	        updateEntityWithBillingSettings(customerInformation, customerInfoAndStaffVO.getBilling());
	        
	        // 保存更新
	        customerInformationRepository.save(customerInformation);

	        // 处理关联的StaffDetail
	        List<StaffDetail> staffDetails = updateEntityListWithAffairPersonInfo(customerInfoAndStaffVO.getAffair());
	        for (StaffDetail detail : staffDetails) {
	            detail.setTorihikiId(customerInfoAndStaffVO.getId()); // 设置对应的customer ID
	            staffDetailRepository.save(detail);
	        }

	        log.info("[更新完了]");
	        return true;
	    } catch (Exception e) {
	        log.error("[エラー] {}", e.getMessage());
	        return false;
	    }
	}

	
	/**
	 * 请求体到取引先实体类的映射
	 * @param basicInfo
	 * @return
	 */
	public CustomerInformation updateEntityWithCustomerBasicInfo(CustomerInformation customerInformation, CustomerInfoAndStaffVO.CustomerBasicInfo basicInfo) {
		customerInformation.setTorihikiNameAll(basicInfo.getCustomerFullName()); // 映射全名到交易名称
		customerInformation.setTorihikiNameRyaku(basicInfo.getCustomerName()); // 映射简称到交易简称
		customerInformation.setYuubin(basicInfo.getAddressZip()); // 映射邮编
		customerInformation.setJyusyo1(basicInfo.getAddress1()); // 映射地址1
		customerInformation.setJyusyo2(basicInfo.getAddress2()); // 映射地址2
	    customerInformation.setTel(basicInfo.getPhone()); // 映射电话号码
	    customerInformation.setFax(basicInfo.getFax()); // 映射传真号码
	    customerInformation.setUrl(basicInfo.getHomePage()); // 映射网页地址
	    customerInformation.setBikou(basicInfo.getRemark()); // 映射备注
	    customerInformation.setDeleteFlag(0);
	    if (customerInformation.getTorokubi() == null) {
	        customerInformation.setTorokubi(new Date());
	    }
	    // 在更新之前始终设置更新时间
	    customerInformation.setKousinnbi(new Date());
	    return customerInformation;
	}
	
	/**
	 * 取引先实体类到请求体的映射
	 * @param customer
	 * @return
	 */
	public CustomerBasicInfo updateCustomerBasicInfoFromEntity(CustomerInformation customer) {
		CustomerInfoAndStaffVO.CustomerBasicInfo basicInfo = new CustomerInfoAndStaffVO.CustomerBasicInfo();
	    basicInfo.setCustomerFullName(customer.getTorihikiNameAll()); // 从交易名称映射全名
	    basicInfo.setCustomerName(customer.getTorihikiNameRyaku()); // 从交易简称映射简称
	    basicInfo.setAddressZip(customer.getYuubin()); // 从邮编映射
	    basicInfo.setAddress1(customer.getJyusyo1()); // 从地址1映射
	    basicInfo.setAddress2(customer.getJyusyo2()); // 从地址2映射
	    basicInfo.setPhone(customer.getTel()); // 从电话号码映射
	    basicInfo.setFax(customer.getFax()); // 从传真号码映射
	    basicInfo.setHomePage(customer.getUrl()); // 从网页地址映射
	    basicInfo.setRemark(customer.getBikou()); // 从备注映射

	    return basicInfo;
	}
	
	public void updateEntityWithTransferInfo(CustomerInformation customer, CustomerInfoAndStaffVO.TransferInfo transferInfo) {
	    if (customer != null && transferInfo != null) {
	        customer.setKinyukikanCode(transferInfo.getBankCode()); // 更新银行代码
	        customer.setKinyukikanName(transferInfo.getBankName()); // 更新银行名称
	        customer.setSitenCode(transferInfo.getBranchCode()); // 更新分行代码
	        customer.setSitenName(transferInfo.getBranchName()); // 更新分行名称
	        customer.setKouzaKind(transferInfo.getAccountType()); // 更新账户类型
	        customer.setKouzaNum(transferInfo.getAccountNumber()); // 更新账户号码
	        customer.setMeigiName(transferInfo.getName()); // 更新账户名义名
	    }
	}
	
	public void updateTransferInfoFromEntity(CustomerInformation customer, CustomerInfoAndStaffVO.TransferInfo transferInfo) {
	    if (customer != null && transferInfo != null) {
	        transferInfo.setBankCode(customer.getKinyukikanCode()); // 获取银行代码
	        transferInfo.setBankName(customer.getKinyukikanName()); // 获取银行名称
	        transferInfo.setBranchCode(customer.getSitenCode()); // 获取分行代码
	        transferInfo.setBranchName(customer.getSitenName()); // 获取分行名称
	        transferInfo.setAccountType(customer.getKouzaKind()); // 获取账户类型
	        transferInfo.setAccountNumber(customer.getKouzaNum()); // 获取账户号码
	        transferInfo.setName(customer.getMeigiName()); // 获取账户名义名
	    }
	}

	public void updateEntityWithBillingSettings(CustomerInformation customer, CustomerInfoAndStaffVO.BillingSettings billingSettings) {
	    if (customer != null && billingSettings != null) {
	        customer.setSeikyusyoKubun1(billingSettings.getIsMailInvoice()); // 映射是否邮寄发票
	        customer.setSeikyusyoKubun2(billingSettings.getIsFileName()); // 映射是否使用文件名
	        customer.setSeikyusyoKubun3(billingSettings.getIsCaseName()); // 映射是否使用案例名称
	        customer.setSeikyusyoKubun4(billingSettings.getIsDelivery()); // 映射是否交付
	        customer.setSeikyusyoKubun5(billingSettings.getInvoiceProviding()); // 映射发票提供方式
	        customer.setSeikyusyoKubun6(billingSettings.getBillingUnit()); // 映射计费单位
	        customer.setHonsya(billingSettings.getOfficeDesignation()); // 映射本社指定
	        customer.setHonsyaKouza(billingSettings.getOfficeAccount()); // 映射本社账户
	    }
	}

	public void updateBillingSettingsFromEntity(CustomerInformation customer, CustomerInfoAndStaffVO.BillingSettings billingSettings) {
	    if (customer != null && billingSettings != null) {
	        billingSettings.setIsMailInvoice(customer.getSeikyusyoKubun1()); // 获取是否邮寄发票
	        billingSettings.setIsFileName(customer.getSeikyusyoKubun2()); // 获取是否使用文件名
	        billingSettings.setIsCaseName(customer.getSeikyusyoKubun3()); // 获取是否使用案例名称
	        billingSettings.setIsDelivery(customer.getSeikyusyoKubun4()); // 获取是否交付
	        billingSettings.setInvoiceProviding(customer.getSeikyusyoKubun5()); // 获取发票提供方式
	        billingSettings.setBillingUnit(customer.getSeikyusyoKubun6()); // 获取计费单位
	        billingSettings.setOfficeDesignation(customer.getHonsya()); // 获取本社指定
	        billingSettings.setOfficeAccount(customer.getHonsyaKouza()); // 获取本社账户
	    }
	}

	public List<StaffDetail> updateEntityListWithAffairPersonInfo(List<CustomerInfoAndStaffVO.AffairPersonInfo> affairPersonInfos) {
	    List<StaffDetail> staffDetails = new ArrayList<>();
	    for (CustomerInfoAndStaffVO.AffairPersonInfo info : affairPersonInfos) {
	        StaffDetail detail = new StaffDetail();
	        detail.setFirstName(info.getFirstName());
	        detail.setLastName(info.getLastName());
	        detail.setSyozoku(info.getBelong());
	        detail.setYakusyoku(info.getPosition());
	        detail.setMail(info.getEmail());
	        detail.setTel(info.getPhone());
	        // 根据cc和to设置jimuMail的值
	        if (info.getCc() == 1) {
	            detail.setJimuMail(0); // 如果cc是1，则设置jimu_mail为0
	        } else if (info.getTo() == 1) {
	            detail.setJimuMail(1); // 如果to是1，则设置jimu_mail为1
	        }
	        detail.setBikou(info.getRemark());
	        staffDetails.add(detail);
	    }
	    return staffDetails;
	}

	public List<CustomerInfoAndStaffVO.AffairPersonInfo> updateAffairPersonInfoFromEntityList(List<StaffDetail> staffDetails) {
	    List<CustomerInfoAndStaffVO.AffairPersonInfo> affairPersonInfos = new ArrayList<>();
	    for (StaffDetail detail : staffDetails) {
	        CustomerInfoAndStaffVO.AffairPersonInfo info = new CustomerInfoAndStaffVO.AffairPersonInfo();
	        info.setFirstName(detail.getFirstName());
	        info.setLastName(detail.getLastName());
	        info.setBelong(detail.getSyozoku());
	        info.setPosition(detail.getYakusyoku());
	        info.setEmail(detail.getMail());
	        info.setPhone(detail.getTel());
	        info.setRemark(detail.getBikou());
	        affairPersonInfos.add(info);
	    }
	    return affairPersonInfos;
	}




}
