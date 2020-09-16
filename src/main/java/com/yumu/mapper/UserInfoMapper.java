package com.yumu.mapper;

import com.yumu.dto.UserInfo;
import java.util.List;

public interface UserInfoMapper {
	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Wed Sep 16 17:45:23 CST 2020
	 */
	int deleteByPrimaryKey(String userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Wed Sep 16 17:45:23 CST 2020
	 */
	int insert(UserInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Wed Sep 16 17:45:23 CST 2020
	 */
	UserInfo selectByPrimaryKey(String userId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Wed Sep 16 17:45:23 CST 2020
	 */
	List<UserInfo> selectAll();

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table user_info
	 * @mbg.generated  Wed Sep 16 17:45:23 CST 2020
	 */
	int updateByPrimaryKey(UserInfo record);

	List<UserInfo> select(UserInfo record);
}