package com.example.myapp.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.dto.BasicInfoDTO;
import com.example.myapp.dto.ContractInfoDTO;
import com.example.myapp.dto.ExperienceInfoDTO;
import com.example.myapp.dto.GraduationInfoDTO;
import com.example.myapp.dto.HomeCountryInfoDTO;
import com.example.myapp.dto.KaishaInfoDTO;
import com.example.myapp.dto.PersonalInfoDTO;
import com.example.myapp.dto.SalaryInfoDTO;
import com.example.myapp.entity.SyainKeireki;
import com.example.myapp.entity.SyainKyuyo;
import com.example.myapp.entity.SyainMain;
import com.example.myapp.service.SyainKoushinService;
import com.example.myapp.service.SyainMainService;
import com.example.myapp.service.SyainTourokuService;
import com.example.myapp.utils.JsonUtils;
import com.example.myapp.vo.EmployeeVO;
import com.example.myapp.vo.SyainMainKyuyoKeirekiVO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class FeaturesController {
	
	@Autowired
	SyainMainService syainMainService;
	
	@Autowired
	SyainTourokuService syainTourokuService;
	
	@Autowired
	SyainKoushinService syainKoushinService;
	
	
	@GetMapping("/searchEmployee")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
	public ResponseEntity<List<EmployeeVO>> searchEmployee(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		log.info("[featureController], session 是否存在: {}", session == null);
		if (session != null && session.getAttribute("userRole")!=null) {
			log.info("[featureContoller], session存在");
			log.info("[featureController], session id: {}", session.getId());
//			String userRole = (String) session.getAttribute("userRole");
		}
		return ResponseEntity.ok().body(syainMainService.searchSyain());
	}
	
	@GetMapping("/search")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
	public ResponseEntity<List<EmployeeVO>> searchEmployeeWithParam(
			@RequestParam(value = "company", required = false) Integer company,
			@RequestParam(value = "employeeName", required = false) String employeeName,
			@RequestParam(value = "positionType", required = false) Integer positionType,
			@RequestParam(value = "employed", required = false) String employed,
			@RequestParam(value = "unemployed", required = false) String unemployed) {
		log.info("[request param], company: {}, employeeName: {}, positionType: {}, employed: {}, unemployed: {}", company, employeeName, positionType, employed, unemployed);
		
		List<EmployeeVO> employees = syainMainService.searchEmployess(company, employeeName, positionType);
	
		return ResponseEntity.ok().body(employees);
	}
	
	@PostMapping("/syainTouRoku")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
	public ResponseEntity<String> syainTouRoku(HttpServletRequest request) {
		log.info("[社員登録リクエスト]");
        try {
        	String requestBody = getRequestBody(request);
    		log.info("[社員登録], request body: {}", requestBody);
        	BasicInfoDTO basicInfo = JsonUtils.extractBasicInfo(requestBody);
        	log.info("[社員登録] basicInfo: {}", basicInfo.toString());
            SyainMain syainMain = syainTourokuService.convertBasicInfoDTO(basicInfo);
        	
            PersonalInfoDTO personalInfo = JsonUtils.extractPersonalInfo(requestBody);
        	log.info("[社員登録] personalInfo: {}", personalInfo.toString());
            syainMain = syainTourokuService.convertPersonalDTO(syainMain, personalInfo);
        	
            KaishaInfoDTO kaishaInfo = JsonUtils.extractKaishaInfoDTO(requestBody);
        	log.info("[社員登録] kaishaInfo: {}", kaishaInfo.toString());
            syainMain = syainTourokuService.convertKaishaDTO(syainMain, kaishaInfo);

        	ContractInfoDTO contractInfo = JsonUtils.extractContractInfoDTO(requestBody);
        	log.info("[社員登録] contractInfo: {}", contractInfo.toString());
        	syainMain = syainTourokuService.convertContractDTO(syainMain, contractInfo);
        	
        	HomeCountryInfoDTO homeCountryInfo = JsonUtils.extractHomeCountryInfoDTO(requestBody);
        	log.info("[社員登録]　homeCountryInfo: {}", homeCountryInfo.toString());
        	syainMain = syainTourokuService.convertHomeCountryDTO(syainMain, homeCountryInfo);
        	
        	GraduationInfoDTO graduationInfo = JsonUtils.extractGraduationInfoDTO(requestBody);
        	log.info("[社員登録]　graduationInfo: {}", graduationInfo.toString());
        	syainMain = syainTourokuService.convertGraduationCountryDTO(syainMain, graduationInfo);
        	
        	// 社員給与
        	SalaryInfoDTO salaryInfo = JsonUtils.extractSalaryInfoDTO(requestBody);
        	log.info("[社員登録] salaryInfo: {}", salaryInfo.getSalaryHistory().size());
        	List<SyainKyuyo> syainKyuyoList = syainTourokuService.convertSalaryInfoDTO(syainMain, salaryInfo);
        	
        	// 社員経歴
        	ExperienceInfoDTO experienceInfo = JsonUtils.extractExperienceInfoDTO(requestBody);
        	log.info("[社員登録] experienceInfo: {}", experienceInfo.getExperienceHistory().size());
            List<SyainKeireki> syainKeirekiList = syainTourokuService.convertExperienceInfoDTO(experienceInfo);

            // 社員メイン、給与、経歴の登録
            syainTourokuService.saveSyainTouroku(syainMain, syainKeirekiList, syainKyuyoList);
    		return ResponseEntity.ok().body("syain saved");

		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return ResponseEntity.badRequest().body("meet somme error");
		}
	}
	
	@GetMapping("/selectSyainBySyainId")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*")
	public ResponseEntity<SyainMainKyuyoKeirekiVO> selectSyainBySyainId(@RequestParam(value = "syainId", required = false) Integer syainId) {
		log.info("[社員検索], syainId: {}", syainId);
		SyainMainKyuyoKeirekiVO syainVO = syainKoushinService.selectSyainBySyainId(syainId);
		return ResponseEntity.ok().body(syainVO);
	}

	
	public String getRequestBody(HttpServletRequest request) throws IOException {
	    StringBuilder requestBody = new StringBuilder();
	    String line;
	    BufferedReader reader = request.getReader();
	    while ((line = reader.readLine()) != null) {
	        requestBody.append(line).append('\n');
	    }
	    return requestBody.toString();
	}
	

}
