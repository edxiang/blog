package org.kevin.blog.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kevin.Z
 * @version 2018-12-25
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, ModelMap modelMap) {
        Subject subject = SecurityUtils.getSubject();
        // 判断是否已经登陆
        boolean isAuth = subject.isAuthenticated();
        System.out.println(isAuth);
        UsernamePasswordToken token = new UsernamePasswordToken(request.getParameter("username"), request.getParameter("password"));
        try {
            subject.login(token);
            String originalUrl = WebUtils.getSavedRequest(request).getRequestUrl();
            return "redirect:" + originalUrl;
        } catch (AuthenticationException e) {
            token.clear();
            e.printStackTrace();
            modelMap.addAttribute("unauthority", true);
            return "signin";
        }
    }
}
