package com.example.myapp.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.myapp.dto.BasicInfoDTO;
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

}
