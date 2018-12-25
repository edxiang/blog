package org.kevin.blog.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Kevin.Z
 * @version 2018-12-25
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public int login(@RequestParam(value = "username") String username,
                     @RequestParam(value = "password") String password) {
        Subject subject = SecurityUtils.getSubject();
        // 判断是否已经登陆
        //subject.isAuthenticated();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            token.clear();
            e.printStackTrace();
            return 0;
        }

        return 1;
    }
}
