package com.liufei.spring.service.impl;

import com.liufei.spring.annotation.ExtTransaction;
import com.liufei.spring.dao.UserDao;
import com.liufei.spring.service.LogService;
import com.liufei.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LogService logService;

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public void insert() {
//        try {
//            userDao.insert("liufei");
//            int i = 1 / 0;
//            System.out.println("===============");
//            userDao.insert("lihuihui");
//        } catch (Exception e) {
//            e.printStackTrace();
//            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//        }
//    }




    @Override
    @Transactional
    public void insert() {
        logService.addLog();
        userDao.insert("liufei");
        int i = 1 / 0;
        System.out.println("===============");
        userDao.insert("lihuihui");
    }

    @Override
    @ExtTransaction
    public void update() {
        userDao.update(16, "刘飞");
        System.out.println("===============");
        userDao.update(17, "李慧慧");
    }
}
