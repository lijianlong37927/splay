package com.yumu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.yumu.constant.CommonConst;
import com.yumu.controller.RequestPage;
import com.yumu.controller.ResponsePage;
import com.yumu.controller.role.vo.RoleInfoVo;
import com.yumu.dto.RoleInfo;
import com.yumu.exception.ExceptionConst;
import com.yumu.exception.ServiceException;
import com.yumu.repository.RoleInfoRepo;
import com.yumu.tool.BeanTool;

@Service
public class RoleInfoService {

	@Autowired
	private RoleInfoRepo roleInfoRepo;

	public ResponsePage<RoleInfoVo> listQuery(RequestPage<RoleInfoVo> page) {
		try {
			RoleInfoVo cond = page.getCondition();
			// 分页查询
			PageHelper.startPage(page.getPageNum(), page.getPageSize());
			List<RoleInfo> roleInfoList = roleInfoRepo.qryByIdNameState(cond.getRoleId(), cond.getRoleName(),
					cond.getState());
			// 转换返回结果
			return new ResponsePage<>(roleInfoList, RoleInfoVo.class);
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.QUERY_ERROR);
		}
	}

	public RoleInfoVo getRoleInfoById(String roleId) {
		try {
			// 查询用户信息
			RoleInfo roleInfo = roleInfoRepo.selectByPrimaryKey(roleId);
			return BeanTool.convertBean(roleInfo, RoleInfoVo.class);
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.QUERY_ERROR);
		}
	}

	@Transactional(rollbackFor = { Exception.class })
	public void editSubmit(RoleInfoVo req) {
		try {
			// 设置参数
			RoleInfo roleInfoUpd = new RoleInfo();
			roleInfoUpd.setRoleId(req.getRoleId());
			roleInfoUpd.setRoleName(req.getRoleName());
			roleInfoUpd.setState(req.getState());
			// 更新角色信息
			roleInfoRepo.updateByPrimaryKeySelective(roleInfoUpd);

		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.EDIT_ERROR);
		}
	}

	@Transactional(rollbackFor = { Exception.class })
	public void delSubmit(RoleInfoVo req) {
		try {
			// 设置参数
			RoleInfo roleInfoUpd = new RoleInfo();
			roleInfoUpd.setRoleId(req.getRoleId());
			roleInfoUpd.setState(CommonConst.STATE_INVALID);
			// 更新
			roleInfoRepo.updateByPrimaryKeySelective(roleInfoUpd);
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.DEL_ERROR);
		}
	}

}
