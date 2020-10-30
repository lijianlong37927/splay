package com.yumu.repo;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.yumu.dto.UserRole;
import com.yumu.dto.UserRoleExample;
import com.yumu.mapper.UserRoleMapper;

@Component
public class UserRoleRepo {

	@Autowired
	private UserRoleMapper userRoleMapper;

	public List<UserRole> selectByUserId(String userId) {
		UserRoleExample example = new UserRoleExample();
		UserRoleExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(userId)) {
			criteria.andUserIdEqualTo(userId);
		}
		return userRoleMapper.selectByExample(example);
	}
}
