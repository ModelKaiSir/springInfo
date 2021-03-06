package com.spring.domain;

import javafx.fxml.Initializable;

import java.io.Serializable;
import java.util.Date;
/**
 *
 * @author QiuKai
 */
public class User implements Serializable {

    private int userId;
    private String userName;
    private String passWord;
    private int credits;

    private String lastIp;
    private Date lastVisit;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public boolean isVipMember(String userName){
        return userName.equals("Tom") || userName.equals("QiuKai");
    }
}
