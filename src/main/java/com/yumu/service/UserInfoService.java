package com.yumu.service;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.yumu.constant.UserInfoConst;
import com.yumu.controller.RequestPage;
import com.yumu.controller.ResponsePage;
import com.yumu.controller.user.req.DetailEditReq;
import com.yumu.controller.user.req.ListQueryReq;
import com.yumu.controller.user.resp.UserInfoListQueryResp;
import com.yumu.dto.UserInfo;
import com.yumu.dto.UserInfoExample;
import com.yumu.mapper.UserInfoMapper;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoMapper userInfoMapper;

	public ResponsePage<UserInfoListQueryResp> listQuery(RequestPage<ListQueryReq> page) {
		ListQueryReq cond = page.getCondition();
		// 拼接查询条件
		UserInfoExample userInfoEp = new UserInfoExample();
		UserInfoExample.Criteria criteria = userInfoEp.createCriteria();
		if (StringUtils.isNotBlank(cond.getUserId())) {
			criteria.andUserIdEqualTo(cond.getUserId());
		}
		if (StringUtils.isNotBlank(cond.getUserName())) {
			criteria.andUserNameLike(cond.getUserName());
		}
		criteria.andStatusEqualTo(UserInfoConst.STATUS_0);
		// 分页查询
		PageHelper.startPage(page.getPageNum(), page.getPageSize());
		List<UserInfo> userInfoList = userInfoMapper.selectByExample(userInfoEp);
		// 转换返回结果
		return new ResponsePage<>(userInfoList, UserInfoListQueryResp.class);
	}

	@Transactional(rollbackFor = { Exception.class })
	public void edit(DetailEditReq req) {
		// 设置参数
		UserInfo userInfoUpd = new UserInfo();
		userInfoUpd.setUserId(req.getUserId());
		userInfoUpd.setUserName(req.getUserName());
		// 更新
		userInfoMapper.updateByPrimaryKeySelective(userInfoUpd);
	}

	public UserInfo getUserInfoById(String userId) {
		return userInfoMapper.selectByPrimaryKey(userId);
	}

}
