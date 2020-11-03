package com.yumu.controller.user.vo;

import java.util.List;

public class UserInfoVo {

	private String userId;
	private String userName;
	private Integer state;
	private List<String> roleIdList;
	/** 角色*/
	private List<RoleInfoVo> roleInfoVoList;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<RoleInfoVo> getRoleInfoVoList() {
		return roleInfoVoList;
	}

	public void setRoleInfoVoList(List<RoleInfoVo> roleInfoVoList) {
		this.roleInfoVoList = roleInfoVoList;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public List<String> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		this.roleIdList = roleIdList;
	}
}
