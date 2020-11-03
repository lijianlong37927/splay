package com.yumu.dto;

import java.util.Date;

public class RoleInfo {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.role_id
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    private String roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.role_name
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    private String roleName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.state
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    private Integer state;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.create_user
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.create_datetime
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    private Date createDatetime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.update_user
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    private String updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column role_info.update_datetime
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    private Date updateDatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.role_id
     *
     * @return the value of role_info.role_id
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.role_id
     *
     * @param roleId the value for role_info.role_id
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.role_name
     *
     * @return the value of role_info.role_name
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.role_name
     *
     * @param roleName the value for role_info.role_name
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.state
     *
     * @return the value of role_info.state
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public Integer getState() {
        return state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.state
     *
     * @param state the value for role_info.state
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.create_user
     *
     * @return the value of role_info.create_user
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.create_user
     *
     * @param createUser the value for role_info.create_user
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.create_datetime
     *
     * @return the value of role_info.create_datetime
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public Date getCreateDatetime() {
        return createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.create_datetime
     *
     * @param createDatetime the value for role_info.create_datetime
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.update_user
     *
     * @return the value of role_info.update_user
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.update_user
     *
     * @param updateUser the value for role_info.update_user
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column role_info.update_datetime
     *
     * @return the value of role_info.update_datetime
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column role_info.update_datetime
     *
     * @param updateDatetime the value for role_info.update_datetime
     *
     * @mbg.generated Tue Nov 03 08:40:35 CST 2020
     */
    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}