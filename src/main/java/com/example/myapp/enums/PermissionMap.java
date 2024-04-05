package com.example.myapp.enums;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;

public class PermissionMap {
	
	/**
	 * 保存权限和用户等级的映射
	 */
	private static final Map<Permission, Set<Role>> permissions = Map.of(
		Permission.C, EnumSet.of(Role.SYSTEM_ADMIN, Role.GENERAL_ADMIN, Role.SALES));
	
	/**
	 * 判断是否有权限
	 * @param permission
	 * @param role
	 * @return
	 */
	public static boolean hasAccess(Permission permission, Role role) {
		Set<Role> allowedRoles = permissions.get(permission);
		return allowedRoles != null && allowedRoles.contains(role);
	}
}
