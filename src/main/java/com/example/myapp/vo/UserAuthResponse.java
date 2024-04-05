package com.example.myapp.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserAuthResponse {
    private String userCode;
    private String userName;
    private String userRole;
    private String loginTime; // 注意：这个属性需要额外处理，因为它并不存在于UserAuth实体中

    // 构造函数
    public UserAuthResponse(String userCode, String userName, String userRole) {
        this.userCode = userCode;
        this.userName = userName;
        this.userRole = userRole;
        // 登录时间的处理逻辑，例如设置为当前时间
        this.loginTime = getCurrentFormattedDate();
    }

    // Getter和Setter方法

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(String loginTime) {
        this.loginTime = loginTime;
    }

    // 获取当前时间并格式化的方法
    private String getCurrentFormattedDate() {
        // 实现获取当前时间并格式化为字符串的逻辑，例如使用SimpleDateFormat
        // 返回格式化后的时间字符串
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}

