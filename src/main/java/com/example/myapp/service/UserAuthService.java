package com.example.myapp.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.UserAuth;
import com.example.myapp.mapper.UserAuthRepository;

@Service
public class UserAuthService {
	@Autowired
	private UserAuthRepository repository;
	
	public UserAuth authenticate(String userCode, String password) throws Exception {
		UserAuth userAuth = repository.findByUserCode(userCode);
		if (userAuth == null) {
			throw new Exception("DBエラー・該当ユーザーが存在しません。");
		}
		String encryptedPassword = md5(password);
		if (!userAuth.getPassword().equalsIgnoreCase(encryptedPassword)) {
			throw new Exception("パスワードが間違っています。");
		}
		return userAuth;
	}
	
	public String md5(String rawPassword) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		byte[] digest = md.digest(rawPassword.getBytes());
		// 16进制
		// 使用StringBuilder来构建最终的MD5字符串
	    StringBuilder sb = new StringBuilder(32);

	    // 转换每个byte为两位十六进制数
	    for (byte b : digest) {
	        sb.append(String.format("%02x", b));
	    }
	    String encryptedPassword = sb.toString();
		System.out.println("password:"+encryptedPassword);
		return encryptedPassword;
 	}

}
