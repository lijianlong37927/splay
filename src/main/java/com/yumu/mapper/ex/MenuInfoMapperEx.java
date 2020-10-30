package com.yumu.mapper.ex;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.yumu.controller.login.vo.LoginMenuListVo;

public interface MenuInfoMapperEx {

	/**
	 * <p>Title: qryMenuList</p>
	 * <p>Description:</p>
	 * @param userId
	 * @return
	 */
	List<LoginMenuListVo> qryMenuList(@Param("userId") String userId);
}