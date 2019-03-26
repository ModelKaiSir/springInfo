package com.spring.dao;

import com.spring.domain.LoginLog;
import com.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDao {

    @Autowired
    private JdbcTemplate template;

    public void insertLoginLog(LoginLog log) {
        String insert = "INSERT INTO t_login_log VALUES (?,?,?,?)";
        template.update(insert, new Object[]{ log.getLongLogId(), log.getUserId(), log.getIp(), log.getLoginDateTime() });
    }
}
