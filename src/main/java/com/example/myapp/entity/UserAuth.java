package com.example.myapp.entity;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table; 


@Entity
@Table(name = "user_auth")
public class UserAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(unique = true, nullable = false, length = 20)
    private String userCode;

    @Column(nullable = false, length = 30)
    private String userName;

    @Column(nullable = false, length = 32)
    private String password;

    @Column(nullable = false, length = 1)
    private String userRole;

    @Column(nullable = false)
    private Integer isYoukou;
    
    public Integer getUserId() {
    	return this.userId;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public String getUserName() {
    	return this.userName;
    }
    
    
    public String getUserCode() {
    	return this.userCode;
    }
    
    public String getUserRole() {
    	return this.userRole;
    }
}

