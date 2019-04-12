package com.spring.proxy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class AroundAspect {

    @Around("execution(* greetTo(..)) && target(com.spring.proxy.aspect.obj.NaiveWaiterInter))")
    public void joinPointAccess(ProceedingJoinPoint jp) throws Throwable{
        System.out.println("---------JoinPointAccess-----------");
        System.out.println("args[0]:"+jp.getArgs()[0]);
        System.out.println("signature:"+jp.getTarget().getClass());
        jp.proceed();
        System.out.println("---------JoinPointAccess-----------");
    }
}
