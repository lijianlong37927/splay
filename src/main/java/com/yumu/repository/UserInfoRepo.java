package com.yumu.repository;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yumu.dto.UserInfo;
import com.yumu.dto.UserInfoExample;
import com.yumu.mapper.UserInfoMapper;

@Repository
public class UserInfoRepo {

	@Autowired
	private UserInfoMapper userInfoMapper;

	public List<UserInfo> selectByExample(UserInfoExample example) {
		return userInfoMapper.selectByExample(example);
	}

	public UserInfo selectByPrimaryKey(String userId) {
		return userInfoMapper.selectByPrimaryKey(userId);
	}

	public int updateByPrimaryKeySelective(UserInfo userInfo) {
		return userInfoMapper.updateByPrimaryKeySelective(userInfo);
	}

	public List<UserInfo> qryByIdNameStatus(String userId, String name, Integer status) {
		UserInfoExample example = new UserInfoExample();
		UserInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(userId)) {
			criteria.andUserIdEqualTo(userId);
		}
		if (StringUtils.isNotBlank(name)) {
			criteria.andUserNameLike(name);
		}
		if (status != null) {
			criteria.andStatusEqualTo(status);
		}
		return userInfoMapper.selectByExample(example);
	}

}
