package com.spring.proxy;

import org.springframework.aop.BeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class BeforeAdviceTest {

    @Test
    public void before(){

        Waiter target = new NaiveWaiter();

        BeforeAdvice advice = new WaiterBeforeAdvice();

        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);
        proxyFactory.addAdvice(advice);

        Waiter proxy = (Waiter) proxyFactory.getProxy();

        proxy.greetTo("QiuKai");
        proxy.serveTo("QiuKai");
    }

    @Test
    public void applicationBefore(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        Waiter w = (Waiter) context.getBean("waiter");
        w.greetTo("QiuKai");
        w.serveTo("QiuKai");
    }

    @Test
    public void applicationThrows(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        ForumService service = (ForumService) context.getBean("forum");
        try {
            service.updateForum(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void applicationInter(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");
        ForumServiceTs service = (ForumServiceTs) context.getBean("forumService");
        service.removeForum(10);
        service.removeTopic(1012);

        Monitorable monitorable = (Monitorable)service;
        monitorable.setMonitorActive(true);

        service.removeForum(10);
        service.removeTopic(1012);

    }

    @Test
    public void staticMethodAdvisor(){

        NaiveWaiter target = new NaiveWaiter();

        BeforeAdvice advice = new WaiterBeforeAdvice();
        GreetingAdvisor advisor = new GreetingAdvisor();
        advisor.setAdvice(advice);
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(target);
        proxyFactory.addAdvisor(advisor);

        NaiveWaiter proxy = (NaiveWaiter) proxyFactory.getProxy();

        proxy.greetTo("QiuKai");
        proxy.serveTo("QiuKai");
    }

    @Test
    public void staticMethodAdvisor4Spring(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:beans.xml");

        // waiter waiter2 waiter3
        Waiter b = getInstance(Waiter.class,context.getBean("waiter4"));
        b.greetTo("QiuKai");
        b.serveTo("QiuKai");

        WaiterDelegate de = new WaiterDelegate();
        de.setWaiter(b);
        de.service("QiuKai");

    }

    public static <T> T getInstance(Class<T> clazz,Object o){
        return (T) o;
    }

}
