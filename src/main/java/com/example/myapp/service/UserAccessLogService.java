package com.example.myapp.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.myapp.entity.UserAccessLog;
import com.example.myapp.mapper.UserAccessLogRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserAccessLogService {
	
	@Autowired
	UserAccessLogRepository userAccessLogRepository;
	
	public void addUserAccessLog(int userId,  String gamenId, String startTime) {
		log.info("");
		UserAccessLog userAccessLog = new UserAccessLog();
		userAccessLog.setUserId(userId);
		userAccessLog.setGamenId(gamenId);
		userAccessLog.setStartTime(new Date(startTime));
		userAccessLogRepository.save(userAccessLog);
	}

}
