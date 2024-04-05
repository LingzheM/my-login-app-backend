package com.example.myapp.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SYAIN_RIREKI")
public class SyainRireki {
	
	@Id
    @Column(name = "SYAIN_ID")
	private int syainId;
	
	@Column(name = "KAISIBI")
	private Date kaisibi;
	
	@Column(name = "SYURYOBI")
	private Date syuryobi;
	
	@Column(name = "TOUROKUBI")
	private Date tourokubi;
	
	@Column(name = "KOUSINNBI")
	private Date kousinnbi;
	
	@Column(name = "PJ_NAME")
	private String pjName;
	
	@Column(name = "TAINTI_FLAG")
	private int tainitiFlag;
	
	@Column(name = "BASYO")
	private int basyo;
	
	@Column(name = "KIBO")
	private int kibo;
	
	@Column(name = "GYOSYU")
	private int gyosyu;
	
	@Column(name = "KAIHATUKANKYO")
	private int kaihatukankyo;
	
	@Column(name = "UNYOUKANKYO")
	private int unyoukankyo;
	
	@Column(name = "GENGO")
	private String gengo;
	
	@Column(name = "DB")
	private String db;
	
	@Column(name = "TOOL")
	private String tool;
	
	@Column(name = "TANTOU")
	private int tantou;
	
	@Column(name = "SAGYOHANI")
	private int sagyohani;
	
	@Column(name ="GAIYOU")
	private String gaiyou;
	

	public int getSyainId() {
		return syainId;
	}

	public void setSyainId(int syainId) {
		this.syainId = syainId;
	}

	public Date getKaisibi() {
		return kaisibi;
	}

	public void setKaisibi(Date kaisibi) {
		this.kaisibi = kaisibi;
	}

	public Date getSyuryobi() {
		return syuryobi;
	}

	public void setSyuryobi(Date syuryobi) {
		this.syuryobi = syuryobi;
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

	public String getPjName() {
		return pjName;
	}

	public void setPjName(String pjName) {
		this.pjName = pjName;
	}

	public int getTainitiFlag() {
		return tainitiFlag;
	}

	public void setTainitiFlag(int tainitiFlag) {
		this.tainitiFlag = tainitiFlag;
	}

	public int getBasyo() {
		return basyo;
	}

	public void setBasyo(int basyo) {
		this.basyo = basyo;
	}

	public int getKibo() {
		return kibo;
	}

	public void setKibo(int kibo) {
		this.kibo = kibo;
	}

	public int getGyosyu() {
		return gyosyu;
	}

	public void setGyosyu(int gyosyu) {
		this.gyosyu = gyosyu;
	}

	public int getKaihatukankyo() {
		return kaihatukankyo;
	}

	public void setKaihatukankyo(int kaihatukankyo) {
		this.kaihatukankyo = kaihatukankyo;
	}

	public int getUnyoukankyo() {
		return unyoukankyo;
	}

	public void setUnyoukankyo(int unyoukankyo) {
		this.unyoukankyo = unyoukankyo;
	}

	public String getGengo() {
		return gengo;
	}

	public void setGengo(String gengo) {
		this.gengo = gengo;
	}

	public String getDb() {
		return db;
	}

	public void setDb(String db) {
		this.db = db;
	}

	public String getTool() {
		return tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public int getTantou() {
		return tantou;
	}

	public void setTantou(int tantou) {
		this.tantou = tantou;
	}

	public int getSagyohani() {
		return sagyohani;
	}

	public void setSagyohani(int sagyohani) {
		this.sagyohani = sagyohani;
	}

	public String getGaiyou() {
		return gaiyou;
	}

	public void setGaiyou(String gaiyou) {
		this.gaiyou = gaiyou;
	}
	
	
	
}
