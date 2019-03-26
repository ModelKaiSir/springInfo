package com.spring.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {

        if("car".equals(s)){
            System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization");
            Car c = (Car) o;
            if(null==c.getColor()){
                System.out.println("没有颜色");
                c.setColor("黑色");
            }

        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if("car".equals(s)){
            System.out.println("MyBeanPostProcessor.postProcessAfterInitialization");
        }
        return null;
    }
}
