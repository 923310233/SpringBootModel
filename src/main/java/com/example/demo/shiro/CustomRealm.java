package com.example.demo.shiro;

import com.example.demo.database.dao.UserDOMapper;
import com.example.demo.database.dao.UserRoleDOMapper;
import com.example.demo.database.dataObject.UserDO;
import com.example.demo.database.dataObject.UserDOExample;
import com.example.demo.database.dataObject.UserRoleDO;
import com.example.demo.database.dataObject.UserRoleDOExample;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/27 5:43 PM
 * @Description 自定义 Realm
 * @Version 1.0
 */

@Component
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private UserRoleDOMapper userRoleDOMapper;

    @Autowired
    private UserDOMapper userDOMapper;

    /**
     * 获取身份验证信息
     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
     *
     * @param authenticationToken 用户身份信息 token
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("————身份认证方法————");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        // 从数据库获取对应用户名密码的用户
        UserDOExample userDOExample = new UserDOExample();
        userDOExample.createCriteria().andAccountEqualTo(token.getUsername());
        List<UserDO> userDOS = userDOMapper.selectByExample(userDOExample);
        String password = null;
        if (!userDOS.isEmpty()) {
            password = userDOS.get(0).getPassword();
        }
        if (null == password) {
            throw new AccountException("用户名不正确");
        } else if (!password.equals(new String((char[]) token.getCredentials()))) {
            throw new AccountException("密码不正确");
        }
        return new SimpleAuthenticationInfo(token.getPrincipal(), password, getName());
    }


    /**
     * 获取授权信息
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("————权限认证————");
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获得该用户角色
        UserRoleDOExample userRoleDOExample = new UserRoleDOExample();
        userRoleDOExample.createCriteria().andAccountEqualTo(username);
        List<UserRoleDO> userRoleDOS = userRoleDOMapper.selectByExample(userRoleDOExample);

        String role = null;
        if (!userRoleDOS.isEmpty()) {
            role = userRoleDOS.get(0).getRole();
        }

        Set<String> set = new HashSet<>();
        //需要将 role 封装到 Set 作为 info.setRoles() 的参数
        set.add(role);
        //设置该用户拥有的角色
        info.setRoles(set);
        return info;
    }



}
