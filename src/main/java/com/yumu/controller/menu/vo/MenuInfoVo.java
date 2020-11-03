package com.yumu.controller.menu.vo;

import java.util.ArrayList;
import java.util.List;

public class MenuInfoVo {
	private String menuId;
	private String title;
	private String url;
	private String parentId;
	private List<MenuInfoVo> children = new ArrayList<>();

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

	public List<MenuInfoVo> getChildren() {
		return children;
	}

	public void setChildren(List<MenuInfoVo> children) {
		this.children = children;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
}
