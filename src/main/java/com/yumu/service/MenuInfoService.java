package com.yumu.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.yumu.constant.CommonConst;
import com.yumu.constant.LockKeyEnum;
import com.yumu.controller.menu.vo.MenuInfoVo;
import com.yumu.dto.MenuInfo;
import com.yumu.exception.ExceptionConst;
import com.yumu.exception.ServiceException;
import com.yumu.repository.MenuInfoRepo;
import com.yumu.repository.RoleMenuRepo;
import com.yumu.tool.BeanTool;
import com.yumu.tool.LockTool;

@Service
public class MenuInfoService {

	@Autowired
	private MenuInfoRepo menuInfoRepo;

	@Autowired
	private RoleMenuRepo roleMenuRepo;

	public List<MenuInfoVo> listQuery() {
		MenuInfoVo root = new MenuInfoVo();
		root.setId(0);
		root.setTitle("根节点");
		root.setLevel(0);
		root.setChildren(menuInfoRepo.qryAllMenuList());
		List<MenuInfoVo> rootList = new ArrayList<>();
		rootList.add(root);
		return rootList;
	}

	public MenuInfoVo getMenuInfoById(Integer id) {
		try {
			// 查询用户信息
			MenuInfo menuInfo = menuInfoRepo.selectByPrimaryKey(id);
			MenuInfoVo menuInfoVo = BeanTool.convertBean(menuInfo, MenuInfoVo.class);
			menuInfoVo.setRoleInfoVoList(menuInfoRepo.qryMenuRoleList(id));
			return menuInfoVo;
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.QUERY_ERROR);
		}
	}

	@Transactional(rollbackFor = { Exception.class })
	public List<MenuInfoVo> newSubmit(MenuInfoVo req) {
		try {
			// 设置参数
			MenuInfo menuInfoIS = new MenuInfo();
			menuInfoIS.setTitle(req.getTitle());
			menuInfoIS.setUrl(req.getUrl());
			menuInfoIS.setLevel(req.getLevel());
			menuInfoIS.setParentId(req.getParentId());
			// 新增菜单信息
			menuInfoRepo.insertSelective(menuInfoIS);
			// 重新刷新查询
			return listQuery();
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.EDIT_ERROR);
		}
	}

	@Transactional(rollbackFor = { Exception.class })
	public void editSubmit(MenuInfoVo req) {
		try {
			// 设置参数
			MenuInfo menuInfoUD = new MenuInfo();
			menuInfoUD.setId(req.getId());
			menuInfoUD.setTitle(req.getTitle());
			menuInfoUD.setUrl(req.getUrl());
			// 更新菜单信息
			menuInfoRepo.updateByPrimaryKeySelective(menuInfoUD);
			// 更新角色
			menuInfoRepo.updateMenuRole(req.getId(), req.getRoleIdList());
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.EDIT_ERROR);
		}
	}

	@Transactional(rollbackFor = { Exception.class })
	public void delSubmit(MenuInfoVo req) {
		try {
			LockTool.lock(LockKeyEnum.menuId.getKey() + req.getId());
			// 设置参数
			MenuInfo menuInfoUpd = new MenuInfo();
			menuInfoUpd.setId(req.getId());
			menuInfoUpd.setState(CommonConst.STATE_INVALID);
			// 更新菜单
			menuInfoRepo.updateByPrimaryKeySelective(menuInfoUpd);
			// 更新菜单角色
			roleMenuRepo.updateStateByMenuId(req.getId(), CommonConst.STATE_INVALID);
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.DEL_ERROR);
		} finally {
			LockTool.unlock(LockKeyEnum.menuId.getKey() + req.getId());
		}
	}

}
