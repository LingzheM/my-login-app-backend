package com.example.myapp.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "TORIHIKISAKI_MAIN")
public class CustomerInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TORIHIKI_ID", nullable = false)
    private Integer torihikiId;

    @Column(name = "TORIHIKI_NAME_ALL", nullable = false, length = 50)
    private String torihikiNameAll;

    @Column(name = "TORIHIKI_NAME_RYAKU", nullable = false, length = 30)
    private String torihikiNameRyaku;

    @Column(name = "YUUBIN", nullable = false, length = 8)
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

    @Column(name = "SEIKYUSYO_KUBUN_1")
    private Integer seikyusyoKubun1;

    @Column(name = "SEIKYUSYO_KUBUN_2")
    private Integer seikyusyoKubun2;

    @Column(name = "SEIKYUSYO_KUBUN_3")
    private Integer seikyusyoKubun3;

    @Column(name = "SEIKYUSYO_KUBUN_4")
    private Integer seikyusyoKubun4;

    @Column(name = "SEIKYUSYO_KUBUN_5")
    private Integer seikyusyoKubun5;

    @Column(name = "SEIKYUSYO_KUBUN_6")
    private Integer seikyusyoKubun6;

    @Column(name = "SEIKYUSYO_KUBUN_7", length = 255)
    private String seikyusyoKubun7;

    @Column(name = "SEIKYUSYO_KUBUN_8", length = 255)
    private String seikyusyoKubun8;

    @Column(name = "SEIKYUSYO_KUBUN_9", length = 255)
    private String seikyusyoKubun9;

    @Column(name = "SEIKYUSYO_KUBUN_10", length = 255)
    private String seikyusyoKubun10;

    @Column(name = "SEIKYUSYO_KUBUN_11", length = 255)
    private String seikyusyoKubun11;

    @Column(name = "HONSYA")
    private Integer honsya;

    @Column(name = "HONSYA_KOUZA")
    private Integer honsyaKouza;

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

    @Column(name = "TOUROKUBI")
    @Temporal(TemporalType.TIMESTAMP)
    private Date torokubi;

    @Column(name = "KOUSINNBI")
    @Temporal(TemporalType.TIMESTAMP)
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

	public Integer getSeikyusyoKubun1() {
		return seikyusyoKubun1;
	}

	public void setSeikyusyoKubun1(Integer seikyusyoKubun1) {
		this.seikyusyoKubun1 = seikyusyoKubun1;
	}

	public Integer getSeikyusyoKubun2() {
		return seikyusyoKubun2;
	}

	public void setSeikyusyoKubun2(Integer seikyusyoKubun2) {
		this.seikyusyoKubun2 = seikyusyoKubun2;
	}

	public Integer getSeikyusyoKubun3() {
		return seikyusyoKubun3;
	}

	public void setSeikyusyoKubun3(Integer seikyusyoKubun3) {
		this.seikyusyoKubun3 = seikyusyoKubun3;
	}

	public Integer getSeikyusyoKubun4() {
		return seikyusyoKubun4;
	}

	public void setSeikyusyoKubun4(Integer seikyusyoKubun4) {
		this.seikyusyoKubun4 = seikyusyoKubun4;
	}

	public Integer getSeikyusyoKubun5() {
		return seikyusyoKubun5;
	}

	public void setSeikyusyoKubun5(Integer seikyusyoKubun5) {
		this.seikyusyoKubun5 = seikyusyoKubun5;
	}

	public Integer getSeikyusyoKubun6() {
		return seikyusyoKubun6;
	}

	public void setSeikyusyoKubun6(Integer seikyusyoKubun6) {
		this.seikyusyoKubun6 = seikyusyoKubun6;
	}

	public String getSeikyusyoKubun7() {
		return seikyusyoKubun7;
	}

	public void setSeikyusyoKubun7(String seikyusyoKubun7) {
		this.seikyusyoKubun7 = seikyusyoKubun7;
	}

	public String getSeikyusyoKubun8() {
		return seikyusyoKubun8;
	}

	public void setSeikyusyoKubun8(String seikyusyoKubun8) {
		this.seikyusyoKubun8 = seikyusyoKubun8;
	}

	public String getSeikyusyoKubun9() {
		return seikyusyoKubun9;
	}

	public void setSeikyusyoKubun9(String seikyusyoKubun9) {
		this.seikyusyoKubun9 = seikyusyoKubun9;
	}

	public String getSeikyusyoKubun10() {
		return seikyusyoKubun10;
	}

	public void setSeikyusyoKubun10(String seikyusyoKubun10) {
		this.seikyusyoKubun10 = seikyusyoKubun10;
	}

	public String getSeikyusyoKubun11() {
		return seikyusyoKubun11;
	}

	public void setSeikyusyoKubun11(String seikyusyoKubun11) {
		this.seikyusyoKubun11 = seikyusyoKubun11;
	}

	public Integer getHonsya() {
		return honsya;
	}

	public void setHonsya(Integer honsya) {
		this.honsya = honsya;
	}

	public Integer getHonsyaKouza() {
		return honsyaKouza;
	}

	public void setHonsyaKouza(Integer honsyaKouza) {
		this.honsyaKouza = honsyaKouza;
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

  
	@PrePersist
    protected void onCreate() {
        this.torokubi = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.kousinnbi = new Date();
    }

}
