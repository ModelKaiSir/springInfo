package com.spring.proxy;

import org.springframework.aop.Pointcut;
import org.springframework.aop.support.ComposablePointcut;
import org.springframework.aop.support.ControlFlowPointcut;
import org.springframework.aop.support.NameMatchMethodPointcut;

public class GreetingComposablePointcut {

    public Pointcut getIntersectionPointcut(){

        ComposablePointcut pointcut = new ComposablePointcut();

        Pointcut pt1 = new ControlFlowPointcut(WaiterDelegate.class,"service");
        Pointcut pt2 = new NameMatchMethodPointcut();
        ((NameMatchMethodPointcut) pt2).addMethodName("greetTo");

        return pointcut.intersection(pt1).intersection(pt2);
    }
}
