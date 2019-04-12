package com.spring.proxy.aspect.obj;

public class SmartSeller implements Seller{

    @Override
    public int sell(String goods, String clientName) {
        System.out.println("SmartSeller sell :"+goods+" to "+clientName);
        return 0;
    }

    protected int showGood(String goods){
        System.out.println("SmartSeller showGoods :"+goods);
        return 0;
    }
}
