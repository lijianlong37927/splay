package com.yumu.controller.menu.vo;

import java.util.ArrayList;
import java.util.List;

public class MenuInfoVo {
	private Integer id;
	private String title;
	private String url;
	private Integer level;
	private Integer parentId;
	private Boolean spread = true;
	/** 角色Id*/
	private List<String> roleIdList;
	/** 角色*/
	private List<RoleInfoVo> roleInfoVoList;
	/** 下级菜单*/
	private List<MenuInfoVo> children = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<MenuInfoVo> getChildren() {
		return children;
	}

	public void setChildren(List<MenuInfoVo> children) {
		this.children = children;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Boolean getSpread() {
		return spread;
	}

	public void setSpread(Boolean spread) {
		this.spread = spread;
	}

	public List<RoleInfoVo> getRoleInfoVoList() {
		return roleInfoVoList;
	}

	public void setRoleInfoVoList(List<RoleInfoVo> roleInfoVoList) {
		this.roleInfoVoList = roleInfoVoList;
	}

	public List<String> getRoleIdList() {
		return roleIdList;
	}

	public void setRoleIdList(List<String> roleIdList) {
		this.roleIdList = roleIdList;
	}
}
