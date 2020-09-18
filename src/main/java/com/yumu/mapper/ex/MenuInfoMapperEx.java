package com.yumu.mapper.ex;

import com.yumu.controller.login.resp.MenuResp;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuInfoMapperEx {

	/**
	 * <p>Title: qryMenuList</p>
	 * <p>Description:</p>
	 * @param userId
	 * @return
	 */
	List<MenuResp> qryMenuList(@Param("userId") String userId);
}