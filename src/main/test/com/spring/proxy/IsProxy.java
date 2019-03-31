package com.spring.proxy;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface IsProxy {

    boolean isProxy() default true;
}
