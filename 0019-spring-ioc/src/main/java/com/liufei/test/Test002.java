package com.liufei.test;

import com.liufei.ExClassPathXmlApplicationContext;
import com.liufei.service.UserService;

/**
 * @Auther: liufei
 * @Date: 2020/07/25/5:18 下午
 * @Description:
 */
public class Test002 {

    public static void main(String[] args) throws Exception {
        ExClassPathXmlApplicationContext applicationContext = new ExClassPathXmlApplicationContext("com.liufei");
        UserService userServiceImpl = (UserService) applicationContext.getBean("userServiceImpl");
        System.out.println(userServiceImpl);
        userServiceImpl.add();
    }
}
