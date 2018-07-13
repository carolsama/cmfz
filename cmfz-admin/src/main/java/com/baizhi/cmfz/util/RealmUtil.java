package com.baizhi.cmfz.util;

import com.baizhi.cmfz.entity.Manager;
import com.baizhi.cmfz.entity.SysPermission;
import com.baizhi.cmfz.entity.SysRole;
import com.baizhi.cmfz.service.ManagerService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.UUID;

/**
 * @Description 权限验证
 * @Author Administrator
 * @Time 2018/7/12 20:34
 */

public class RealmUtil extends AuthorizingRealm{

    @Autowired
    private ManagerService managerService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        String username = (String) principalCollection.getPrimaryPrincipal();
        List<SysRole> roles = managerService.queryRolesByMgrName(username);
        // 封装查询到的授权信息对象
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for (SysRole role : roles) {
            // 将角色标签保存到返回值
            info.addRole(role.getRoleTag());
        }
        List<SysPermission> permissions = managerService.queryResourceByMgrName(username);
        for (SysPermission permission : permissions) {
            info.addStringPermission(permission.getPermissionTag());
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        Manager manager = managerService.queryManagerByName(username);
        if(manager != null){
            return new SimpleAuthenticationInfo(manager.getMgr_name(),
                    manager.getMgr_pwd(),
                    ByteSource.Util.bytes(manager.getMgr_salt()),
                    UUID.randomUUID().toString());
        }
        return null;
    }
}
