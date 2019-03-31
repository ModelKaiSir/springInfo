package com.spring.proxy;

public class PerformanceMonitor {

    private static ThreadLocal<MethodPerformance> locals = new ThreadLocal<>();

    public static void begin(String method){
        System.out.println("begin monitor....");
        MethodPerformance p = new MethodPerformance(method);
        locals.set(p);
    }

    public static void end(){
        System.out.println("end monitor....");
        MethodPerformance p = locals.get();
        p.printPerformance();
    }
}
