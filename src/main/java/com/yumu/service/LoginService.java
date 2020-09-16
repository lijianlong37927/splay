package com.yumu.service;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yumu.constant.UserInfoConst;
import com.yumu.context.LocalContext;
import com.yumu.controller.login.resp.MenuResp;
import com.yumu.dto.UserInfo;
import com.yumu.exception.ExceptionConst;
import com.yumu.exception.ServiceException;
import com.yumu.mapper.MenuInfoMapper;
import com.yumu.mapper.UserInfoMapper;
import com.yumu.tool.EncryptTool;

@Service
public class LoginService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	@Autowired
	private MenuInfoMapper menuInfoMapper;

	/**
	 * <p>Title: login</p>
	 * <p>Description: 校验登录</p>
	 * @param userId
	 * @param password
	 * @return
	 */
	public void login(String userId, String password) {
		try {
			String passwordChg = EncryptTool.sha1Hex(userId + password);
			UserInfo userInfoQry = new UserInfo();
			userInfoQry.setUserId(userId);
			userInfoQry.setPassword(passwordChg);
			userInfoQry.setStatus(UserInfoConst.STATUS_0);
			if (CollectionUtils.isNotEmpty(userInfoMapper.select(userInfoQry))) {
				LocalContext.getRequestContext().setUserId(userId);
			} else {
				ServiceException.throwException(ExceptionConst.CHECK_LOGIN_ERROR);
			}
		} catch (ServiceException serEx) {
			throw serEx;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.SYS_ERROR);
		}
	}

	/**
	 * <p>Title: menuList</p>
	 * <p>Description: 查询登录用户菜单</p>
	 * @param userId
	 * @return
	 */
	public List<MenuResp> menuList(String userId) {
		try {
			return menuInfoMapper.qryMenuList(userId);
		} catch (ServiceException serEx) {
			throw serEx;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.SYS_ERROR);
		}
	}
}
