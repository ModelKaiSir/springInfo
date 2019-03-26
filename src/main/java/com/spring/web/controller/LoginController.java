package com.spring.web.controller;

import com.spring.domain.LoginCommand;
import com.spring.domain.User;
import com.spring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/loginCheck")
    public ModelAndView loginCheck(HttpServletRequest request, LoginCommand command){
        if(null!=command){
            boolean success = userService.hasMatchUser(command.getUserName(),command.getPassWord());
            if(success){
                User user = userService.findUserByName(command.getUserName());
                user.setLastIp(request.getLocalAddr());
                user.setLastVisit(new Date());
                userService.loginSuccess(user);
                request.getSession().setAttribute("user",user);
                return new ModelAndView("main");
            }
        }
        return new ModelAndView("login","error","用户名或密码错误");
    }
}
