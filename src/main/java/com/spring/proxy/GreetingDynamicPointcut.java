package com.spring.proxy;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * Spring动态切面
 * @author QiuKai
 */
public class GreetingDynamicPointcut extends DynamicMethodMatcherPointcut {

    private static List<String> specialClientList = new ArrayList<>();

    static {
        specialClientList.add("John");
        specialClientList.add("Tom");
        specialClientList.add("QiuKai");
    }

    @Override
    public ClassFilter getClassFilter() {
        return new ClassFilter() {
            @Override
            public boolean matches(Class<?> aClass) {
                return NaiveWaiter.class.isAssignableFrom(aClass);
            }
        };
    }


    /**
     * 静态检查
     * @param method
     * @param clazz
     * @return
     */
    public boolean matches(Method method,Class clazz){
        System.out.println("调用matches(method,clazz)"+clazz.getName()+"."+method.getName()+"做静态检查。");
        return "greetTo".equals(method.getName());
    }

    /**
     * 动态检查
     * @param method
     * @param aClass
     * @param objects
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> aClass, Object... objects) {
        System.out.println("调用matches(method,clazz)"+aClass.getName()+"."+method.getName()+"做动态检查。");
        String clientName = (String) objects[0];
        System.out.println(clientName);
        return specialClientList.contains(clientName);
    }
}
