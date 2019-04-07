package com.spring.proxy;

public class NaiveSeller implements Waiter {
    @Override
    public void greetTo(String name) {
        System.out.println("greet To "+name);
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serveTo To "+name);
    }
}
