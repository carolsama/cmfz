package com.baizhi.cmfz.entity;

import java.io.Serializable;

/**
 * @Description 权限表
 * @Author Administrator
 * @Time 2018/7/12 14:45
 */
public class SysPermission implements Serializable{
    private Integer resourceId;
    private String resourceName;
    private String resourceTag;
    private String resourceUrl;
    private String permissionTag;

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceTag() {
        return resourceTag;
    }

    public void setResourceTag(String resourceTag) {
        this.resourceTag = resourceTag;
    }

    public String getResourceUrl() {
        return resourceUrl;
    }

    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl;
    }

    public String getPermissionTag() {
        return permissionTag;
    }

    public void setPermissionTag(String permissionTag) {
        this.permissionTag = permissionTag;
    }

    public SysPermission(Integer resourceId, String resourceName, String resourceTag, String resourceUrl, String permissionTag) {
        this.resourceId = resourceId;
        this.resourceName = resourceName;
        this.resourceTag = resourceTag;
        this.resourceUrl = resourceUrl;
        this.permissionTag = permissionTag;
    }

    public SysPermission() {
        super();
    }

    @Override
    public String toString() {
        return "SysPermission{" +
                "resourceId=" + resourceId +
                ", resourceName='" + resourceName + '\'' +
                ", resourceTag='" + resourceTag + '\'' +
                ", resourceUrl='" + resourceUrl + '\'' +
                ", permissionTag='" + permissionTag + '\'' +
                '}';
    }
}
