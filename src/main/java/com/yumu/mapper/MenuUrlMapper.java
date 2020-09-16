package com.yumu.mapper;

import com.yumu.controller.login.resp.MenuResp;
import com.yumu.dto.MenuUrl;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuUrlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_url
     *
     * @mbg.generated Tue Sep 15 09:55:32 CST 2020
     */
    int deleteByPrimaryKey(@Param("menuId") String menuId, @Param("url") String url);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_url
     *
     * @mbg.generated Tue Sep 15 09:55:32 CST 2020
     */
    int insert(MenuUrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_url
     *
     * @mbg.generated Tue Sep 15 09:55:32 CST 2020
     */
    MenuUrl selectByPrimaryKey(@Param("menuId") String menuId, @Param("url") String url);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_url
     *
     * @mbg.generated Tue Sep 15 09:55:32 CST 2020
     */
    List<MenuUrl> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table menu_url
     *
     * @mbg.generated Tue Sep 15 09:55:32 CST 2020
     */
    int updateByPrimaryKey(MenuUrl record);

	/* Local Method */
	/**
	 * <p>Title: qryAuthUrl</p>
	 * <p>Description: </p>
	 * @param userId
	 * @param url
	 * @return
	 */
	List<MenuResp> qryAuthUrl(@Param("userId") String userId, @Param("url") String url);
}