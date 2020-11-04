package com.yumu.repository;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.yumu.constant.CommonConst;
import com.yumu.controller.login.vo.LoginMenuListVo;
import com.yumu.controller.menu.vo.MenuInfoVo;
import com.yumu.controller.menu.vo.RoleInfoVo;
import com.yumu.dto.MenuInfo;
import com.yumu.dto.MenuInfoExample;
import com.yumu.dto.RoleMenu;
import com.yumu.dto.RoleMenuExample;
import com.yumu.mapper.MenuInfoMapper;
import com.yumu.mapper.RoleMenuMapper;
import com.yumu.mapper.ex.MenuInfoMapperEx;

@Repository
public class MenuInfoRepo {

	@Autowired
	private MenuInfoMapper menuInfoMapper;
	@Autowired
	private MenuInfoMapperEx menuInfoMapperEx;
	@Autowired
	private RoleMenuMapper roleMenuMapper;

	public List<MenuInfo> selectByExample(MenuInfoExample example) {
		return menuInfoMapper.selectByExample(example);
	}

	public MenuInfo selectByPrimaryKey(Integer id) {
		return menuInfoMapper.selectByPrimaryKey(id);
	}

	public int insertSelective(MenuInfo menuInfo) {
		return menuInfoMapper.insertSelective(menuInfo);
	}

	public int updateByPrimaryKeySelective(MenuInfo menuInfo) {
		return menuInfoMapper.updateByPrimaryKeySelective(menuInfo);
	}

	/**
	 * <p>Title: qryMenuList</p>
	 * <p>Description: 查询用户有权菜单</p>
	 * @param userId
	 * @return
	 */
	public List<LoginMenuListVo> qryMenuList(String userId) {
		return menuInfoMapperEx.qryMenuList(userId);
	}

	/**
	 * <p>Title: qryAllMenuList</p>
	 * <p>Description: 查询所有菜单</p>
	 * @return
	 */
	public List<MenuInfoVo> qryAllMenuList() {
		return menuInfoMapperEx.qryAllMenuList();
	}

	/**
	 * <p>Title: qryMenuRoleList</p>
	 * <p>Description: 查询菜单关联角色</p>
	 * @param id
	 * @return
	 */
	public List<RoleInfoVo> qryMenuRoleList(Integer id) {
		return menuInfoMapperEx.qryMenuRoleList(id);
	}

	/**
	 * <p>Title: updateMenuRole</p>
	 * <p>Description: 更新菜单关联角色</p>
	 * @param id
	 * @param roleIdList
	 */
	public void updateMenuRole(Integer id, List<String> roleIdList) {
		if (id == null || roleIdList == null) {
			return;
		}
		// 加锁防止并发
//		try {
//			LockTool.lock(LockKeyEnum.menuId.getKey() + id);
			// 先修改成删除状态
			RoleMenu roleMenuUD = new RoleMenu();
			roleMenuUD.setState(CommonConst.STATE_INVALID);
			RoleMenuExample roleMenuExampleUD = new RoleMenuExample();
			roleMenuExampleUD.createCriteria().andMenuIdEqualTo(id);
			roleMenuMapper.updateByExampleSelective(roleMenuUD, roleMenuExampleUD);
			// 插入新数据
			RoleMenu roleMenuIS;
			for (int i = 0; i < roleIdList.size(); i++) {
				roleMenuIS = new RoleMenu();
				roleMenuIS.setRoleId(roleIdList.get(i));
				roleMenuIS.setMenuId(id);
				roleMenuMapper.insertSelective(roleMenuIS);
			}
//		} finally {
//			LockTool.unlock(LockKeyEnum.menuId.getKey() + id);
//		}

	}

}
