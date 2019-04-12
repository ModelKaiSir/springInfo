package com.spring.proxy.aspect.obj;

public class NaiveWaiterInter implements WaiterInter{

    @Override
    public void greetTo(String clientName) {
        System.out.println("NaiveWaiterInter greet to "+clientName);
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println("NaiveWaiterInter serve to "+clientName);
    }

    public void smile(){
        System.out.println("NaiveWaiterInter smile ");
    }

    public void smile(String clientName,int i){
        System.out.println("NaiveWaiterInter smile to "+clientName+" : "+i);
    }
}
