package com.spring.services;

import com.spring.dao.LoginDao;
import com.spring.dao.UserDao;
import com.spring.domain.LoginLog;
import com.spring.domain.User;
import com.sun.org.apache.xpath.internal.SourceTree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private LoginDao loginDao;

    public boolean hasMatchUser(String userName,String passWord){
        int count = userDao.getMatchCount(userName,passWord);
        return count>0;
    }

    public User findUserByName(String userName){
        return userDao.findUserByUserName(userName);
    }

    @Transactional()
    public void loginSuccess(User user){
        user.setCredits(5+user.getCredits());

        LoginLog log = new LoginLog();
        log.setIp(user.getLastIp());
        log.setUserId(user.getUserId());
        log.setLoginDateTime(user.getLastVisit());

        userDao.updateUserInfo(user);
        loginDao.insertLoginLog(log);
    }
}
