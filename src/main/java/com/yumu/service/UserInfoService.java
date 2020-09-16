package com.yumu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.yumu.constant.UserInfoConst;
import com.yumu.controller.RequestPage;
import com.yumu.controller.ResponsePage;
import com.yumu.controller.user.req.UserInfoEditReq;
import com.yumu.controller.user.req.UserInfoListReq;
import com.yumu.controller.user.resp.UserInfoListResp;
import com.yumu.dto.UserInfo;
import com.yumu.mapper.UserInfoMapper;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	public ResponsePage<UserInfoListResp> list(RequestPage<UserInfoListReq> page) {
		UserInfoListReq cond = page.getCondition();
		UserInfo userInfoQry = new UserInfo();
		userInfoQry.setUserId(cond.getUserId());
		userInfoQry.setUserName(cond.getUserName());
		userInfoQry.setStatus(UserInfoConst.STATUS_0);
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<UserInfo> userInfoList = userInfoMapper.select(userInfoQry);
		return new ResponsePage<>(userInfoList, UserInfoListResp.class);
	}

	@Transactional(rollbackFor = { Exception.class })
	public void edit(UserInfoEditReq req) {
		UserInfo userInfoUpd = new UserInfo();
		userInfoUpd.setUserId(req.getUserId());
		userInfoUpd.setUserName(req.getUserName());
		userInfoMapper.updateByPrimaryKey(userInfoUpd);
	}

}
