package com.yumu.mapper;

import com.yumu.dto.RoleMenu;
import com.yumu.dto.RoleMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu
     *
     * @mbg.generated Wed Nov 04 17:04:49 CST 2020
     */
    long countByExample(RoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu
     *
     * @mbg.generated Wed Nov 04 17:04:49 CST 2020
     */
    int deleteByExample(RoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu
     *
     * @mbg.generated Wed Nov 04 17:04:49 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu
     *
     * @mbg.generated Wed Nov 04 17:04:49 CST 2020
     */
    int insert(RoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu
     *
     * @mbg.generated Wed Nov 04 17:04:49 CST 2020
     */
    int insertSelective(RoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu
     *
     * @mbg.generated Wed Nov 04 17:04:49 CST 2020
     */
    List<RoleMenu> selectByExample(RoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu
     *
     * @mbg.generated Wed Nov 04 17:04:49 CST 2020
     */
    RoleMenu selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu
     *
     * @mbg.generated Wed Nov 04 17:04:49 CST 2020
     */
    int updateByExampleSelective(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu
     *
     * @mbg.generated Wed Nov 04 17:04:49 CST 2020
     */
    int updateByExample(@Param("record") RoleMenu record, @Param("example") RoleMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu
     *
     * @mbg.generated Wed Nov 04 17:04:49 CST 2020
     */
    int updateByPrimaryKeySelective(RoleMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_menu
     *
     * @mbg.generated Wed Nov 04 17:04:49 CST 2020
     */
    int updateByPrimaryKey(RoleMenu record);
}