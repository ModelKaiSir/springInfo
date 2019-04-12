package com.spring.proxy.aspect;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

/**
 * 注解切面
 */
@Aspect
public class TestAspect {


    /**
     * 后置增强 匹配标注了NeedTest注解的方法
     */
    @AfterReturning("@annotation(com.spring.anno.NeedTest)")
    public void needTestFun(){
        System.out.println("needTestFun() executed!");
    }
}
