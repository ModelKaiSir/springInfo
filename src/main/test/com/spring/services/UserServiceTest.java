package com.spring.services;

import com.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration("classpath*:/applicationContext.xml")
public class UserServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    private UserService userService;

    @Autowired
    public void setUserService(UserService service){
        this.userService = service;
    }

    @Test
    public void hasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin","123456");
        boolean b2 = userService.hasMatchUser("admin","111");

        assert b1;
        assert !b2;
    }

    @Test
    public void findUserByName(){
        User user = userService.findUserByName("admin");
        assert user.getUserName().equals("admin");
    }
}
