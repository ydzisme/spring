package com.ydzstu.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T1 {
    @Test
    public void T1(){
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        Object pooledDateSource = ioc.getBean("pooledDateSource");
        System.out.println(pooledDateSource);
    }
}
