package com.example.myapp.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class FeaturesControllerTest {

	 @Autowired
	    private MockMvc mockMvc;

	    @Test
	    public void testSubmitForm() throws Exception {
	        // JSON请求体
	        String jsonRequestBody = "{\"basicInfo\":{\"employeeCode\":\"9527\",\"employeeNameKanji\":{\"firstName\":\"孟\",\"lastName\":\"令哲\"},\"employeeNameKatakana\":{\"firstName\":\"モウ\",\"lastName\":\"レイテツ\"},\"employeeNameEnglish\":{\"firstName\":\"meng\",\"lastName\":\"lingzhe\"},\"gender\":1,\"birthDate\":\"1997-06-22\",\"nationallity\":0,\"placeOfBirth\":\"中国河北省\",\"spousePresent\":1},\"personalInfo\":{\"passportNumber\":\"\",\"passportExpiryDate\":\"\",\"visaDuration\":0,\"visaExpiryDate\":\"\",\"residenceStatus\":\"\",\"myNumber\":\"\",\"residenceNumber\":\"\"},\"kaishaInfo\":{\"company\":\"株式会社ブライトスター\",\"joinDate\":\"1991-11-28\",\"occupationType\":\"ITエンジニア\",\"arrivalDateInJapan\":\"1991-11-28\",\"remarks\":\"\"},\"salaryInfo\":{\"bankInfo\":{\"bankCode\":\"0005\",\"bankName\":\"三菱UFJ銀行\",\"branchCode\":\"316\",\"branchName\":\"福生支店\",\"accountType\":\"普通\",\"accountNumber\":\"1234567\",\"accountHolderName\":\"フクダ　リョウジ\"},\"salaryHistory\":[{\"startMonth\":\"\",\"endMonth\":\"\",\"basicSalary\":0,\"skillSalary\":0,\"employmentInsuranceNumber\":\"\",\"pensionNumber\":\"\",\"pensionBaseAmount\":0,\"healthInsuranceNumber\":\"\",\"remark\":\"\"}]},\"contractInfo\":{\"addressZip\":\"\",\"addressStreet\":\"\",\"addressDetails\":\"\",\"nearestStation\":\"\",\"phoneNumber\":\"\",\"email\":\"\",\"wechatId\":\"\",\"lineId\":\"\"},\"homeCountryInfo\":{\"homeCountryAddress\":\"\",\"emergencyContact\":\"\"},\"graduationInfo\":{\"highestEducation\":\"\",\"schoolName\":\"\",\"major\":\"\",\"graduationDate\":\"\"},\"workingInfo\":{\"workExperienceYears\":0,\"workHistory\":[{\"joinDate\":\"\",\"leaveDate\":\"\",\"companyName\":\"\",\"department\":\"\"}]},\"experienceInfo\":{\"experienceHistory\":[{\"startTime\":\"\",\"endTime\":\"\",\"projectName\":\"\",\"japaneseTarget\":true,\"workingPlace\":\"\",\"member\":0,\"industry\":\"\",\"codeEnviorment\":\"\",\"serverEnviorment\":\"\",\"programLanguage\":\"\",\"databases\":\"\",\"ide\":\"\",\"responsibility\":\"\",\"youken\":true,\"chousa\":true,\"kihon\":true,\"shousai\":true,\"coding\":true,\"tantai\":true,\"ketsugou\":true,\"sougou\":true,\"kousei\":true,\"hoshu\":true,\"remark\":\"\"}]}}\n"
	        		+ "";

	        // 执行POST请求
	        mockMvc.perform(post("/api/submit")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(jsonRequestBody));
	    }
}
