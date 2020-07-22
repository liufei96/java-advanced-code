package com.liufei.aop;

import com.liufei.service.UserService;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Aop2Main {

    public static void main(String[] args) {
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.insert();
    }
}
