package com.yumu.repo;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.yumu.dto.RoleInfo;
import com.yumu.dto.RoleInfoExample;
import com.yumu.mapper.RoleInfoMapper;

@Component
public class RoleInfoRepo {

	@Autowired
	private RoleInfoMapper roleInfoMapper;

	public List<RoleInfo> selectByExample(RoleInfoExample example) {
		return roleInfoMapper.selectByExample(example);
	}

	public List<RoleInfo> selectByIdStatus(String roleId, Integer status) {
		RoleInfoExample example = new RoleInfoExample();
		RoleInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(roleId)) {
			criteria.andRoleIdEqualTo(roleId);
		}
		if (status != null) {
			criteria.andStatusEqualTo(status);
		}
		return roleInfoMapper.selectByExample(example);
	}
}
