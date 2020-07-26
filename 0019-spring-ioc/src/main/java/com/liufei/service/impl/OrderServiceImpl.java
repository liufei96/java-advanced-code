package com.liufei.service.impl;

import com.liufei.annotation.ExService;
import com.liufei.service.OrderService;

/**
 * @Auther: liufei
 * @Date: 2020/07/26/11:52 上午
 * @Description:
 */
@ExService
public class OrderServiceImpl implements OrderService {

    @Override
    public void addOrder() {
        System.out.println("add Order...");
    }
}
