package com.example.myapp.serivce;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.myapp.service.SyainMainService;
import com.example.myapp.vo.EmployeeVO;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
public class SyainMainServiceTest {
	@Autowired
	SyainMainService syainMainService;
	
	@Test
	public void testInsert() {
		List<EmployeeVO> employees = syainMainService.searchEmployess(null, null, 1);
		log.info("size: {}", employees.size());
		
	}
	


}
