package com.yumu.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.yumu.constant.CommonConst;
import com.yumu.controller.RequestPage;
import com.yumu.controller.ResponsePage;
import com.yumu.controller.user.vo.RoleInfoVo;
import com.yumu.controller.user.vo.UserInfoVo;
import com.yumu.dto.RoleInfo;
import com.yumu.dto.UserInfo;
import com.yumu.dto.UserRole;
import com.yumu.exception.ExceptionConst;
import com.yumu.exception.ServiceException;
import com.yumu.repository.RoleInfoRepo;
import com.yumu.repository.UserInfoRepo;
import com.yumu.repository.UserRoleRepo;
import com.yumu.tool.BeanTool;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepo userInfoRepo;
	@Autowired
	private RoleInfoRepo roleInfoRepo;
	@Autowired
	private UserRoleRepo userRoleRepo;

	/**
	 * <p>Title: listQuery</p>
	 * <p>Description: 查询列表</p>
	 * @param page
	 * @return
	 */
	public ResponsePage<UserInfoVo> listQuery(RequestPage<UserInfoVo> page) {
		try {
			UserInfoVo cond = page.getCondition();
			// 分页查询
			PageHelper.startPage(page.getPageNum(), page.getPageSize());
			List<UserInfo> userInfoList = userInfoRepo.qryByIdNameState(cond.getUserId(), cond.getUserName(),
					cond.getState());
			// 转换返回结果
			return new ResponsePage<>(userInfoList, UserInfoVo.class);
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.QUERY_ERROR);
		}
	}

	/**
	 * <p>Title: newPage</p>
	 * <p>Description: 新建初始化数据</p>
	 * @return
	 */
	public UserInfoVo newPage() {
		try {
			UserInfoVo userInfoVo = new UserInfoVo();
			// 查询所有角色
			List<RoleInfo> roleInfoList = roleInfoRepo.qryByIdState(null, CommonConst.STATE_VALID);
			List<RoleInfoVo> roleInfoVoList = BeanTool.convertList(roleInfoList, RoleInfoVo.class);

			// 角色设值
			userInfoVo.setRoleInfoVoList(roleInfoVoList);

			return userInfoVo;
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.QUERY_ERROR);
		}
	}

	/**
	 * <p>Title: newSubmit</p>
	 * <p>Description: 新增提交</p>
	 * @param req
	 */
	public void newSubmit(UserInfoVo req) {
		try {
			// 设置参数
			UserInfo userInfoIS = new UserInfo();
			userInfoIS.setUserId(req.getUserId());
			userInfoIS.setUserName(req.getUserName());
			userInfoIS.setState(req.getState());
			// 更新用户信息
			userInfoRepo.insertSelective(userInfoIS);
			// 更新用户角色
			userRoleRepo.updateUserRole(req.getUserId(), req.getRoleIdList());
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.EDIT_ERROR);
		}
	}

	/**
	 * <p>Title: getUserInfoById</p>
	 * <p>Description: 获取详情</p>
	 * @param userId
	 * @return
	 */
	public UserInfoVo getUserInfoById(String userId) {
		try {
			UserInfoVo userInfoVo = new UserInfoVo();
			// 查询用户信息
			UserInfo userInfo = userInfoRepo.selectByPrimaryKey(userId);
			// 用户信息设置
			userInfoVo.setUserId(userInfo.getUserId());
			userInfoVo.setUserName(userInfo.getUserName());
			userInfoVo.setState(userInfo.getState());
			// 查询所有角色
			List<RoleInfo> roleInfoList = roleInfoRepo.qryByIdState(null, CommonConst.STATE_VALID);
			// 查询用户角色
			List<UserRole> userRoleList = userRoleRepo.selectByUserId(userInfo.getUserId());
			// 设置用户角色勾选
			List<RoleInfoVo> roleInfoVoList = BeanTool.convertList(roleInfoList, RoleInfoVo.class);
			userRoleList.forEach(userRole -> {
				roleInfoVoList.forEach(roleInfoVo -> {
					if (roleInfoVo.getRoleId().equals(userRole.getRoleId())) {
						roleInfoVo.setChecked(true);
					}
				});
			});
			// 角色设值
			userInfoVo.setRoleInfoVoList(roleInfoVoList);
			return userInfoVo;
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.QUERY_ERROR);
		}
	}

	/**
	 * <p>Title: editSubmit</p>
	 * <p>Description: 修改提交</p>
	 * @param req
	 */
	@Transactional(rollbackFor = { Exception.class })
	public void editSubmit(UserInfoVo req) {
		try {
			// 设置参数
			UserInfo userInfoUD = new UserInfo();
			userInfoUD.setUserId(req.getUserId());
			userInfoUD.setUserName(req.getUserName());
			userInfoUD.setState(req.getState());
			// 更新用户信息
			userInfoRepo.updateByPrimaryKeySelective(userInfoUD);
			// 更新用户角色
			userRoleRepo.updateUserRole(req.getUserId(), req.getRoleIdList());
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.EDIT_ERROR);
		}
	}

	/**
	 * <p>Title: delSubmit</p>
	 * <p>Description: 删除提交</p>
	 * @param req
	 */
	@Transactional(rollbackFor = { Exception.class })
	public void delSubmit(UserInfoVo req) {
		try {
			// 设置参数
			UserInfo userInfoUpd = new UserInfo();
			userInfoUpd.setUserId(req.getUserId());
			userInfoUpd.setState(CommonConst.STATE_INVALID);
			// 更新
			userInfoRepo.updateByPrimaryKeySelective(userInfoUpd);
		} catch (ServiceException sex) {
			throw sex;
		} catch (Exception ex) {
			throw new ServiceException(ex, ExceptionConst.DEL_ERROR);
		}
	}

}
