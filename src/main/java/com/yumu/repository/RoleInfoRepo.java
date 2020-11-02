package com.yumu.repository;

import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yumu.dto.RoleInfo;
import com.yumu.dto.RoleInfoExample;
import com.yumu.mapper.RoleInfoMapper;

@Repository
public class RoleInfoRepo {

	@Autowired
	private RoleInfoMapper roleInfoMapper;

	public RoleInfo selectByPrimaryKey(String roleId) {
		return roleInfoMapper.selectByPrimaryKey(roleId);
	}

	public int updateByPrimaryKeySelective(RoleInfo roleInfoUpd) {
		return roleInfoMapper.updateByPrimaryKeySelective(roleInfoUpd);
	}

	public List<RoleInfo> selectByExample(RoleInfoExample example) {
		return roleInfoMapper.selectByExample(example);
	}

	public List<RoleInfo> qryByIdStatus(String roleId, Integer status) {
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

	public List<RoleInfo> qryByIdNameStatus(String roleId, String roleName, Integer status) {
		RoleInfoExample example = new RoleInfoExample();
		RoleInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(roleId)) {
			criteria.andRoleIdEqualTo(roleId);
		}
		if (StringUtils.isNotBlank(roleName)) {
			criteria.andRoleNameEqualTo(roleName);
		}
		if (status != null) {
			criteria.andStatusEqualTo(status);
		}
		return roleInfoMapper.selectByExample(example);
	}

}
