package com.liufei.service.impl;

import com.liufei.service.UserService;
import com.liufei.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public void add() {
        //System.out.println("开启事务");
        System.out.println("添加数据");
        //System.out.println("关闭事务");
    }

    public void insert() {
        try {
            userDao.insert("liufei");
            int i = 1 / 0;
            System.out.println("===============");
            userDao.insert("lihuihui");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
