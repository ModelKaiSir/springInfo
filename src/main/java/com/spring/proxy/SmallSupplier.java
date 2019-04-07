package com.spring.proxy;

public class SmallSupplier implements Supplier {

    @Override
    public void sell(String good) {
        System.out.println("Good :"+good);
    }
}
