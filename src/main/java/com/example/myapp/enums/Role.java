package com.example.myapp.enums;

public enum Role {
	SYSTEM_ADMIN("S"),
	GENERAL_ADMIN("A"),
	SALES("B"),
	ACCOUNTING("C"),
	HR("D");
	
	private String code;
	
	Role(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static Role fromCode(String code) {
        for (Role role : Role.values()) {
            if (role.getCode().equals(code)) {
                return role;
            }
        }
        throw new IllegalArgumentException("No role defined for code " + code);
    }

}
