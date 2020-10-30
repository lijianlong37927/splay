package com.yumu.repo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.yumu.controller.login.vo.LoginMenuListVo;
import com.yumu.dto.MenuInfo;
import com.yumu.dto.MenuInfoExample;
import com.yumu.mapper.MenuInfoMapper;
import com.yumu.mapper.ex.MenuInfoMapperEx;

@Component
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
}
