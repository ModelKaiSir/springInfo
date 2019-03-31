package com.spring.factoryTest;

import com.spring.domain.*;
import com.spring.edit.CustomCarEditor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.testng.annotations.Test;

import java.security.interfaces.RSAKey;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class BeanFactoryTest {

    @Test
    public void getBean() throws Exception {

        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource resource = resolver.getResource("classpath:beans.xml");

        System.out.println(resource.getURL());

        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(resource);

        factory.addBeanPostProcessor(new MyBeanPostProcessor());
        factory.addBeanPostProcessor(new MyInnstantiationAwareBeanPostProcessor());
        factory.registerCustomEditor(Car.class, CustomCarEditor.class);

        Boss boss = factory.getBean("boss", Boss.class);
        System.out.println(boss);
        factory.destroySingletons();
    }

    @Test
    public void createApplicationContext() {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Boss boss = context.getBean("boss", Boss.class);

        System.out.println(boss.getC().toString());
    }


    /**
     * bean的生命周期
     */
    @Test
    public void createApplicationContextAnnotation() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Beans.class);
        Car car = context.getBean("car", Car.class);

        System.out.println(car.getBrand());

        System.out.println(car.getColor());

        System.out.println(car.getMaxSpeed());

    }


    @Test
    public void i18n() throws Exception{

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        MessageSource msgSource = (MessageSource) context.getBean("myResource");
        Object[] params = {"QiuKai",new GregorianCalendar().getTime()};

        String a = "";

        for (int i = 0; i < 2; i++) {
            a = msgSource.getMessage("greeting.common",params, Locale.US);
            System.out.println(a);
            if (i == 1){
                break;
            }
            Thread.currentThread().sleep(20000);
        }

        a=msgSource.getMessage("greeting.morning",params, Locale.CHINA);
        System.out.println(a);
        a =msgSource.getMessage("greeting.afternoon",params, Locale.CHINA);
        System.out.println(a);

    }

}
