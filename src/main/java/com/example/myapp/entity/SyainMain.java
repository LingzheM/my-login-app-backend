package com.example.myapp.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SYAIN_MAIN")
public class SyainMain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SYAIN_ID")
    private int syainId;

    @Column(name = "FIRST_NAME_KANJI", nullable = false, length = 15)
    private String firstNameKanji;

    @Column(name = "LAST_NAME_KANJI", nullable = false, length = 15)
    private String lastNameKanji;

    @Column(name = "FIRST_NAME_KANA", nullable = false, length = 15)
    private String firstNameKana;

    @Column(name = "LAST_NAME_KANA", nullable = false, length = 15)
    private String lastNameKana;

    @Column(name = "FIRST_NAME_EIGO", nullable = false, length = 15)
    private String firstNameEigo;

    @Column(name = "LAST_NAME_EIGO", nullable = false, length = 15)
    private String lastNameEigo;

    @Column(name = "SEIBETU", length = 11)
    private Integer seibetu;

    @Column(name = "TANJYOBI")
    private Date tanjyobi;

    @Column(name = "KOKUSEKI", length = 11)
    private Integer kokuseki;

    @Column(name = "SYUSSINN", length = 30)
    private String syussinn;

    @Column(name = "HAIGUSYA", nullable = false, length = 11)
    private int haigusya;

    @Column(name = "PASSPORT_NUM", length = 20)
    private String passportNum;

    @Column(name = "PASSPORT_END_DATE")
    private Date passportEndDate;

    @Column(name = "VISA_KIKAN", length = 11)
    private Integer visaKikan;

    @Column(name = "VISA_END_DATE")
    private Date visaEndDate;

    @Column(name = "ZAIRYU_SIKAKU", length = 11)
    private Integer zairyuSikaku;

    @Column(name = "KOJIN_NUM", length = 20)
    private String kojinNum;

    @Column(name = "ZAIRYU_NUM", length = 20)
    private String zairyuNum;

    @Column(name = "SYOZOKU_KAISYA", nullable = false, length = 11)
    private int syozokuKaisya;

    @Column(name = "NYUUSYA_DATE")
    private Date nyusyaDate;

    @Column(name = "TAISYA_DATE")
    private Date taisyaDate;

    @Column(name = "SYOKUGYO_KIND", nullable = false, length = 11)
    private int syokugyoKind;

    @Column(name = "RAINITI_DATE")
    private Date rainitiDate;

    @Column(name = "BIKOU", length = 255)
    private String bikou;

    @Column(name = "YUUBIN", length = 8)
    private String yuubin;

    @Column(name = "JYUSYO_1", length = 100)
    private String jyusyo1;

    @Column(name = "JYUSYO_2", length = 100)
    private String jyusyo2;

    @Column(name = "MOYORI_EKI", length = 30)
    private String moyoriEki;

    @Column(name = "TEL", length = 15)
    private String tel;

    @Column(name = "EMAIL", length = 50)
    private String email;

    @Column(name = "WECHAT", length = 30)
    private String wechat;

    @Column(name = "LINE", length = 30)
    private String line;

    @Column(name = "BOKOKU_JYUSYO", length = 255)
    private String bokokuJyusyo;

    @Column(name = "BOKOKU_KINNKYUU_RENNRAKU", length = 255)
    private String bokokuKinnkyuuRennraku;

    @Column(name = "SAISYUU_GAKUREKI", nullable = false, length = 11)
    private int saisyuuGakureki;

    @Column(name = "GAKKOU_NAME", length = 100)
    private String gakkouName;

    @Column(name = "SENNMOM_NAME", length = 100)
    private String sennmomName;

    @Column(name = "SOTUGYO_DATE")
    private Date sotugyoDate;

    @Column(name = "GYUMU_NENSU")
    private Float gyumuNensu;

    @Column(name = "IT_OS", length = 100)
    private String itOs;

    @Column(name = "IT_GENGO", length = 100)
    private String itGengo;

    @Column(name = "IT_DB", length = 100)
    private String itDb;

    @Column(name = "IT_WEB_SERVER", length = 100)
    private String itWebServer;

    @Column(name = "IT_FW", length = 100)
    private String itFw;

    @Column(name = "IT_OTHER", length = 100)
    private String itOther;

    @Column(name = "IT_BIKOU", length = 1024)
    private String itBikou;
    
    @Column(name = "KINYUKIKAN_CODE", length = 10)
    private String kinyukikanCode;

    @Column(name = "KINYUKIKAN_NAME", length = 50)
    private String kinyukikanName;

    @Column(name = "SITEN_CODE", length = 10)
    private String sitenCode;

    @Column(name = "SITEN_NAME", length = 50)
    private String sitenName;

    @Column(name = "KOUZA_KIND")
    private Integer kouzaKind;

    @Column(name = "KOUZA_NUM", length = 10)
    private String kouzaNum;

    @Column(name = "MEIGI_NAME", length = 50)
    private String meigiName;

    @Column(name = "DELETE_FLAG", nullable = false, length = 11)
    private int deleteFlag;
    
    @Column(name = "EMPLOYEECODE", length = 30)
    private String employeeCode;

    @Column(name = "TOUROKUBI")
    private Date torokubi;

    @Column(name = "KOUSINNBI")
    private Date kousinnbi;

	public int getSyainId() {
		return syainId;
	}

	public void setSyainId(int syainId) {
		this.syainId = syainId;
	}

	public String getFirstNameKanji() {
		return firstNameKanji;
	}

	public void setFirstNameKanji(String firstNameKanji) {
		this.firstNameKanji = firstNameKanji;
	}

	public String getLastNameKanji() {
		return lastNameKanji;
	}

	public void setLastNameKanji(String lastNameKanji) {
		this.lastNameKanji = lastNameKanji;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}

	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana = firstNameKana;
	}

	public String getLastNameKana() {
		return lastNameKana;
	}

	public void setLastNameKana(String lastNameKana) {
		this.lastNameKana = lastNameKana;
	}

	public String getFirstNameEigo() {
		return firstNameEigo;
	}

	public void setFirstNameEigo(String firstNameEigo) {
		this.firstNameEigo = firstNameEigo;
	}

	public String getLastNameEigo() {
		return lastNameEigo;
	}

	public void setLastNameEigo(String lastNameEigo) {
		this.lastNameEigo = lastNameEigo;
	}

	public Integer getSeibetu() {
		return seibetu;
	}

	public void setSeibetu(Integer seibetu) {
		this.seibetu = seibetu;
	}

	public Date getTanjyobi() {
		return tanjyobi;
	}

	public void setTanjyobi(Date tanjyobi) {
		this.tanjyobi = tanjyobi;
	}

	public Integer getKokuseki() {
		return kokuseki;
	}

	public void setKokuseki(Integer kokuseki) {
		this.kokuseki = kokuseki;
	}

	public String getSyussinn() {
		return syussinn;
	}

	public void setSyussinn(String syussinn) {
		this.syussinn = syussinn;
	}

	public int getHaigusya() {
		return haigusya;
	}

	public void setHaigusya(int haigusya) {
		this.haigusya = haigusya;
	}

	public String getPassportNum() {
		return passportNum;
	}

	public void setPassportNum(String passportNum) {
		this.passportNum = passportNum;
	}

	public Date getPassportEndDate() {
		return passportEndDate;
	}

	public void setPassportEndDate(Date passportEndDate) {
		this.passportEndDate = passportEndDate;
	}

	public Integer getVisaKikan() {
		return visaKikan;
	}

	public void setVisaKikan(Integer visaKikan) {
		this.visaKikan = visaKikan;
	}

	public Date getVisaEndDate() {
		return visaEndDate;
	}

	public void setVisaEndDate(Date visaEndDate) {
		this.visaEndDate = visaEndDate;
	}

	public Integer getZairyuSikaku() {
		return zairyuSikaku;
	}

	public void setZairyuSikaku(Integer zairyuSikaku) {
		this.zairyuSikaku = zairyuSikaku;
	}

	public String getKojinNum() {
		return kojinNum;
	}

	public void setKojinNum(String kojinNum) {
		this.kojinNum = kojinNum;
	}

	public String getZairyuNum() {
		return zairyuNum;
	}

	public void setZairyuNum(String zairyuNum) {
		this.zairyuNum = zairyuNum;
	}

	public int getSyozokuKaisya() {
		return syozokuKaisya;
	}

	public void setSyozokuKaisya(int syozokuKaisya) {
		this.syozokuKaisya = syozokuKaisya;
	}

	public Date getNyusyaDate() {
		return nyusyaDate;
	}

	public void setNyusyaDate(Date nyusyaDate) {
		this.nyusyaDate = nyusyaDate;
	}

	public Date getTaisyaDate() {
		return taisyaDate;
	}

	public void setTaisyaDate(Date taisyaDate) {
		this.taisyaDate = taisyaDate;
	}

	public int getSyokugyoKind() {
		return syokugyoKind;
	}

	public void setSyokugyoKind(int syokugyoKind) {
		this.syokugyoKind = syokugyoKind;
	}

	public Date getRainitiDate() {
		return rainitiDate;
	}

	public void setRainitiDate(Date rainitiDate) {
		this.rainitiDate = rainitiDate;
	}

	public String getBikou() {
		return bikou;
	}

	public void setBikou(String bikou) {
		this.bikou = bikou;
	}

	public String getYuubin() {
		return yuubin;
	}

	public void setYuubin(String yuubin) {
		this.yuubin = yuubin;
	}

	public String getJyusyo1() {
		return jyusyo1;
	}

	public void setJyusyo1(String jyusyo1) {
		this.jyusyo1 = jyusyo1;
	}

	public String getJyusyo2() {
		return jyusyo2;
	}

	public void setJyusyo2(String jyusyo2) {
		this.jyusyo2 = jyusyo2;
	}

	public String getMoyoriEki() {
		return moyoriEki;
	}

	public void setMoyoriEki(String moyoriEki) {
		this.moyoriEki = moyoriEki;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getLine() {
		return line;
	}

	public void setLine(String line) {
		this.line = line;
	}

	public String getBokokuJyusyo() {
		return bokokuJyusyo;
	}

	public void setBokokuJyusyo(String bokokuJyusyo) {
		this.bokokuJyusyo = bokokuJyusyo;
	}

	public String getBokokuKinnkyuuRennraku() {
		return bokokuKinnkyuuRennraku;
	}

	public void setBokokuKinnkyuuRennraku(String bokokuKinnkyuuRennraku) {
		this.bokokuKinnkyuuRennraku = bokokuKinnkyuuRennraku;
	}

	public int getSaisyuuGakureki() {
		return saisyuuGakureki;
	}

	public void setSaisyuuGakureki(int saisyuuGakureki) {
		this.saisyuuGakureki = saisyuuGakureki;
	}

	public String getGakkouName() {
		return gakkouName;
	}

	public void setGakkouName(String gakkouName) {
		this.gakkouName = gakkouName;
	}

	public String getSennmomName() {
		return sennmomName;
	}

	public void setSennmomName(String sennmomName) {
		this.sennmomName = sennmomName;
	}

	public Date getSotugyoDate() {
		return sotugyoDate;
	}

	public void setSotugyoDate(Date sotugyoDate) {
		this.sotugyoDate = sotugyoDate;
	}

	public Float getGyumuNensu() {
		return gyumuNensu;
	}

	public void setGyumuNensu(Float gyumuNensu) {
		this.gyumuNensu = gyumuNensu;
	}

	public String getItOs() {
		return itOs;
	}

	public void setItOs(String itOs) {
		this.itOs = itOs;
	}

	public String getItGengo() {
		return itGengo;
	}

	public void setItGengo(String itGengo) {
		this.itGengo = itGengo;
	}

	public String getItDb() {
		return itDb;
	}

	public void setItDb(String itDb) {
		this.itDb = itDb;
	}

	public String getItWebServer() {
		return itWebServer;
	}

	public void setItWebServer(String itWebServer) {
		this.itWebServer = itWebServer;
	}

	public String getItFw() {
		return itFw;
	}

	public void setItFw(String itFw) {
		this.itFw = itFw;
	}

	public String getItOther() {
		return itOther;
	}

	public void setItOther(String itOther) {
		this.itOther = itOther;
	}

	public String getItBikou() {
		return itBikou;
	}

	public void setItBikou(String itBikou) {
		this.itBikou = itBikou;
	}

	public int getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(int deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

	public Date getTorokubi() {
		return torokubi;
	}

	public void setTorokubi(Date torokubi) {
		this.torokubi = torokubi;
	}

	public Date getKousinnbi() {
		return kousinnbi;
	}

	public void setKousinnbi(Date kousinnbi) {
		this.kousinnbi = kousinnbi;
	}

	public String getEmployeeCode() {
		return employeeCode;
	}

	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}

	public String getKinyukikanCode() {
		return kinyukikanCode;
	}

	public void setKinyukikanCode(String kinyukikanCode) {
		this.kinyukikanCode = kinyukikanCode;
	}

	public String getKinyukikanName() {
		return kinyukikanName;
	}

	public void setKinyukikanName(String kinyukikanName) {
		this.kinyukikanName = kinyukikanName;
	}

	public String getSitenCode() {
		return sitenCode;
	}

	public void setSitenCode(String sitenCode) {
		this.sitenCode = sitenCode;
	}

	public String getSitenName() {
		return sitenName;
	}

	public void setSitenName(String sitenName) {
		this.sitenName = sitenName;
	}

	public Integer getKouzaKind() {
		return kouzaKind;
	}

	public void setKouzaKind(Integer kouzaKind) {
		this.kouzaKind = kouzaKind;
	}

	public String getKouzaNum() {
		return kouzaNum;
	}

	public void setKouzaNum(String kouzaNum) {
		this.kouzaNum = kouzaNum;
	}

	public String getMeigiName() {
		return meigiName;
	}

	public void setMeigiName(String meigiName) {
		this.meigiName = meigiName;
	}
	
	

}
