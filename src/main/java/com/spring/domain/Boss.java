package com.spring.domain;

public class Boss {

    private String name;
    private Car c = new Car();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getC() {
        return c;
    }

    public void setC(Car c) {
        this.c = c;
    }
}
