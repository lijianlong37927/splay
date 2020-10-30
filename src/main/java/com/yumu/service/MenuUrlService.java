package com.yumu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yumu.controller.login.vo.LoginMenuListVo;
import com.yumu.mapper.ex.MenuUrlMapperEx;

@Service
public class MenuUrlService {

	@Autowired
	private MenuUrlMapperEx menuUrlMapperEx;

	/**
	 * <p>Title: qryAuthUrl</p>
	 * <p>Description: 查询有权限请求</p>
	 * @param userId
	 * @param url
	 * @return
	 */
	public List<LoginMenuListVo> qryAuthUrl(String userId, String url) {
		return menuUrlMapperEx.qryAuthUrl(userId, url);
	}
}
