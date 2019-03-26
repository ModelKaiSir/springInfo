package com.spring.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

public class Car implements BeanNameAware,BeanFactoryAware,BeanPostProcessor,InitializingBean,DisposableBean{

    private String brand;
    private String color;
    private int maxSpeed;

    private BeanFactory beanFactory;
    private String beanName;

    public Car() {
        System.out.println("初始化Car");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName:"+s);
        this.beanName = s;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization :"+s);
        return o;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization :"+s);
        return o;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean Destroy");
    }

    public void myInit(){
        System.out.println("Bean My Init to MaxSpeed = 240");
        this.maxSpeed = 240;
    }

    public void myDestroy(){
        System.out.println("My Destroy");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
