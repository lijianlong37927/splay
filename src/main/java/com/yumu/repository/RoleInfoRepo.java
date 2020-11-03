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

	public List<RoleInfo> qryByIdState(String roleId, Integer state) {
		RoleInfoExample example = new RoleInfoExample();
		RoleInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(roleId)) {
			criteria.andRoleIdEqualTo(roleId);
		}
		if (state != null) {
			criteria.andStateEqualTo(state);
		}
		return roleInfoMapper.selectByExample(example);
	}

	public List<RoleInfo> qryByIdNameState(String roleId, String roleName, Integer state) {
		RoleInfoExample example = new RoleInfoExample();
		RoleInfoExample.Criteria criteria = example.createCriteria();
		if (StringUtils.isNotBlank(roleId)) {
			criteria.andRoleIdEqualTo(roleId);
		}
		if (StringUtils.isNotBlank(roleName)) {
			criteria.andRoleNameEqualTo(roleName);
		}
		if (state != null) {
			criteria.andStateEqualTo(state);
		}
		return roleInfoMapper.selectByExample(example);
	}

}
