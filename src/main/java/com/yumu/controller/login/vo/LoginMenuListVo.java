package com.yumu.controller.login.vo;

import java.util.ArrayList;
import java.util.List;

public class LoginMenuListVo {
	private String menuId;
	private String title;
	private String url;
	private String parentId;
	private List<LoginMenuListVo> child = new ArrayList<>();

	public String getMenuId() {
		return menuId;
	}

	public void setId(String menuId) {
		this.menuId = menuId;
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

	public List<LoginMenuListVo> getChild() {
		return child;
	}

	public void setChild(List<LoginMenuListVo> child) {
		this.child = child;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
