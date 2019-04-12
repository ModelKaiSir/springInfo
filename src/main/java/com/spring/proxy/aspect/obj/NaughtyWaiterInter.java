package com.spring.proxy.aspect.obj;

import com.spring.anno.NeedTest;

public class NaughtyWaiterInter implements WaiterInter{

    @NeedTest
    @Override
    public void greetTo(String clientName) {
        System.out.println("NaughtyWaiterInter greet to "+clientName);
    }

    @Override
    public void serveTo(String clientName) {
        System.out.println("NaughtyWaiterInter serve to "+clientName);
    }

    public void joke(){
        System.out.println("NaughtyWaiterInter joke");
    }

    public void joke(String clientName,int i){
        System.out.println("NaughtyWaiterInter joke to "+clientName+" : "+i);
    }
}
