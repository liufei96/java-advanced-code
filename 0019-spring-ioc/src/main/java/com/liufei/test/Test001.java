package com.liufei.test;

import com.liufei.MyClassPathXmlApplicationContext;
import com.liufei.entity.User;

/**
 * @Auther: liufei
 * @Date: 2020/07/25/10:08 上午
 * @Description:
 */
public class Test001 {
    public static void main(String[] args) throws Exception {
        MyClassPathXmlApplicationContext applicationContext = new MyClassPathXmlApplicationContext("spring.xml");
        User user = (User) applicationContext.getBean("user");
        String userName = user.getUserName();
        System.out.println(userName);
    }
}
