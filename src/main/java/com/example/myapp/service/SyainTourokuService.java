package com.example.myapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.dto.BasicInfoDTO;
import com.example.myapp.dto.BasicInfoDTO.EmployeeNameEnglish;
import com.example.myapp.dto.BasicInfoDTO.EmployeeNameKanji;
import com.example.myapp.dto.BasicInfoDTO.EmployeeNameKatakana;
import com.example.myapp.dto.ContractInfoDTO;
import com.example.myapp.dto.ExperienceInfoDTO;
import com.example.myapp.dto.ExperienceInfoDTO.ExperienceHistory;
import com.example.myapp.dto.GraduationInfoDTO;
import com.example.myapp.dto.HomeCountryInfoDTO;
import com.example.myapp.dto.KaishaInfoDTO;
import com.example.myapp.dto.PersonalInfoDTO;
import com.example.myapp.dto.SalaryInfoDTO;
import com.example.myapp.dto.SalaryInfoDTO.BankInfo;
import com.example.myapp.dto.SalaryInfoDTO.SalaryHistory;
import com.example.myapp.entity.SyainKeireki;
import com.example.myapp.entity.SyainKyuyo;
import com.example.myapp.entity.SyainMain;
import com.example.myapp.mapper.SyainKeirekiRepository;
import com.example.myapp.mapper.SyainKyuyoRepository;
import com.example.myapp.mapper.SyainMainRepository;
import com.example.myapp.mapper.SyainRirekiRepository;
import com.example.myapp.vo.SyainMainKyuyoKeirekiVO;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SyainTourokuService {
	
	private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	@Autowired
	private SyainMainRepository syainMainRepository;
	
	@Autowired
	private SyainRirekiRepository syainRirekiRepository;
	
	@Autowired
	private SyainKeirekiRepository syainKeirekiRepository;
	
	@Autowired
	private SyainKyuyoRepository syainKyuyoRepository;
	
	public SyainMainKyuyoKeirekiVO selectSyainBySyainId(int syainId) {
		SyainMainKyuyoKeirekiVO syainVO = new SyainMainKyuyoKeirekiVO();
		Optional<SyainMain> syainMain = syainMainRepository.findById(syainId);
		if (syainMain.isPresent()) {
			SyainMain existingSyainMain = syainMain.get();
			syainVO.setBasicInfo(convertSyainMainToBasicInfoDTO(existingSyainMain));
			syainVO.setPersonalInfo(convertSyainMainToPersonalInfoDTO(existingSyainMain));
			syainVO.setKaishaInfo(convertSyainMainToKaishaInfoDTO(existingSyainMain));
			syainVO.setContractInfo(convertSyainMainToContractInfoDTO(existingSyainMain));
			syainVO.setHomeCountryInfo(convertSyainMainToHomeCountryInfoDTO(existingSyainMain));
			syainVO.setGraduationInfo(convertSyainMainToGraduationInfoDTO(existingSyainMain));
			syainVO.setSalaryInfo(convertSyainMainToSalaryInfoDTO(existingSyainMain));
			syainVO.setExperienceInfo(convertSyainMainToExperienceInfoDTO(existingSyainMain));
		}
		return syainVO;
	}
	
	@Transactional
	public void saveSyainTouroku(SyainMain syainmain, 
			List<SyainKeireki> syainKeirekiList,
			List<SyainKyuyo> syainKyuyoList) {
		log.info("[社員メイン]");
		syainMainRepository.save(syainmain);
		for (SyainKeireki syainKeireki: syainKeirekiList) {
			syainKeirekiRepository.save(syainKeireki);
		}
		log.info("[社員経歴]");
		for (SyainKyuyo syainKyuyo: syainKyuyoList) {
			syainKyuyoRepository.save(syainKyuyo);
		}
		log.info("[社員給与]");
		syainRirekiRepository.count();
		log.info("[社員登録] すべての登録が完了");

	}
	
	@Transactional
	public void updateSyainTouroku(SyainMain syainMain,
			List<SyainKeireki> syainKeirekiList,
			List<SyainKyuyo> syainKyuyoList) {
		log.info("[更新　社員メイン]");
		Optional<SyainMain> existingSyainMain = syainMainRepository.findById(syainMain.getSyainId());
		if (existingSyainMain.isPresent()) {
			syainMainRepository.save(syainMain);
		} else {
			log.error("[不存在]");
		}
		log.info("[更新　社員経歴]");
		for (SyainKeireki syainKeireki: syainKeirekiList) {
			syainKeirekiRepository.save(syainKeireki);
		}
		log.info("[更新　社員給与]");
		for (SyainKyuyo syainKyuyo: syainKyuyoList) {
			syainKyuyoRepository.save(syainKyuyo);
		}
		log.info("[社員更新]　全ての更新が完了");
	}
	

	public SyainMain convertBasicInfoDTO(BasicInfoDTO basicInfoDTO) {
		SyainMain syainMain = new SyainMain();
		// 设置社員コード
		syainMain.setEmployeeCode(basicInfoDTO.getEmployeeCode());
		// 社員名（漢字）
		syainMain.setFirstNameKanji(basicInfoDTO.getNameKanji().getFirstName());
		syainMain.setLastNameKanji(basicInfoDTO.getNameKanji().getLastName());
		// 社員名（カタ）
		syainMain.setFirstNameKana(basicInfoDTO.getNameKatagana().getFirstName());
		syainMain.setLastNameKana(basicInfoDTO.getNameKatagana().getLastName());
		// 社員名（英語）
		syainMain.setFirstNameEigo(basicInfoDTO.getNameEnglish().getFirstName());
		syainMain.setLastNameEigo(basicInfoDTO.getNameEnglish().getLastName());
		// 性別
		syainMain.setSeibetu(basicInfoDTO.getGender());
		//　誕生日
		syainMain.setTanjyobi(parseStringToDate(basicInfoDTO.getBirthDate()));
		// 国籍
		syainMain.setKokuseki(basicInfoDTO.getNationallity());
		// 出身地
		syainMain.setSyussinn(basicInfoDTO.getPlaceOfBirth());
		// 配偶者
		syainMain.setHaigusya(basicInfoDTO.getSpousePresent());
		return syainMain;
	}
	
	/**
	 * 填充个人信息
	 * @param syainMain
	 * @param personalInfoDTO
	 * @return
	 */
	public SyainMain convertPersonalDTO(SyainMain syainMain, PersonalInfoDTO personalInfoDTO) {
		// パスポート番号
		syainMain.setPassportNum(personalInfoDTO.getPassportNumber());
		// パスポート有効日
		syainMain.setPassportEndDate(parseStringToDate(personalInfoDTO.getPassportExpiryDate()));
		// ビザ期間
		syainMain.setVisaKikan(personalInfoDTO.getVisaDuration());
		// ビザ有効日
		syainMain.setVisaEndDate(parseStringToDate(personalInfoDTO.getVisaExpiryDate()));
		// 在留資格
		syainMain.setZairyuNum(personalInfoDTO.getResidenceStatus());
		// マイナンバー
		syainMain.setKojinNum(personalInfoDTO.getMyNumber());
		// 在留番号
		syainMain.setZairyuNum(personalInfoDTO.getResidenceNumber());
		return syainMain;
	}
	
	/**
	 * 填充会社信息
	 * @param syainMain
	 * @param kaishaInfo
	 * @return
	 */
	public SyainMain convertKaishaDTO(SyainMain syainMain, KaishaInfoDTO kaishaInfo) {
		// 所属会社
		syainMain.setSyozokuKaisya(Integer.parseInt(kaishaInfo.getCompany()));
		// 入社日
		syainMain.setNyusyaDate(parseStringToDate(kaishaInfo.getJoinDate()));
		// 退社日
		syainMain.setTaisyaDate(parseStringToDate(kaishaInfo.getLeaveDate()));
		// 職業種類
		syainMain.setSyokugyoKind(Integer.parseInt(kaishaInfo.getOccupationType()));
		// 来日時期
		syainMain.setRainitiDate(parseStringToDate(kaishaInfo.getArrivalDateInJapan()));
		// 備考
		syainMain.setBikou(kaishaInfo.getRemarks());
		return syainMain;
	}
	
	/**
	 * 填充联络信息
	 * @param syainMain
	 * @param contractInfo
	 * @return
	 */
	public SyainMain convertContractDTO(SyainMain syainMain, ContractInfoDTO contractInfo) {
		// 日本の住所の
		syainMain.setYuubin(contractInfo.getAddressZip());
		// 日本の住所１
		syainMain.setJyusyo1(contractInfo.getAddressStreet());
		// 日本の住所２
		syainMain.setJyusyo2(contractInfo.getAddressDetails());
		// 最寄り駅
		syainMain.setMoyoriEki(contractInfo.getNearestStation());
		// 携帯電話
		syainMain.setTel(contractInfo.getPhoneNumber());
		// メールアドレス
		syainMain.setEmail(contractInfo.getEmail());
		// WECHAT
		syainMain.setWechat(contractInfo.getWechatId());
		// Line
		syainMain.setLine(contractInfo.getLineId());
		return syainMain;
	}
	
	/**
	 * 填充母国関連
	 * @param syainMain
	 * @param homecountryInfo
	 * @return
	 */
	public SyainMain convertHomeCountryDTO(SyainMain syainMain, HomeCountryInfoDTO homecountryInfo) {
		//　母国の住所
		syainMain.setBokokuJyusyo(homecountryInfo.getHomeCountryAddress());
		// 母国の緊急連絡先
		syainMain.setBokokuKinnkyuuRennraku(homecountryInfo.getEmergencyContact());
		return syainMain;
	}
	
	/**
	 * 填充卒業
	 * @param syainMain
	 * @param graduationInfo
	 * @return
	 */
	public SyainMain convertGraduationCountryDTO(SyainMain syainMain, GraduationInfoDTO graduationInfo) {
		// 最終学歴
		syainMain.setSaisyuuGakureki(Integer.parseInt(graduationInfo.getHighestEducation()));
		// 学校名
		syainMain.setGakkouName(graduationInfo.getSchoolName());
		// 専門名
		syainMain.setSennmomName(graduationInfo.getMajor());
		// 卒業年月日
		syainMain.setSotugyoDate(parseStringToDate(graduationInfo.getGraduationDate()));
		return syainMain;
	}
	
	/**
	 * 社員給与
	 * @param syainMain
	 * @param salaryInfoDTO
	 * @return
	 */
	public List<SyainKyuyo> convertSalaryInfoDTO(SyainMain syainMain, SalaryInfoDTO salaryInfoDTO) {
		// 填充银行信息
		BankInfo bankInfo = salaryInfoDTO.getBankInfo();
		// 金融機関コード
		syainMain.setKinyukikanCode(bankInfo.getBankCode());
		// 金融機関名
		syainMain.setKinyukikanName(bankInfo.getBankName());
		// 支店名コード
		syainMain.setSitenCode(bankInfo.getBranchCode());
		// 支店名
		syainMain.setSitenName(bankInfo.getBranchName());
		// 口座種類
		syainMain.setKouzaKind(1);
		//syainMain.setKouzaKind(Integer.parseInt(bankInfo.getAccountType()));
		// 口座番号
		syainMain.setKouzaNum(bankInfo.getAccountNumber());
		// 名義人
		syainMain.setMeigiName(bankInfo.getAccountHolderName());
		// SalaryHistory转换为SyainKyuyo
		List<SyainKyuyo> syainkyuyoList = new ArrayList<>();
		List<SalaryHistory> salaryHistoryList = salaryInfoDTO.getSalaryHistory();
		for (SalaryHistory salaryHistory : salaryHistoryList) {
			SyainKyuyo syainKyuyo = new SyainKyuyo();
			// 開始年月
			syainKyuyo.setKaishiNengetsu(salaryHistory.getStartMonth());
			// 終了年月
			syainKyuyo.setSyuryoNengetsu(salaryHistory.getEndMonth());
			// 基本給
			syainKyuyo.setKihonkyu(salaryHistory.getBasicSalary());
			// 職能給
			syainKyuyo.setSyokunokyu(salaryHistory.getSkillSalary());
			// 雇用保険番号
			syainKyuyo.setKokyouHokenNo(salaryHistory.getEmploymentInsuranceNumber());
			// 年金番号
			syainKyuyo.setNankinNo(salaryHistory.getPensionNumber());
			// 年金基準額
			syainKyuyo.setNankinKiJyunGaku(salaryHistory.getPensionBaseAmount());
			// 健康保険番号
			syainKyuyo.setKenkouHokenNo(salaryHistory.getHealthInsuranceNumber());
			// 備考
			syainKyuyo.setBikou(salaryHistory.getRemark());
			syainkyuyoList.add(syainKyuyo);
		}
		return syainkyuyoList;
	}
	
	/**
	 * 社員経歴
	 * @param experienceInfoDTO
	 * @return
	 */
	public List<SyainKeireki> convertExperienceInfoDTO(ExperienceInfoDTO experienceInfoDTO) {
		List<ExperienceHistory> experienceHistoryList = experienceInfoDTO.getExperienceHistory();
		List<SyainKeireki> syainKeirekiList = new ArrayList<>();
		for (ExperienceHistory experienceHistory : experienceHistoryList) {
			SyainKeireki syainKeireki = new SyainKeireki();
			// 開始日
			syainKeireki.setKaisibi(parseStringToDate(experienceHistory.getStartTime()));
			// 終了日
			syainKeireki.setSyuryobi(parseStringToDate(experienceHistory.getEndTime()));
			// プロジェクト名
			syainKeireki.setPjName(experienceHistory.getProjectName());
			// 対日かどうか
			syainKeireki.setTainitiFlag(experienceHistory.getJapaneseTarget()==true ? 1:0);
			// 開発場所
			syainKeireki.setBasyo(0);
			//syainKeireki.setBasyo(Integer.parseInt(experienceHistory.getWorkingPlace()));
			// 開発規模
			syainKeireki.setKibo(experienceHistory.getMember());
			// 開発業種
			syainKeireki.setBasyo(0);
			//syainKeireki.setGyosyu(Integer.parseInt(experienceHistory.getIndustry()));
			// 開発環境
			syainKeireki.setBasyo(0);
			//syainKeireki.setKaihatukankyo(Integer.parseInt(experienceHistory.getCodeEnviorment()));
			// 運用環境
			syainKeireki.setBasyo(0);
			//syainKeireki.setUnyoukankyo(Integer.parseInt(experienceHistory.getServerEnviorment()));
			// 言語
			syainKeireki.setGengo(experienceHistory.getProgramLanguage());
			// DB
			syainKeireki.setDb(experienceHistory.getDatabases());
			// IDE
			syainKeireki.setTool(experienceHistory.getIde());
			// 担当
			syainKeireki.setBasyo(0);
			//syainKeireki.setTantou(Integer.parseInt(experienceHistory.getResponsibility()));
			// 作業範囲
			syainKeireki.setSagyohani(parseBooleanToString(experienceHistory));
			// 
			syainKeireki.setGaiyou(experienceHistory.getRemark());
			syainKeirekiList.add(syainKeireki);
		}
		return syainKeirekiList;
	}
	
	public static String parseBooleanToString(ExperienceHistory experienceHistory) {
		StringBuffer buffer = new StringBuffer();
		//　要件定義
		buffer.append(experienceHistory.isYouken() ? "1" : "0");
		//　調査分析
		buffer.append(experienceHistory.isChousa() ? "1" : "0");
		//　基本設計
		buffer.append(experienceHistory.isKihon() ? "1" : "0");
		//　詳細設計
		buffer.append(experienceHistory.isShousai() ? "1" : "0");
		//　CD
		buffer.append(experienceHistory.isCoding() ? "1" : "0");
		//　単体試験
		buffer.append(experienceHistory.isTantai() ? "1" : "0");
		//　結合試験
		buffer.append(experienceHistory.isKetsugou() ? "1" : "0");
		//　総合試験
		buffer.append(experienceHistory.isSougou() ? "1" : "0");
		//　環境構築
		buffer.append(experienceHistory.isKousei() ? "1" : "0");
		//　運用保守
		buffer.append(experienceHistory.isHoshu() ? "1" : "0");
		return buffer.toString();
	}
	

    public static Date parseStringToDate(String dateString) {
        try {
            return formatter.parse(dateString);
        } catch (ParseException e) {
        	log.error("[error]，转换失败，输入为空");
            return new Date(); // 或者根据你的错误处理策略抛出一个异常
        }
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
		basicInfoDTO.setBirthDate(convertDateToDisplayForm(syainMain.getTanjyobi()));
		//　国籍
		basicInfoDTO.setNationallity(syainMain.getKokuseki());
		//　出身地
		basicInfoDTO.setPlaceOfBirth(syainMain.getSyussinn());
		//　配偶
		basicInfoDTO.setSpousePresent(syainMain.getHaigusya());
		return basicInfoDTO;
	}
    
    public PersonalInfoDTO convertSyainMainToPersonalInfoDTO(SyainMain syainMain) {
    	PersonalInfoDTO personalInfo = new PersonalInfoDTO();
    	// パスポート番号
    	personalInfo.setPassportNumber(syainMain.getPassportNum());
    	// パスポート有効日
    	personalInfo.setPassportExpiryDate(convertDateToDisplayForm(syainMain.getPassportEndDate()));
    	// ビザ期間
    	personalInfo.setVisaDuration(syainMain.getVisaKikan());
    	// ビザ有効日
    	personalInfo.setVisaExpiryDate(convertDateToDisplayForm(syainMain.getVisaEndDate()));
    	// 在留資格
    	personalInfo.setResidenceStatus(syainMain.getZairyuSikaku()+"");
    	// マイナンバー
    	personalInfo.setMyNumber(syainMain.getKojinNum());
    	// 在留番号
    	personalInfo.setResidenceNumber(syainMain.getZairyuNum());
    	return personalInfo;
    }
    
    public KaishaInfoDTO convertSyainMainToKaishaInfoDTO(SyainMain syainMain) {
    	KaishaInfoDTO kaishaInfo = new KaishaInfoDTO();
    	// 所属会社
    	kaishaInfo.setCompany(""+syainMain.getSyozokuKaisya());
    	// 入社日
    	kaishaInfo.setJoinDate(convertDateToDisplayForm(syainMain.getNyusyaDate()));
    	// 退社日
    	kaishaInfo.setLeaveDate(convertDateToDisplayForm(syainMain.getTaisyaDate()));
    	// 職業種類
    	kaishaInfo.setOccupationType(""+syainMain.getSyokugyoKind());
    	// 来日時期
    	kaishaInfo.setArrivalDateInJapan(convertDateToDisplayForm(syainMain.getRainitiDate()));
    	// 備考
    	kaishaInfo.setRemarks(syainMain.getBikou());
    	return kaishaInfo;
    }
    
    public ContractInfoDTO convertSyainMainToContractInfoDTO(SyainMain syainMain) {
    	ContractInfoDTO contractInfo = new ContractInfoDTO();
    	// 日本の郵
    	contractInfo.setAddressZip(syainMain.getYuubin());
    	// 日本の住所１
    	contractInfo.setAddressStreet(syainMain.getJyusyo1());
    	// 日本の住所２
    	contractInfo.setAddressDetails(syainMain.getJyusyo2());
    	// 最寄り駅
    	contractInfo.setNearestStation(syainMain.getMoyoriEki());
    	// 携帯電話
    	contractInfo.setPhoneNumber(syainMain.getTel());
    	// メールアドレス
    	contractInfo.setEmail(syainMain.getEmail());
    	// WECHAT
    	contractInfo.setWechatId(syainMain.getWechat());
    	// Line
    	contractInfo.setLineId(syainMain.getLine());
    	return contractInfo;
    }
    
    public HomeCountryInfoDTO convertSyainMainToHomeCountryInfoDTO(SyainMain syainMain) {
    	HomeCountryInfoDTO homeCountryInfo = new HomeCountryInfoDTO();
    	// 母国の住所
    	homeCountryInfo.setHomeCountryAddress(syainMain.getBokokuJyusyo());
    	// 母国の緊急連絡先
    	homeCountryInfo.setEmergencyContact(syainMain.getBokokuKinnkyuuRennraku());
    	return homeCountryInfo;
    }
    
    public GraduationInfoDTO convertSyainMainToGraduationInfoDTO(SyainMain syainMain) {
    	GraduationInfoDTO graduationInfo = new GraduationInfoDTO();
    	//　最終学歴
    	graduationInfo.setHighestEducation(""+syainMain.getSaisyuuGakureki());
    	//　学校名
    	graduationInfo.setSchoolName(syainMain.getGakkouName());
    	//　専門名
    	graduationInfo.setMajor(syainMain.getSennmomName());
    	// 　卒業年月日
    	graduationInfo.setGraduationDate(convertDateToDisplayForm(syainMain.getSotugyoDate()));
    	return graduationInfo;
    }
    
    public SalaryInfoDTO convertSyainMainToSalaryInfoDTO(SyainMain syainMain) {
    	SalaryInfoDTO salaryInfo = new SalaryInfoDTO();
    	BankInfo bankInfo = new BankInfo();
    	// 金融機関コード
    	bankInfo.setBankCode(syainMain.getKinyukikanCode());
    	// 金融機関名
    	bankInfo.setBankName(syainMain.getKinyukikanName());
    	// 支店コード
    	bankInfo.setBranchCode(syainMain.getSitenCode());
    	// 支店名
    	bankInfo.setBranchName(syainMain.getSitenName());
    	// 口座種類
    	bankInfo.setAccountType(syainMain.getKouzaKind().toString());
    	// 口座番号
    	bankInfo.setAccountNumber(syainMain.getKouzaNum());
    	// 名義人
    	bankInfo.setAccountHolderName(syainMain.getMeigiName());
    	// bankInfo
    	salaryInfo.setBankInfo(bankInfo);
    	// syainId
    	int syainId = syainMain.getSyainId();
    	List<SyainKyuyo> syainKyuyoList = syainKyuyoRepository.findBySyainId(syainId);
    	List<SalaryHistory> salaryHistoryList = new ArrayList<>(syainKyuyoList.size());
    	for (SyainKyuyo syainKyuyo : syainKyuyoList) {
    		SalaryHistory salaryHistory = new SalaryHistory();
    		// 開始年月
    		salaryHistory.setStartMonth(syainKyuyo.getKaishiNengetsu());
    		// 終了年月
    		salaryHistory.setEndMonth(syainKyuyo.getSyuryoNengetsu());
    		// 基本給
    		salaryHistory.setBasicSalary(syainKyuyo.getKihonkyu());
    		// 職能給
    		salaryHistory.setSkillSalary(syainKyuyo.getSyokunokyu());
    		// 雇用保険番号
    		salaryHistory.setEmploymentInsuranceNumber(syainKyuyo.getKokyouHokenNo());
    		// 年金番号
    		salaryHistory.setPensionNumber(syainKyuyo.getNankinNo());
    		// 年金基準
    		salaryHistory.setPensionBaseAmount(syainKyuyo.getNankinKiJyunGaku());
    		// 健康保険番号
    		salaryHistory.setHealthInsuranceNumber(syainKyuyo.getKenkouHokenNo());
    		// 備考
    		salaryHistory.setRemark(syainKyuyo.getBikou());
    		salaryHistoryList.add(salaryHistory);
    	}
    	return salaryInfo;
    }
    
    public ExperienceInfoDTO convertSyainMainToExperienceInfoDTO(SyainMain syainMain) {
    	int syainId = syainMain.getSyainId();
    	List<SyainKeireki> syainKeirekiList = syainKeirekiRepository.findBySyainId(syainId);
    	ExperienceInfoDTO experienceInfo = new ExperienceInfoDTO();
    	List<ExperienceHistory> experienceHistoryList = new ArrayList<>();
    	for (SyainKeireki syainKeireki : syainKeirekiList) {
    		ExperienceHistory experienceHistory = new ExperienceHistory();
    		experienceHistory.setStartTime(convertDateToDisplayForm(syainKeireki.getKaisibi()));
    		experienceHistoryList.add(experienceHistory);
    	}
    	return experienceInfo;

    }
     
    public static String convertDateToDisplayForm(Date date) {
    	// 转换 java.util.Date 到 java.time.LocalDate
    	if (date == null) {
    		return "2020-01-01";
    	}
    	LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

    	// 使用 DateTimeFormatter 格式化 LocalDate
    	String formattedDate = localDate.format(DateTimeFormatter.ISO_LOCAL_DATE); // 格式为 YYYY-MM-DD
    	return formattedDate;

    }
}
