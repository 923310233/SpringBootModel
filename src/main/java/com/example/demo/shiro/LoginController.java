package com.example.demo.shiro;

import com.example.demo.database.dao.UserDOMapper;
import com.example.demo.database.dao.UserRoleDOMapper;
import com.example.demo.database.dataObject.UserRoleDO;
import com.example.demo.database.dataObject.UserRoleDOExample;
import com.example.demo.shiro.Model.ResultMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: 吴硕涵
 * @Date: 2018/11/27 4:34 PM
 * @Version 1.0
 */

@RestController
public class LoginController {

    @Autowired
    private ResultMap resultMap;
    @Autowired
    private UserDOMapper userDOMapper;
    @Autowired
    private UserRoleDOMapper userRoleDOMapper;

    @RequestMapping(value = "/notLogin")
    public ResultMap notLogin() {
        return resultMap.success().message("您尚未登陆！");
    }

    @RequestMapping(value = "/notRole")
    public ResultMap notRole() {
        return resultMap.success().message("您没有权限！");
    }

    @RequestMapping(value = "/logout")
    public ResultMap logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return resultMap.success().message("成功注销！");
    }

    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultMap login(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆
        subject.login(token);
        //根据权限，指定返回数据
        UserRoleDOExample userRoleDOExample = new UserRoleDOExample();
        userRoleDOExample.createCriteria().andAccountEqualTo(username);
        List<UserRoleDO> userRoleDOS = userRoleDOMapper.selectByExample(userRoleDOExample);

        String role = null;
        if (!userRoleDOS.isEmpty()) {
            role = userRoleDOS.get(0).getRole();
        }

        if ("user".equals(role)) {
            return resultMap.success().message("欢迎登陆");
        }
        if ("admin".equals(role)) {
            return resultMap.success().message("欢迎来到管理员页面");
        }
        return resultMap.fail().message("权限错误！");
    }

}
