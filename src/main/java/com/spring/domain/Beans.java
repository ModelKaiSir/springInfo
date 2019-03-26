package com.spring.domain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans{

    @Bean(name="car",initMethod = "myInit",destroyMethod = "myDestroy")
    public Car buildCar(){
        Car c = new Car();
        c.setBrand("WW");
        c.setColor("Red");
        c.setMaxSpeed(1);
        return c;
    }
}