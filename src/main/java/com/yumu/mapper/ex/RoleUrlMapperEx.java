package com.yumu.mapper.ex;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.yumu.controller.login.vo.LoginMenuListVo;

public interface RoleUrlMapperEx {

	/**
	 * <p>Title: qryAuthUrl</p>
	 * <p>Description: 查询有权限请求</p>
	 * @param userId
	 * @param url
	 * @return
	 */
	List<LoginMenuListVo> qryAuthUrl(@Param("userId") String userId, @Param("url") String url);
}