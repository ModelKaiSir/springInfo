package com.spring.proxy;

/**
 * 流程切面测试 通过该类代理waiter的调用
 */
public class WaiterDelegate {

    private Waiter waiter;

    /**
     * 只有通过该方法调用的waiter方法才会被添加切面
     * @param clientName
     */
    public void service(String clientName){
        waiter.greetTo(clientName);
        waiter.serveTo(clientName);
    }

    public void setWaiter(Waiter waiter) {
        this.waiter = waiter;
    }
}
