package com.spring.proxy;

import java.util.concurrent.TimeUnit;

public class ForumServiceImpl implements ForumServiceTs{

    @Override
    public void removeTopic(int topicId) {
        // PerformanceMonitor.begin(ForumServiceImpl.class.getName()+":removeTopic");

        try {
            System.out.println("模拟删除删除topic记录："+topicId);
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //PerformanceMonitor.end();
    }

    @Override
    public void removeForum(int forumId) {
        // PerformanceMonitor.begin(ForumServiceImpl.class.getName()+":removeForum");
        try {
            System.out.println("模拟删除删除forum记录："+forumId);
            TimeUnit.MILLISECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //PerformanceMonitor.end();
    }

    public void my(){
        System.out.println("my");
    }

}
