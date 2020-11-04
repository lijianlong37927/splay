package com.yumu.constant;

public enum LockKeyEnum {

	userId("userId_", "用户角色ID"), menuId("menuId_", "菜单ID");

	private String key;
	private String desc;

	private LockKeyEnum(String key, String desc) {
		this.key = key;
		this.desc = desc;
	}

	public String getKey() {
		return key;
	}

	public String getDesc() {
		return desc;
	}
}
