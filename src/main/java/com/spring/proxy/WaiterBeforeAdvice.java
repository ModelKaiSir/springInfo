package com.spring.proxy;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class WaiterBeforeAdvice implements MethodBeforeAdvice {

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName()+":"+method.getName());
        String clientName = (String)objects[0];
        System.out.println("How are you! Mr."+clientName+".");
    }
}
