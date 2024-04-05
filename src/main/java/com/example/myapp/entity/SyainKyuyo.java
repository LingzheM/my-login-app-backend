package com.example.myapp.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "SYAIN_KYUYO")
public class SyainKyuyo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SYAIN_ID")
	private int syainId;
	
	@Column(name = "KAISHI_NENGETSU")
	private String kaishiNengetsu;
	
	@Column(name = "SYURYO_NENGETSU")
	private String syuryoNengetsu;
	
	@Column(name = "KIHONKYU")
	private int kihonkyu;
	
	@Column(name = "SYOKUNOUKYU")
	private int syokunokyu;
	
	@Column(name = "KOYOU_HOKEN_NO")
	private String kokyouHokenNo;
	
	@Column(name = "NANKIN_NO")
	private String nankinNo;
	
	@Column(name = "NANKIN_KIJYUN_GAKU")
	private int nankinKiJyunGaku;
	
	@Column(name = "KENKOU_HOKEN_NO")
	private String kenkouHokenNo;
	
	@Column(name = "BIKOU")
	private String bikou;
	
	@Column(name = "TOUROKUBI")
	private Date tourokubi;
	
	@Column(name = "KOUSINNBI")
	private Date kousinbi;
	

	public int getSyainId() {
		return syainId;
	}

	public void setSyainId(int syainId) {
		this.syainId = syainId;
	}

	public String getKaishiNengetsu() {
		return kaishiNengetsu;
	}

	public void setKaishiNengetsu(String kaishiNengetsu) {
		this.kaishiNengetsu = kaishiNengetsu;
	}

	public String getSyuryoNengetsu() {
		return syuryoNengetsu;
	}

	public void setSyuryoNengetsu(String syuryoNengetsu) {
		this.syuryoNengetsu = syuryoNengetsu;
	}

	public int getKihonkyu() {
		return kihonkyu;
	}

	public void setKihonkyu(int kihonkyu) {
		this.kihonkyu = kihonkyu;
	}

	public int getSyokunokyu() {
		return syokunokyu;
	}

	public void setSyokunokyu(int syokunokyu) {
		this.syokunokyu = syokunokyu;
	}

	public String getKokyouHokenNo() {
		return kokyouHokenNo;
	}

	public void setKokyouHokenNo(String kokyouHokenNo) {
		this.kokyouHokenNo = kokyouHokenNo;
	}

	public String getNankinNo() {
		return nankinNo;
	}

	public void setNankinNo(String nankinNo) {
		this.nankinNo = nankinNo;
	}

	public int getNankinKiJyunGaku() {
		return nankinKiJyunGaku;
	}

	public void setNankinKiJyunGaku(int nankinKiJyunGaku) {
		this.nankinKiJyunGaku = nankinKiJyunGaku;
	}

	public String getKenkouHokenNo() {
		return kenkouHokenNo;
	}

	public void setKenkouHokenNo(String kenkouHokenNo) {
		this.kenkouHokenNo = kenkouHokenNo;
	}

	public String getBikou() {
		return bikou;
	}

	public void setBikou(String bikou) {
		this.bikou = bikou;
	}

	public Date getTourokubi() {
		return tourokubi;
	}

	public void setTourokubi(Date tourokubi) {
		this.tourokubi = tourokubi;
	}


	@Embeddable
	public static class SyainKyuyoRK implements Serializable {
		@Column(name = "SYAIN_ID")
		private int syainId;
		
		@Column(name = "KAISHI_NENGETSU")
		private String kaishiNengetsu;
		
		public int getSyainId() {
			return syainId;
		}
		public void setSyainId(int syainId) {
			this.syainId = syainId;
		}
		public String getKaishiNengetsu() {
			return kaishiNengetsu;
		}
		public void setKaishiNengetsu(String kaishiNengetsu) {
			this.kaishiNengetsu = kaishiNengetsu;
		}
		
		
	}
	
}
