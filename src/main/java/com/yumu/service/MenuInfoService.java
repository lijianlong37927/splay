package com.yumu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yumu.controller.menu.vo.MenuInfoVo;
import com.yumu.repository.MenuInfoRepo;

@Service
public class MenuInfoService {

	@Autowired
	private MenuInfoRepo menuInfoRepo;

	public List<MenuInfoVo> listQuery() {
		return menuInfoRepo.qryAllMenuList();
	}

}
