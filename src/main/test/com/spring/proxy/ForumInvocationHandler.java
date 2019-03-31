package com.spring.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ForumInvocationHandler implements InvocationHandler {

    private Object source;

    public ForumInvocationHandler(Object source) {
        this.source = source;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        IsProxy p = method.getAnnotation(IsProxy.class);
        boolean isProxy = false;
        if(null!=p){
            System.out.println("启用代理");
            isProxy = p.isProxy();
        }else{
            System.out.println("不起用代理");
        }

        if(isProxy)
            PerformanceMonitor.begin(proxy.getClass().getName()+":"+method.getName());
        Object obj = method.invoke(source,args);
        if(isProxy)
            PerformanceMonitor.end();
        return obj;
    }
}
