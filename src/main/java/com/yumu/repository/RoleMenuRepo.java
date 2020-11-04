package com.yumu.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yumu.dto.RoleMenu;
import com.yumu.dto.RoleMenuExample;
import com.yumu.mapper.RoleMenuMapper;

@Repository
public class RoleMenuRepo {
	@Autowired
	private RoleMenuMapper roleMenuMapper;

	/**
	 * <p>Title: updateStateByMenuId</p>
	 * <p>Description: 根据菜单id更新RoleMenu</p>
	 * @param id
	 * @param state
	 * @return
	 */
	public int updateStateByMenuId(Integer id, Integer state) {
		RoleMenu roleMenuUD = new RoleMenu();
		roleMenuUD.setState(state);
		RoleMenuExample roleMenuExampleUD = new RoleMenuExample();
		roleMenuExampleUD.createCriteria().andMenuIdEqualTo(id);
		return roleMenuMapper.updateByExampleSelective(roleMenuUD, roleMenuExampleUD);
	}

}
