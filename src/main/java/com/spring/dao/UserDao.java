package com.spring.dao;

import com.spring.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate template;

    public int getMatchCount(String userName, String passWord) {
        String query = "SELECT COUNT(*) FROM T_USER WHERE USER_NAME = ? AND PASSWORD = ? ";
        int i = template.queryForObject(query, Integer.class, userName, passWord);
        return i;
    }

    public User findUserByUserName(final String userName) {
        final User user = new User();
        String query = "SELECT user_id,credits FROM T_USER WHERE USER_NAME = ?";
        template.query(query, new Object[]{ userName }, new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserName(userName);
                user.setUserId(resultSet.getInt("user_id"));
                user.setCredits(resultSet.getInt("credits"));
            }
        });
        return user;
    }

    public void updateUserInfo(User user) {
        String update = "UPDATE T_USER SET LAST_VISIT = ?,LAST_IP = ?,CREDITS = ? WHERE USER_ID = ?";
        template.update(update, user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId());
    }
}
