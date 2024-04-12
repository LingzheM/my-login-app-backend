package com.example.myapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.service.CustomerInformationService;
import com.example.myapp.vo.CustomerInformationVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class CustomerInformationController {
	
	@Autowired
	private CustomerInformationService customerInformationService;

	@GetMapping("/searchCustomer")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
	public ResponseEntity<List<CustomerInformationVO>> searchCustomer(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		log.info("[featureController], session 是否存在: {}", session != null);
		if (session != null && session.getAttribute("userRole")!=null) {
			log.info("[featureContoller], session存在");
			log.info("[featureController], session id: {}", session.getId());
//			String userRole = (String) session.getAttribute("userRole");
		}
		return ResponseEntity.ok().body(customerInformationService.selectAllCustomerInformation());
	}
}
