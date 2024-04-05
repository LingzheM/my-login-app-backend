package com.example.myapp.utils;

import com.example.myapp.dto.BasicInfoDTO;
import com.example.myapp.dto.ContractInfoDTO;
import com.example.myapp.dto.ExperienceInfoDTO;
import com.example.myapp.dto.GraduationInfoDTO;
import com.example.myapp.dto.HomeCountryInfoDTO;
import com.example.myapp.dto.KaishaInfoDTO;
import com.example.myapp.dto.PersonalInfoDTO;
import com.example.myapp.dto.SalaryInfoDTO;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JsonUtils {

	private static final ObjectMapper objectMapper = new ObjectMapper();

	/**
	 * 从请求参数中提取转换基本信息
	 * @param jsonStr
	 * @return
	 */
    public static BasicInfoDTO extractBasicInfo(String jsonStr) {
        try {
            JsonNode rootNode = objectMapper.readTree(jsonStr);
            JsonNode basicInfoNode = rootNode.path("basicInfo");
            log.info("[BasicInfoDTO类型转换], {}", basicInfoNode.toPrettyString());
            BasicInfoDTO basicInfoDTO = objectMapper.treeToValue(basicInfoNode, BasicInfoDTO.class);
            return basicInfoDTO;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
     
    /**
     * 从请求参数中提取转换个人信息
     * @param jsonStr
     * @return
     */
    public static PersonalInfoDTO extractPersonalInfo(String jsonStr) {
            try {
                JsonNode rootNode = objectMapper.readTree(jsonStr);
                JsonNode personalInfoNode = rootNode.path("personalInfo");
                log.info("[PersonalInfoDTO类型转换], {}", personalInfoNode.toPrettyString());
                PersonalInfoDTO personalInfoDTO = objectMapper.treeToValue(personalInfoNode, PersonalInfoDTO.class);
                return personalInfoDTO;
            } catch (Exception e) {
                e.printStackTrace();
                return null; 
            }
    }
    
    /**
     * 从请求参数中提取会社信息
     * @param jsonStr
     * @return
     */
    public static KaishaInfoDTO extractKaishaInfoDTO(String jsonStr) {
    	try {
    		JsonNode rootNode = objectMapper.readTree(jsonStr);
            JsonNode kaishaInfoNode = rootNode.path("kaishaInfo");
            log.info("[KaishaInfoDTO类型转换], {}", kaishaInfoNode.toPrettyString());
            KaishaInfoDTO kaishaInfoDTO = objectMapper.treeToValue(kaishaInfoNode, KaishaInfoDTO.class);
            return kaishaInfoDTO;
    	} catch(Exception e) {
    		return null;
    	}
    	
    }
    
    /**
     * 从请求中提取社員給与
     * @param jsonStr
     * @return
     */
    public static SalaryInfoDTO extractSalaryInfoDTO(String jsonStr) {
    	try {
    		JsonNode rootNode = objectMapper.readTree(jsonStr);
            JsonNode salaryInfoNode = rootNode.path("salaryInfo");
            log.info("[SalaryInfoDTO类型转换], {}", salaryInfoNode.toPrettyString());
            SalaryInfoDTO salaryInfoDTO = objectMapper.treeToValue(salaryInfoNode, SalaryInfoDTO.class);
            return salaryInfoDTO;
    	} catch(Exception e) {
    		return null;
    	}
    	
    }
    
    /**
     * 从请求中提取連絡先
     * @param jsonStr
     * @return
     */
    public static ContractInfoDTO extractContractInfoDTO(String jsonStr) {
    	try {
    		JsonNode rootNode = objectMapper.readTree(jsonStr);
    		JsonNode contractInfoNode = rootNode.path("contractInfo");
    		log.info("[ContractInfoDTO类型转换], {}",contractInfoNode.toPrettyString());
    		ContractInfoDTO contracInfoDTO = objectMapper.treeToValue(contractInfoNode, ContractInfoDTO.class);
    		return contracInfoDTO;
    	} catch(Exception e) {
    		return null;
    	}
    }
    
    /**
     * 母国関連
     * @param jsonStr
     * @return
     */
    public static HomeCountryInfoDTO extractHomeCountryInfoDTO(String jsonStr) {
    	try {
    		JsonNode rootNode = objectMapper.readTree(jsonStr);
    		JsonNode homeCountryInfoNode = rootNode.path("homeCountryInfo");
    		log.info("[HomeCountryInfoDTO类型转换], {}", homeCountryInfoNode.toPrettyString());
    		HomeCountryInfoDTO homeCountryInfoDTO = objectMapper.treeToValue(homeCountryInfoNode, HomeCountryInfoDTO.class);
    		return homeCountryInfoDTO;
    	} catch(Exception e) {
    		return null;
    	}
    }
    
    /**
     * 卒業
     * @param jsonStr
     * @return
     */
    public static GraduationInfoDTO extractGraduationInfoDTO(String jsonStr) {
    	try {
    		JsonNode rootNode = objectMapper.readTree(jsonStr);
    		JsonNode graduationInfoNode = rootNode.path("graduationInfo");
    		log.info("[GraduationInfoDTO类型转换], {}", graduationInfoNode.toPrettyString());
    		GraduationInfoDTO graduationInfoDTO = objectMapper.treeToValue(graduationInfoNode, GraduationInfoDTO.class);
    		return graduationInfoDTO;
    	} catch(Exception e) {
    		return null;
    	}
    }
    
    /**
     * 社員経歴
     * @param jsonStr
     * @return
     */
    public static ExperienceInfoDTO extractExperienceInfoDTO(String jsonStr) {
    	try {
    		JsonNode rootNode = objectMapper.readTree(jsonStr);
    		JsonNode experienceInfoNode = rootNode.path("experienceInfo");
    		log.info("[ExperienceInfoDTO类型转换], {}", experienceInfoNode.toPrettyString());
    		ExperienceInfoDTO experienceInfoDTO = objectMapper.treeToValue(experienceInfoNode, ExperienceInfoDTO.class);
    		return experienceInfoDTO;
    	} catch (Exception e) {
    		return null;
    	}
    }
}
