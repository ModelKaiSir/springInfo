package com.spring.proxy;

import org.testng.annotations.Test;
import sun.misc.Perf;

import java.lang.reflect.Proxy;
import java.util.concurrent.TimeUnit;

public class ForumServiceImpl implements ForumService{

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

    @Test
    public void startServices(){

        ForumService service = new ForumServiceImpl();
        ForumInvocationHandler handler = new ForumInvocationHandler(service);
        ForumService proxy = (ForumService) Proxy.newProxyInstance(service.getClass().getClassLoader(),service.getClass().getInterfaces(),handler);

        proxy.removeForum(1390);
        proxy.removeTopic(1283);
        proxy.my();
    }

    @Test
    public void startServicesProxy(){

        ForumProxy proxy = new ForumProxy();
        ForumService service = (ForumService) proxy.getProxy(ForumServiceImpl.class);

        service.removeForum(1390);
        service.removeTopic(1283);
        service.my();
    }
}
