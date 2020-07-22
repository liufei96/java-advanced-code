//package com.liufei.proxy;
//
//import com.liufei.service.UserService;
//
//// 使用静态代理
//public class UserServiceProxy implements UserService {
//
//    // 目标对象
//    private UserService target;
//
//    public UserServiceProxy (UserService userService) {
//        this.target = userService;
//    }
//
//    public void add() {
//        System.out.println("开启事务");
//        target.add();
//        System.out.println("结束事务");
//    }
//
//    public void insert() {
//
//    }
//}
