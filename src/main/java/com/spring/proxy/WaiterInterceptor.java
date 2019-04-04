package com.spring.proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class WaiterInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        Object[] args = methodInvocation.getArguments();
        String clientName = (String) args[0];

        System.out.println("How are you "+clientName);

        Object obj = methodInvocation.proceed();

        System.out.println("Please Enjoy yourself!");
        return obj;
    }
}
