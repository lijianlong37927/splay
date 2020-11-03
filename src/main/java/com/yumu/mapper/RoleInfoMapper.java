package com.yumu.mapper;

import com.yumu.dto.RoleInfo;
import com.yumu.dto.RoleInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Tue Nov 03 17:36:49 CST 2020
     */
    long countByExample(RoleInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Tue Nov 03 17:36:49 CST 2020
     */
    int deleteByExample(RoleInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Tue Nov 03 17:36:49 CST 2020
     */
    int deleteByPrimaryKey(String roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Tue Nov 03 17:36:49 CST 2020
     */
    int insert(RoleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Tue Nov 03 17:36:49 CST 2020
     */
    int insertSelective(RoleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Tue Nov 03 17:36:49 CST 2020
     */
    List<RoleInfo> selectByExample(RoleInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Tue Nov 03 17:36:49 CST 2020
     */
    RoleInfo selectByPrimaryKey(String roleId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Tue Nov 03 17:36:49 CST 2020
     */
    int updateByExampleSelective(@Param("record") RoleInfo record, @Param("example") RoleInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Tue Nov 03 17:36:49 CST 2020
     */
    int updateByExample(@Param("record") RoleInfo record, @Param("example") RoleInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Tue Nov 03 17:36:49 CST 2020
     */
    int updateByPrimaryKeySelective(RoleInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_info
     *
     * @mbg.generated Tue Nov 03 17:36:49 CST 2020
     */
    int updateByPrimaryKey(RoleInfo record);
}