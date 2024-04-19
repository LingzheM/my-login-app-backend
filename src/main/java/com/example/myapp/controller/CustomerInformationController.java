package com.example.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.service.CustomerInformationService;
import com.example.myapp.vo.CustomerInfoAndStaffVO;
import com.example.myapp.vo.CustomerInfoVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerInformationController {
	
	@Autowired
	private CustomerInformationService customerInformationService;
	
    private static final ObjectMapper objectMapper = new ObjectMapper(); // Jackson's object mapper


	@GetMapping("/searchCustomer")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
	public ResponseEntity<List<CustomerInfoVO>> searchCustomer(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		log.info("[featureController], session 是否存在: {}", session != null);
		if (session != null && session.getAttribute("userRole")!=null) {
			log.info("[featureContoller], session存在");
			log.info("[featureController], session id: {}", session.getId());
//			String userRole = (String) session.getAttribute("userRole");
		}
		return ResponseEntity.ok().body(customerInformationService.selectAllCustomerInformation());
	}
	
	//searchCustomerByCondition
	@GetMapping("/searchCustomerByCondition")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
	public ResponseEntity<List<CustomerInfoVO>> searchCustomerByCondition(@RequestParam(value = "name", required = false)String name,
			@RequestParam(value = "source", required = false)Integer source) {
		return ResponseEntity.ok().body(customerInformationService.selectCustomerInfomationByCondition(name, source));
	}
	/**
	 * 登録リクエストの処理
	 * @param customerInfo
	 * @return 
	 */
	@PostMapping("/createBusinessCustomer")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
    public ResponseEntity<String> createCustomerInfo(@RequestBody CustomerInfoAndStaffVO customerInfo) {
		try {
            // Convert the CustomerInfoAndStaffVO object to a JSON string
            String json = objectMapper.writeValueAsString(customerInfo);
            log.info("Received CustomerInfoAndStaffVO: {}", json);
            boolean result = customerInformationService.saveCustomerInfoAndStaffs(customerInfo);
            if (result) {
            	return ResponseEntity.ok().body("取引先");
            } else {
                return ResponseEntity.badRequest().body("失敗した");
            }
        } catch (JsonProcessingException e) {
            log.error("Error serializing CustomerInfoAndStaffVO", e);
            return ResponseEntity.badRequest().body("失敗した");
        }

	}
	
	
	/**
	 * 登録リクエストの処理
	 * @param customerInfo
	 * @return 
	 */
	@PostMapping("/updateBusinessCustomer")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
    public ResponseEntity<String> updateCustomerInfo(@RequestBody CustomerInfoAndStaffVO customerInfo) {
		try {
            // Convert the CustomerInfoAndStaffVO object to a JSON string
            String json = objectMapper.writeValueAsString(customerInfo);
            log.info("Received CustomerInfoAndStaffVO: {}", json);
            boolean result = customerInformationService.updateCustomerInfoAndStaffs(customerInfo);
            if (result) {
            	return ResponseEntity.ok().body("取引先");
            } else {
                return ResponseEntity.badRequest().body("失敗した");
            }
        } catch (JsonProcessingException e) {
            log.error("Error serializing CustomerInfoAndStaffVO", e);
            return ResponseEntity.badRequest().body("失敗した");
        }

	}
	
	@GetMapping("/searchCustomerById")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
	public ResponseEntity<CustomerInfoAndStaffVO> searchCustomerById(@RequestParam(value = "customerId", required = false)Integer customerId) {
		try {
			CustomerInfoAndStaffVO customerVO = customerInformationService.selectCustomerInfoAndStaffsByCustomerId(customerId);
			return ResponseEntity.ok().body(customerVO);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(null);
		}
		
	}
}
