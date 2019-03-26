package com.spring.domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author QiuKai
 */
public class LoginLog implements Serializable{

    private long longLogId;
    private int userId;
    private String ip;
    private Date loginDateTime;


    public long getLongLogId() {
        return longLogId;
    }

    public void setLongLogId(long longLogId) {
        this.longLogId = longLogId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getLoginDateTime() {
        return loginDateTime;
    }

    public void setLoginDateTime(Date loginDateTime) {
        this.loginDateTime = loginDateTime;
    }
}
