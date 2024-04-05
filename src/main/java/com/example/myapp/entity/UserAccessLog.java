package com.example.myapp.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "USER_ACCESS_LOG")
public class UserAccessLog {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
    @Column(unique = true, length = 20)
	private int userId;
	
    @Column(length = 255)
	private String gamenId;
	
    @Column(length = 32)
	private Date startTime;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getGamenId() {
		return gamenId;
	}

	public void setGamenId(String gamenId) {
		this.gamenId = gamenId;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
    
    

}
