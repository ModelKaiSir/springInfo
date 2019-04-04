package com.spring.proxy;

import java.sql.SQLException;

public class ForumService {

    public void removeForum(int id){
        throw new RuntimeException("运行时异常");
    }

    public void updateForum(int forum) throws Exception{
        throw new SQLException("数据更新异常");
    }

    public void removeTopic(int topicId){

    }
}
