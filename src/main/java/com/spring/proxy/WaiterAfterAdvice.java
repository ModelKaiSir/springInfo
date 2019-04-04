package com.spring.proxy;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class WaiterAfterAdvice implements AfterReturningAdvice {

    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("Please enjoy yourself!");
    }
}
