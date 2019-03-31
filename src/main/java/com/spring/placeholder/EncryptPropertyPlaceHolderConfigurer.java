package com.spring.placeholder;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

public class EncryptPropertyPlaceHolderConfigurer extends PropertyPlaceholderConfigurer {

    private String[] propertyNames = {"userName","passWord"};

    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        if(isEncrypt(propertyName)){
            System.out.println("测试解密属性:"+propertyValue);
            return propertyValue;
        }
        return propertyValue;
    }

    private boolean isEncrypt(String propertyName){
        for (String s: propertyNames) {
            if(s.equals(propertyName)){
                return true;
            }
        }
        return false;
    }
}
