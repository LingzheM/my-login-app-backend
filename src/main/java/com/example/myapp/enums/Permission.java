package com.example.myapp.enums;

public enum Permission {
	WORK_REMINDER("work reminder", "作業催促"),
	ORDER_MANAGEMENT("Order management", "受注管理"),
	C("","受注管理"),
	D("","外注管理"),
	E("","請求作成"),
	F("","見積作成"),
	G("","各書類作成"),
	H("","経費管理"),
	I("","営業状況管理"),
	J("","取引先情報管理"),
	K("","営業先情報管理"),
	L("","社員情報管理"),
	M("","システム設定"),
	N("", "ユーザ管理");
	
	private String permission;
	private String description;
	
	Permission(String permission, String description) {
		this.setPermission(permission);
		this.setDescription(description);
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public static Permission fromFunction(String function) {
		for (Permission existedPermission : Permission.values()) {
			if (existedPermission.getPermission().equals(function)) {
				return existedPermission;
			}
		}
		throw new IllegalArgumentException("No permission defined");
	}
}
