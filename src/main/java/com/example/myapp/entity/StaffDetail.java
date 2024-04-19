package com.example.myapp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TORIHIKISAKI_TANTOU")
public class StaffDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TANTOU_ID", nullable = false)
    private Integer tantouId;

    @Column(name = "TORIHIKI_ID")
    private Integer torihikiId;

    @Column(name = "FIRST_NAME", nullable = false, length = 20)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false, length = 20)
    private String lastName;

    @Column(name = "SYOZOKU", length = 50)
    private String syozoku;

    @Column(name = "YAKUSYOKU", length = 50)
    private String yakusyoku;

    @Column(name = "MAIL", length = 100)
    private String mail;

    @Column(name = "TEL", length = 15)
    private String tel;

    // Assuming JIMU_MAIL is supposed to be a VARCHAR as well since it stores emails.
    @Column(name = "JIMU_MAIL", length = 100)
    private int jimuMail;

    @Column(name = "BIKOU", length = 255)
    private String bikou;

	public Integer getTantouId() {
		return tantouId;
	}

	public void setTantouId(Integer tantouId) {
		this.tantouId = tantouId;
	}

	public Integer getTorihikiId() {
		return torihikiId;
	}

	public void setTorihikiId(Integer torihikiId) {
		this.torihikiId = torihikiId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSyozoku() {
		return syozoku;
	}

	public void setSyozoku(String syozoku) {
		this.syozoku = syozoku;
	}

	public String getYakusyoku() {
		return yakusyoku;
	}

	public void setYakusyoku(String yakusyoku) {
		this.yakusyoku = yakusyoku;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Integer getJimuMail() {
		return jimuMail;
	}

	public void setJimuMail(int jimuMail) {
		this.jimuMail = jimuMail;
	}

	public String getBikou() {
		return bikou;
	}

	public void setBikou(String bikou) {
		this.bikou = bikou;
	}

    
}
