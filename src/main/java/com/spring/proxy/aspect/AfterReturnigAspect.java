package com.spring.proxy.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AfterReturnigAspect {

    @AfterReturning(value = "target(com.spring.proxy.aspect.obj.SmartSeller)",returning = "rtval")
    public void print(int rtval){
        System.out.println("-------------print return value -------------");
        System.out.println(rtval);
        System.out.println("-------------print return value -------------");
    }
}
