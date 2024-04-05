package com.example.myapp.utils;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * （暂时方案）
 * 手动模拟session的保存和获取
 */
public class InMemorySessionStore {
	
	private static final ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> sessions = new ConcurrentHashMap<>();
	
	
	/**
	 * 临时创建
	 * @return
	 */
	public static String createSession() {
		String sessionId = UUID.randomUUID().toString();
		sessions.put(sessionId, new ConcurrentHashMap<>());
		return sessionId;
	}
	
	/**
	 * session中添加数据
	 * @param sessionId
	 * @param key
	 * @param value
	 */
	public static void setAttribute(String sessionId, String key, Object value) {
		ConcurrentHashMap<String, Object> sessionData = sessions.get(sessionId);
		if (sessionData != null) {
			sessionData.put(key, value);
		}
	}
	
	/**
	 * 获取数据
	 * @param sessionId
	 * @param key
	 * @return
	 */
	public static Object getAttribute(String sessionId, String key) {
		ConcurrentHashMap<String, Object> sessionData = sessions.get(sessionId);
		return (sessionData != null) ? sessionData.get(key) : null;
 	}
	
	/**
	 * 清除session
	 * @param sessionId
	 */
	public static void invalidateSession(String sessionId) {
		sessions.remove(sessionId);
	}
}
