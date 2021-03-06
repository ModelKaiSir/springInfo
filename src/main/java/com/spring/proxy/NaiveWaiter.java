package com.spring.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

public class NaiveWaiter implements Waiter {

    @Override
    public void greetTo(String name) {
        System.out.println("greet To "+name);
    }

    @Override
    public void serveTo(String name) {
        System.out.println("serveTo To "+name);
    }
}
