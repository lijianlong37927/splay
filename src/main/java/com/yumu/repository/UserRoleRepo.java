package com.yumu.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yumu.constant.CommonConst;
import com.yumu.dto.UserRole;
import com.yumu.dto.UserRoleExample;
import com.yumu.mapper.UserRoleMapper;
import com.yumu.tool.LockTool;

@Repository
public class UserRoleRepo {

	private final String UPDATEUSERROLE_LOCK_USERID = "UPDATEUSERROLE_LOCK_USERID_";

	@Autowired
	private UserRoleMapper userRoleMapper;

	/**
	 * <p>Title: selectByUserId</p>
	 * <p>Description: 根据userid查询对应角色</p>
	 * @param userId
	 * @return
	 */
	public List<UserRole> selectByUserId(String userId) {
		UserRoleExample example = new UserRoleExample();
		example.createCriteria().andUserIdEqualTo(userId).andStateEqualTo(CommonConst.STATE_VALID);
		return userRoleMapper.selectByExample(example);
	}

	/**
	 * <p>Title: updateUserRole</p>
	 * <p>Description: 更新用户角色</p>
	 * @param userId
	 * @param roleIdList
	 */
	public void updateUserRole(String userId, List<String> roleIdList) {
		if (userId == null) {
			return;
		}
		// 加锁防止并发
		try {
			LockTool.lock(UPDATEUSERROLE_LOCK_USERID + userId);
			// 先修改成删除状态
			UserRole userRoleUD = new UserRole();
			userRoleUD.setState(CommonConst.STATE_INVALID);
			UserRoleExample exampleUd = new UserRoleExample();
			exampleUd.createCriteria().andUserIdEqualTo(userId);
			userRoleMapper.updateByExampleSelective(userRoleUD, exampleUd);
			// 插入新数据
			UserRole userRoleIS;
			for (int i = 0; i < roleIdList.size(); i++) {
				userRoleIS = new UserRole();
				userRoleIS.setUserId(userId);
				userRoleIS.setRoleId(roleIdList.get(i));
				userRoleMapper.insertSelective(userRoleIS);
			}
		} finally {
			LockTool.unlock(UPDATEUSERROLE_LOCK_USERID + userId);
		}
	}
}
