package com.spring.proxy.aspect;

import org.aspectj.lang.annotation.Aspect;


/**
 * execution
 *  execution(public * *(..))
 *  execution(* *To(..))
 *  execution(* com.spring.proxy.aspect.obj.WaiterInter.*(..))
 *  execution(* com.spring.proxy.aspect.obj.WaiterInter+.*(..))
 *
 */
@Aspect
public class FunAspect {

    /**
     * execution(public * *(..)) 匹配所有目标类的public方法 不限返回类型 不限参数
     * execution(* *To(..)) 匹配所有目标类的To结尾方法 不限返回类型 不限参数
     * execution(* com.spring.proxy.aspect.obj.WaiterInter.*(..)) 匹配所有WaiterInter接口实现类的接口实现方法
     * execution(* com.spring.proxy.aspect.obj.WaiterInter+.*(..)) 匹配所有WaiterInter接口实现类的所有方法
     *
     * execution(* com.spring.*(..)) 匹配com.spring包下面的所有类的所有的方法 不限返回类型 不限参数
     * execution(* com.spring..*(..)) 匹配com.spring包及其子孙包下面的所有类的所有的方法 不限返回类型 不限参数
     * execution(* com.spring..*.*Dao.find*(..)) 匹配com.spring包前缀 Dao包后缀 包下面的所有类的以find开头的方法 不限返回类型 不限参数
     *
     * execution(* joke(..))
     * execution(* joke(*))
     * execution(* joke(String,*))
     * execution(* joke(String,..))
     * execution(* joke(String,int))
     * execution(* joke(Object))
     * execution(* joke(Object+))
     */
    public void info(){

    }

}
