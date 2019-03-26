package com.spring.domain;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;

import java.beans.PropertyDescriptor;

public class MyInnstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {

    @Override
    public Object postProcessBeforeInstantiation(Class<?> aClass, String s) throws BeansException {

        if("car".equals(s)){
            System.out.println("car InstantiationAwareBeanPostProcessor.postProcessBeforeInstantiation");
        }

        return null;
    }

    @Override
    public boolean postProcessAfterInstantiation(Object o, String s) throws BeansException {

        if("car".equals(s)){
            System.out.println("car InstantiationAwareBeanPostProcessor.postProcessAfterInstantiation");
        }

        return true;
    }

    @Override
    public PropertyValues postProcessPropertyValues(PropertyValues propertyValues, PropertyDescriptor[] propertyDescriptors, Object o, String s) throws BeansException {
        return propertyValues;
    }

    @Override
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        if("car".equals(s)){
            System.out.println("car InstantiationAwareBeanPostProcessor.postProcessBeforeInitialization ");
        }
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        if("car".equals(s)){
            System.out.println("car InstantiationAwareBeanPostProcessor.postProcessAfterInitialization");
        }
        return null;
    }
}
