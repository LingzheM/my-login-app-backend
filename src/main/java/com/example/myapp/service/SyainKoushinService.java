package com.example.myapp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.dto.BasicInfoDTO;
import com.example.myapp.dto.BasicInfoDTO.EmployeeNameEnglish;
import com.example.myapp.dto.BasicInfoDTO.EmployeeNameKanji;
import com.example.myapp.dto.BasicInfoDTO.EmployeeNameKatakana;
import com.example.myapp.entity.SyainMain;
import com.example.myapp.mapper.SyainKeirekiRepository;
import com.example.myapp.mapper.SyainKyuyoRepository;
import com.example.myapp.mapper.SyainMainRepository;
import com.example.myapp.vo.SyainMainKyuyoKeirekiVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SyainKoushinService {
	
	@Autowired
	private SyainMainRepository syainMainRepository;
	
	@Autowired
	private SyainKyuyoRepository syainKyuyoRepository;
	
	@Autowired
	private SyainKeirekiRepository syainKeirekiRepository;
	
	
	public SyainMainKyuyoKeirekiVO selectSyainBySyainId(Integer syainId) {
		SyainMainKyuyoKeirekiVO syainVO = new SyainMainKyuyoKeirekiVO();
		Optional<SyainMain> syainMain = syainMainRepository.findById(syainId);
		// 设置BasicInfo
		syainVO.setBasicInfo(convertSyainMainToBasicInfoDTO(syainMain.get()));
		return syainVO;
	}
	
	
	public BasicInfoDTO convertSyainMainToBasicInfoDTO(SyainMain syainMain) {
		BasicInfoDTO basicInfoDTO = new BasicInfoDTO();
		// 社員コード
		basicInfoDTO.setEmployeeCode(syainMain.getEmployeeCode());
		//　社員名漢字
		basicInfoDTO.setNameKanji(new EmployeeNameKanji(syainMain.getFirstNameKanji(), syainMain.getLastNameKanji()));
		//　社員名カタ
		basicInfoDTO.setNameKatagana(new EmployeeNameKatakana(syainMain.getFirstNameKana(), syainMain.getLastNameKana()));
		//　社員名英語
		basicInfoDTO.setNameEnglish(new EmployeeNameEnglish(syainMain.getFirstNameEigo(), syainMain.getLastNameEigo()));
		// 性別
		basicInfoDTO.setGender(syainMain.getSeibetu());
		//　誕生日
		basicInfoDTO.setBirthDate(syainMain.getTanjyobi().toString());
		//　国籍
		basicInfoDTO.setNationallity(syainMain.getKokuseki());
		//　出身地
		basicInfoDTO.setPlaceOfBirth(syainMain.getSyussinn());
		//　配偶
		basicInfoDTO.setSpousePresent(syainMain.getHaigusya());
		return basicInfoDTO;
	}

}
