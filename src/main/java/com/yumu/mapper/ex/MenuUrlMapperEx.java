package com.yumu.mapper.ex;

import com.yumu.controller.login.resp.MenuResp;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuUrlMapperEx {

	/**
	 * <p>Title: qryAuthUrl</p>
	 * <p>Description: 查询有权限请求</p>
	 * @param userId
	 * @param url
	 * @return
	 */
	List<MenuResp> qryAuthUrl(@Param("userId") String userId, @Param("url") String url);
}