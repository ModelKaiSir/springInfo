package com.spring.proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ForumProxy implements MethodInterceptor {

    private Enhancer enhancer = new Enhancer();

    public Object getProxy(Class clazz){
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        PerformanceMonitor.begin(o.getClass().getName()+":"+method.getName());
        Object result = methodProxy.invokeSuper(o,objects);
        PerformanceMonitor.end();
        return result;
    }


    @Test
    public void startServices(){

        ForumServiceTs service = new ForumServiceImpl();
        ForumInvocationHandler handler = new ForumInvocationHandler(service);
        ForumServiceTs proxy = (ForumServiceTs) Proxy.newProxyInstance(service.getClass().getClassLoader(),service.getClass().getInterfaces(),handler);

        proxy.removeForum(1390);
        proxy.removeTopic(1283);
        proxy.my();
    }

    @Test
    public void startServicesProxy(){

        ForumProxy proxy = new ForumProxy();
        ForumServiceTs service = (ForumServiceTs) proxy.getProxy(ForumServiceImpl.class);

        service.removeForum(1390);
        service.removeTopic(1283);
        service.my();
    }
}
