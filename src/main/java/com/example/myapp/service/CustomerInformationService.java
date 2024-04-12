package com.example.myapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.CustomerInformation;
import com.example.myapp.mapper.CustomerInformationRepository;
import com.example.myapp.vo.CustomerInformationVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CustomerInformationService {
	
	@Autowired
	private CustomerInformationRepository customerInformationRepository;
	
	public List<CustomerInformationVO> selectAllCustomerInformation() {
		List<CustomerInformationVO> customerInformationVOList = new ArrayList<>();
		List<CustomerInformation> customerInformationList = customerInformationRepository.findAll();
		log.info("[取引先]　数量: {}", customerInformationList.size());
		for (CustomerInformation customerInformation : customerInformationList) {
			CustomerInformationVO customerInformationVO = new CustomerInformationVO();
			customerInformationVO.setId(customerInformation.getTorihikiId());
			customerInformationVO.setName(customerInformation.getTorihikiNameAll());
			customerInformationVO.setManager("A");
			customerInformationVO.setPhone(customerInformation.getTel());
			customerInformationVO.setEmail(customerInformation.getFax());
			customerInformationVOList.add(customerInformationVO);
		}
		return customerInformationVOList;
	}

}
