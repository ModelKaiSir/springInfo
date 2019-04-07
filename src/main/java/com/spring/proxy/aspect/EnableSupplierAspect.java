package com.spring.proxy.aspect;

import com.spring.proxy.NaiveWaiter;
import com.spring.proxy.SmallSupplier;
import com.spring.proxy.Supplier;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
@Aspect
public class EnableSupplierAspect {

    @DeclareParents(value = "com.spring.proxy.NaiveWaiter",defaultImpl = SmallSupplier.class)
    public Supplier supplier;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:aspect.xml");

        NaiveWaiter waiter = (NaiveWaiter) context.getBean("waiter");
        waiter.greetTo("QiuKai");
        waiter.serveTo("QiuKai");

        // DeclareParents
        Supplier supplier = (Supplier) waiter;

        supplier.sell("Good");
    }
}
