package com.liufei.service.impl;

import com.liufei.annotation.ExResource;
import com.liufei.annotation.ExService;
import com.liufei.service.OrderService;
import com.liufei.service.UserService;
/**
 * @Auther: liufei
 * @Date: 2020/07/25/12:05 下午
 * @Description:
 */
@ExService
public class UserServiceImpl implements UserService {

    @ExResource
    private OrderService orderServiceImpl;

    @Override
    public void add() {
        orderServiceImpl.addOrder();
        System.out.println("userService中的添加方法");
    }
}
