package com.example.myapp.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.myapp.service.AuthorizationService;
import com.example.myapp.utils.InMemorySessionStore;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

/**
 * 定义切面来维护请求的权限验证
 */
@Aspect
@Component
@Slf4j
public class AuthorizationAspect {
	
	@Autowired
	private AuthorizationService authorizationService;
	
	private static String LOGIN_METHOD_NAME = "login";
	
	@Pointcut("within(@org.springframework.web.bind.annotation.RestController *)")
	public void controllerMethods() {}

	
	//@Before("execution(* com.example.myapp..*.*(..))")
	public void beforeMethod() {
		log.info("[aspect] 检验方法是否生效");
	}
	
	//@Before("controllerMethods()")
	//@Before("execution(* com.example.myapp..*.*(..))")
	public void checkPermissionAdvice(JoinPoint joinPoint) {
		log.info("[aspect] 权限切面拦截请求");		
		String function = getFunctionName(joinPoint);
		log.info("[aspect] 请求拦截方法为：{}", function);
		if (function.equals(LOGIN_METHOD_NAME)) {
			log.info("[aspect] 放行login方法");
			return;
		}
		String userRole = getUserRoleFromSessionOrCookie();
		log.info("[aspect] session中保存的userRole: {}", userRole);
		authorizationService.checkPermission(userRole, function);
	}
	
	private String getUserRoleFromSessionOrCookie() {
		// 获取当前HTTP请求
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		
		// 尝试从session获取用户
		String userRole = getSessionByJSessionId(request);
//		HttpSession session = getSessionByJSessionId(request);
//		log.info("[aspect] Request Session: {}", session);
//		String userRole = (session != null) ? (String)session.getAttribute("userRole") : null;
//		// 如果session中未保存, 查询cookie
//		if (userRole != null) {
//			log.info("[aspect] 当前用户的session中没有userRole");
//			userRole = Arrays.stream(request.getCookies())
//					.filter(c -> "userRole".equals(c.getName()))
//					.findFirst()
//					.map(Cookie::getValue)
//					.orElse(null);
//		} 
		return userRole;
	}
	
	/**
	 * 根据JsessionId获取session
	 * @param request
	 * @return
	 */
	public String getSessionByJSessionId(HttpServletRequest request) {
		HttpSession session = null;
		String userRole = null;
		Cookie[] cookies = request.getCookies();
		log.info("[aspect] cookie: {}", cookies.toString());
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("SESSIONID")) {
					String sessionId = cookie.getValue();
					log.info("[aspect] 当前的sessionId: {}", sessionId);
					userRole = (String) InMemorySessionStore.getAttribute(sessionId, "userRole");
//					session = request.getSession(false);
					if (session == null) {
						log.warn("[aspect] session 为空");
					} else if (session != null && !session.getId().equals(sessionId)) {
						log.warn("[aspect] session 不匹配");
					}
					break;
 				}
			}
 		}
		return userRole;
	}
	
	/**
	 * 暂时假设功能名称和方法名相同
	 */
	private String getFunctionName(JoinPoint joinPoint) {
		String methodName = joinPoint.getSignature().getName();
		return methodName;
	}
	

}
