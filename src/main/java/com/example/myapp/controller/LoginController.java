package com.example.myapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.myapp.entity.UserAuth;
import com.example.myapp.service.UserAuthService;
import com.example.myapp.vo.UserAuthResponse;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class LoginController {

	@Autowired
	private UserAuthService authService;
	
	@GetMapping(value="/hello")
	public String hello() {
		System.out.println("request receive succeed");

		return "Hi, Eclipse ";
	}
	
	@PostMapping("/userLogin")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest,
											HttpServletRequest request,
											HttpServletResponse response) {
		String userCode = loginRequest.getLoginId();
		try {
			UserAuth userAuth = authService.authenticate(userCode, loginRequest.getPassword());
			UserAuthResponse userAuthResponse = new UserAuthResponse(
                    userAuth.getUserCode(),
                    userAuth.getUserName(),
                    userAuth.getUserRole()
            );
			// 创建session
			HttpSession session = request.getSession();
			log.info("[LoginContoller], sessionId: {}",session.getId());
			session.setAttribute("userRole", userAuth.getUserRole());
			// 创建会话并存储属性
//			String sessionId = InMemorySessionStore.createSession();
//			log.info("[loginContoller], 当前登录用户为：{}, sessionId：{}", userAuth.getUserName(), sessionId);
//			InMemorySessionStore.setAttribute(sessionId, "userRole", userAuth.getUserRole());
//			// 通过cookie返回客户端
//			Cookie cookie = new Cookie("SESSIONID", sessionId);
//			cookie.setPath("/");
//			cookie.setHttpOnly(true);
//			response.addCookie(cookie);
			return ResponseEntity.ok().body(userAuthResponse);
			
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PostMapping("/logout")
	@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS})
	public ResponseEntity<?> logout(HttpServletRequest request,
			HttpServletResponse response) {
		// 获取当前会话
        HttpSession session = request.getSession(false);
        
        if (session != null) {
            // 使会话无效
            session.invalidate();
        }
        
        // 创建一个名为SESSIONID的Cookie，将其过期时间设置为0，并添加到响应中
        Cookie cookie = new Cookie("SESSIONID", null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0); // 立即过期
        response.addCookie(cookie);
        
        // 可以返回一些信息，表示登出操作成功
        return ResponseEntity.ok().body("用户已登出");
	}
	
	static class LoginRequest {
		private String loginId;
		private String password;
		
		public String getLoginId() {
			return loginId;
		}
		
		public void setLoginId(String loginId) {
			this.loginId = loginId;
		}
		
		public String getPassword() {
			return password;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
	}
 	
}
