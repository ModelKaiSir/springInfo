package com.spring.proxy;

public class MethodPerformance {

    private long begin;
    private long end;

    private String serivcesMethod;

    public MethodPerformance(String serivcesMethod) {
        this.serivcesMethod = serivcesMethod;
        this.begin = System.currentTimeMillis();
    }

    public void printPerformance(){
        end = System.currentTimeMillis();
        long elapse = end - begin;

        System.out.println(serivcesMethod+" 花费："+elapse+"毫秒");
    }
}
