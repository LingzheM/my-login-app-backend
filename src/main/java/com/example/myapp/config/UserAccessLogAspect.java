package com.example.myapp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.myapp.service.UserAccessLogService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

//@Aspect
//@Component
public class UserAccessLogAspect {
	
	//@Autowired
	UserAccessLogService userAccessLogService;
	
	@Before("execution(* com.example.myapp.controller.*.*(..)) && !execution(* com.example.myapp.controller.LoginController.*(..))")
	public void beforeMethod(JoinPoint joinPoint) {
		// username
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		HttpSession session = request.getSession(false);
		Integer userId = null;
		if (session != null) {
			userId = (Integer) session.getAttribute("userId");
		}
		// 画面名称
		String gamenId = joinPoint.getSignature().getName();
		//时间
		String startTime = request.getParameter("startTime");
		// 保存记录
		userAccessLogService.addUserAccessLog(userId, gamenId, startTime);
	}

}

