package com.yumu.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yumu.controller.login.vo.LoginMenuListVo;
import com.yumu.controller.menu.vo.MenuInfoVo;
import com.yumu.dto.MenuInfo;
import com.yumu.dto.MenuInfoExample;
import com.yumu.mapper.MenuInfoMapper;
import com.yumu.mapper.ex.MenuInfoMapperEx;

@Repository
public class MenuInfoRepo {

	@Autowired
	private MenuInfoMapper menuInfoMapper;
	@Autowired
	private MenuInfoMapperEx menuInfoMapperEx;

	public List<MenuInfo> selectByExample(MenuInfoExample example) {
		return menuInfoMapper.selectByExample(example);
	}

	public List<LoginMenuListVo> qryMenuList(String userId) {
		return menuInfoMapperEx.qryMenuList(userId);
	}

	public List<MenuInfoVo> qryAllMenuList() {
		return menuInfoMapperEx.qryAllMenuList();
	}
}
