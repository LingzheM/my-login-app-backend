package com.example.myapp.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TORIHIKISAKI_MAIN")
public class CustomerInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TORIHIKI_ID")
    private Integer torihikiId;

    @Column(name = "TORIHIKI_NAME_ALL", nullable = false, length = 50)
    private String torihikiNameAll;

    @Column(name = "TORIHIKI_NAME_RYAKU", nullable = false, length = 30)
    private String torihikiNameRyaku;

    @Column(name = "YUUBIN", nullable = false, length = 8, columnDefinition = "CHAR(8) DEFAULT '169-0075'")
    private String yuubin;

    @Column(name = "JYUSYO_1", nullable = false, length = 100)
    private String jyusyo1;

    @Column(name = "JYUSYO_2", length = 100)
    private String jyusyo2;

    @Column(name = "TEL", length = 15)
    private String tel;

    @Column(name = "FAX", length = 15)
    private String fax;

    @Column(name = "URL", length = 100)
    private String url;

    @Column(name = "BIKOU", length = 255)
    private String bikou;

    @Column(name = "DELETE_FLAG", nullable = false)
    private Integer deleteFlag;

    // ... other fields ...

    @Column(name = "KOUZA_KIND")
    private Integer kouzaKind;

    @Column(name = "KOUZA_NUM", length = 10)
    private String kouzaNum;

    @Column(name = "MEIGI_NAME", length = 50)
    private String meigiName;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TOUROKUBI")
    private Date tourokubi;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "KOUSINNBI")
    private Date kousinnbi;

	public Integer getTorihikiId() {
		return torihikiId;
	}

	public void setTorihikiId(Integer torihikiId) {
		this.torihikiId = torihikiId;
	}

	public String getTorihikiNameAll() {
		return torihikiNameAll;
	}

	public void setTorihikiNameAll(String torihikiNameAll) {
		this.torihikiNameAll = torihikiNameAll;
	}

	public String getTorihikiNameRyaku() {
		return torihikiNameRyaku;
	}

	public void setTorihikiNameRyaku(String torihikiNameRyaku) {
		this.torihikiNameRyaku = torihikiNameRyaku;
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

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBikou() {
		return bikou;
	}

	public void setBikou(String bikou) {
		this.bikou = bikou;
	}

	public Integer getDeleteFlag() {
		return deleteFlag;
	}

	public void setDeleteFlag(Integer deleteFlag) {
		this.deleteFlag = deleteFlag;
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

	public Date getTourokubi() {
		return tourokubi;
	}

	public void setTourokubi(Date tourokubi) {
		this.tourokubi = tourokubi;
	}

	public Date getKousinnbi() {
		return kousinnbi;
	}

	public void setKousinnbi(Date kousinnbi) {
		this.kousinnbi = kousinnbi;
	}

    
}
