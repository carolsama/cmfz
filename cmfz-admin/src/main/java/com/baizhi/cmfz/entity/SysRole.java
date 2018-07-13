package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 角色实体类
 * @Author Administrator
 * @Time 2018/7/12 14:40
 */
public class SysRole implements Serializable{
    private Integer roleId;
    private String roleName;
    private String roleTag;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleTag() {
        return roleTag;
    }

    public void setRoleTag(String roleTag) {
        this.roleTag = roleTag;
    }

    public SysRole(Integer roleId, String roleName, String roleTag) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleTag = roleTag;
    }

    public SysRole() {
        super();
    }

    @Override
    public String toString() {
        return "SysRole{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleTag='" + roleTag + '\'' +
                '}';
    }
}
