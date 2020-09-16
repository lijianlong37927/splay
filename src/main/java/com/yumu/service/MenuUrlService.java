package com.yumu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yumu.controller.login.resp.MenuResp;
import com.yumu.mapper.MenuUrlMapper;

@Service
public class MenuUrlService {

	@Autowired
	private MenuUrlMapper menuUrlMapper;

	/**
	 * <p>Title: qryAuthUrl</p>
	 * <p>Description: 查询有权限请求</p>
	 * @param userId
	 * @param url
	 * @return
	 */
	public List<MenuResp> qryAuthUrl(String userId, String url) {
		return menuUrlMapper.qryAuthUrl(userId, url);
	}
}
