package com.yumu.mapper;

import com.yumu.dto.RoleUrl;
import com.yumu.dto.RoleUrlExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RoleUrlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_url
     *
     * @mbg.generated Tue Nov 03 17:36:48 CST 2020
     */
    long countByExample(RoleUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_url
     *
     * @mbg.generated Tue Nov 03 17:36:48 CST 2020
     */
    int deleteByExample(RoleUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_url
     *
     * @mbg.generated Tue Nov 03 17:36:48 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_url
     *
     * @mbg.generated Tue Nov 03 17:36:48 CST 2020
     */
    int insert(RoleUrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_url
     *
     * @mbg.generated Tue Nov 03 17:36:48 CST 2020
     */
    int insertSelective(RoleUrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_url
     *
     * @mbg.generated Tue Nov 03 17:36:48 CST 2020
     */
    List<RoleUrl> selectByExample(RoleUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_url
     *
     * @mbg.generated Tue Nov 03 17:36:48 CST 2020
     */
    RoleUrl selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_url
     *
     * @mbg.generated Tue Nov 03 17:36:48 CST 2020
     */
    int updateByExampleSelective(@Param("record") RoleUrl record, @Param("example") RoleUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_url
     *
     * @mbg.generated Tue Nov 03 17:36:48 CST 2020
     */
    int updateByExample(@Param("record") RoleUrl record, @Param("example") RoleUrlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_url
     *
     * @mbg.generated Tue Nov 03 17:36:48 CST 2020
     */
    int updateByPrimaryKeySelective(RoleUrl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table role_url
     *
     * @mbg.generated Tue Nov 03 17:36:48 CST 2020
     */
    int updateByPrimaryKey(RoleUrl record);
}