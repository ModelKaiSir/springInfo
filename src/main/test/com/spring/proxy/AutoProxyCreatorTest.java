package com.spring.proxy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AutoProxyCreatorTest {

    static final String classPath = "classpath:proxyCreator.xml";

    @Test
    public void beanNameAutoProxyCreator(){

        ApplicationContext context = new ClassPathXmlApplicationContext(classPath);

       NaiveWaiter waiter =  BeforeAdviceTest.getInstance(NaiveWaiter.class,context.getBean("waiter"));
        waiter.greetTo("QiuKai");
        waiter.serveTo("QiuKai");
    }

    @Test
    public void DefaultAutoProxyCreator(){

        ApplicationContext context = new ClassPathXmlApplicationContext(classPath);

       NaiveWaiter waiter = (NaiveWaiter) context.getBean("waiter");
       waiter.greetTo("QiuKai");
       waiter.serveTo("QiuKai");
       NaiveSeller seller = (NaiveSeller)context.getBean("seller");
       seller.greetTo("Tom");
        seller.serveTo("Tom");
    }
}
