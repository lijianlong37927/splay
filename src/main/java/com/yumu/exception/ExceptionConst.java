package com.yumu.exception;

public enum ExceptionConst {

	/** 系统异常*/
	SYS_ERROR(9999, "系统异常"), 
	/** 登录失败,请检查用户名/密码是否正确*/
	CHECK_LOGIN_ERROR(1, "登录失败,请检查用户名/密码是否正确"),
	/** 无权限访问*/
	NO_AUTH(2, "无权限访问"),
	/** 查询出错*/
	QUERY_ERROR(3, "查询出错"),
	/** 修改出错*/
	EDIT_ERROR(4, "修改出错"),
	/** 删除出错*/
	DEL_ERROR(5, "删除出错"),;

	private Integer code;
	private String msg;

	ExceptionConst(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
