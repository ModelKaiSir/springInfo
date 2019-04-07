package com.spring.proxy.aspect.obj;

public interface WaiterInter extends WaiterManager {

    void greetTo(String clientName);
    void serveTo(String clientName);

}
