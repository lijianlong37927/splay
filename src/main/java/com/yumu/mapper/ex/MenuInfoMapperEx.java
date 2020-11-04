package com.yumu.mapper.ex;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.yumu.controller.login.vo.LoginMenuListVo;
import com.yumu.controller.menu.vo.MenuInfoVo;
import com.yumu.controller.menu.vo.RoleInfoVo;

public interface MenuInfoMapperEx {

	/**
	 * <p>Title: qryMenuList</p>
	 * <p>Description:查询用户有权菜单</p>
	 * @param userId
	 * @return
	 */
	List<LoginMenuListVo> qryMenuList(@Param("userId") String userId);

	/**
	 * <p>Title: qryAllMenuList</p>
	 * <p>Description: 查询全部有效菜单</p>
	 * @return
	 */
	List<MenuInfoVo> qryAllMenuList();

	/**
	 * <p>Title: qryMenuRoleList</p>
	 * <p>Description: 查询菜单关联角色</p>
	 * @param id
	 * @return
	 */
	List<RoleInfoVo> qryMenuRoleList(@Param("id") Integer id);
}