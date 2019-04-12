package com.spring.proxy.aspect;

import com.spring.proxy.NaiveWaiter;
import com.spring.proxy.Supplier;
import com.spring.proxy.Waiter;
import com.spring.proxy.aspect.obj.NaiveWaiterInter;
import com.spring.proxy.aspect.obj.Seller;
import com.spring.proxy.aspect.obj.WaiterInter;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.testng.annotations.Test;

public class AspectJProxyTest {

    static final String classPath = "classpath:aspect.xml";

    @Test
    public void beforeTest(){

        Waiter target = new NaiveWaiter();
        AspectJProxyFactory factory = new AspectJProxyFactory();

        factory.setTarget(target);
        factory.addAspect(PreGreetingAspect.class);
        Waiter proxy = factory.getProxy();

        proxy.greetTo("QiuKai");
        proxy.serveTo("QiuKai");

    }

    @Test
    public void applicationContextTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext(classPath);

        NaiveWaiter waiter = (NaiveWaiter) context.getBean("waiter");
        waiter.greetTo("QiuKai");
        waiter.serveTo("QiuKai");

        // DeclareParents
        Supplier supplier = (Supplier) waiter;

        supplier.sell("Good");
    }

    @Test
    public void pointcut(){
        ApplicationContext context = new ClassPathXmlApplicationContext(classPath);

        NaiveWaiterInter naiveWaiter = (NaiveWaiterInter) context.getBean("naiveWaiter");

        naiveWaiter.smile("QiuKai",19);
    }

    @Test
    public void after(){
        ApplicationContext context = new ClassPathXmlApplicationContext(classPath);

        Seller seller = (Seller) context.getBean("seller");

        seller.sell("Water","QiuKai");
    }
}
