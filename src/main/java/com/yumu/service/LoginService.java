package com.yumu.service;

import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.yumu.constant.CommonConst;
import com.yumu.context.LocalContext;
import com.yumu.controller.login.vo.LoginMenuListVo;
import com.yumu.dto.UserInfoExample;
import com.yumu.exception.ExceptionConst;
import com.yumu.exception.ServiceException;
import com.yumu.repository.MenuInfoRepo;
import com.yumu.repository.UserInfoRepo;
import com.yumu.tool.EncryptTool;

@Service
public class LoginService {

	@Autowired
	private UserInfoRepo userInfoRepo;

	@Autowired
	private MenuInfoRepo menuInfoRepo;

	/**
	 * <p>Title: login</p>
	 * <p>Description: 校验登录</p>
	 * @param userId
	 * @param password
	 * @return
	 */
	public void login(String userId, String password) {
		try {
			// 密码转换
			String passwordChg = EncryptTool.sha1Hex(userId + password);
			// 查询条件
			UserInfoExample userInfoEp = new UserInfoExample();
			userInfoEp.createCriteria().andUserIdEqualTo(userId).andPasswordEqualTo(passwordChg)
					.andStateEqualTo(CommonConst.STATE_VALID);
			// 查询结果判断
			if (CollectionUtils.isNotEmpty(userInfoRepo.selectByExample(userInfoEp))) {
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
	public List<LoginMenuListVo> menuList(String userId) {
		try {
			return menuInfoRepo.qryMenuList(userId);
		} catch (ServiceException serEx) {
			throw serEx;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.SYS_ERROR);
		}
	}
}
