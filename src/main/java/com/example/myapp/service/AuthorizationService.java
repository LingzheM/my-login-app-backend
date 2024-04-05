package com.example.myapp.service;

import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {
	
	public boolean checkPermission(String userRole, String function) {
		return true;
//		Permission permission = Permission.fromFunction(function);
//		Role role = Role.fromCode(userRole);
//		return PermissionMap.hasAccess(permission, role);
	}
 
}
