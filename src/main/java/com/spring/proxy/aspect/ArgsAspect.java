package com.spring.proxy.aspect;

import com.spring.proxy.Waiter;
import com.spring.proxy.aspect.obj.WaiterInter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

@Aspect
public class ArgsAspect {

    @Before("target(com.spring.proxy.aspect.obj.NaiveWaiterInter) && args(clientName,i) && this(waiter)")
    public void bindJoinPointParams(JoinPoint jp, WaiterInter waiter, String clientName, int i){
        System.out.println("--------bindJoinPointParams()--------");
        System.out.println(Arrays.deepToString(jp.getArgs()));
        System.out.println(jp.getTarget().getClass());
        System.out.println(waiter.getClass());
        System.out.println("clientName:"+clientName);
        System.out.println("i:"+i);
        System.out.println("--------bindJoinPointParams()--------");
    }
}

