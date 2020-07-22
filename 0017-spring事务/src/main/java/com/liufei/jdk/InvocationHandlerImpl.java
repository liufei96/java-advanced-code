package com.liufei.jdk;

import com.liufei.service.UserService;
import com.liufei.service.impl.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class InvocationHandlerImpl implements InvocationHandler {

    private Object target;

    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--- jdk动态代理：开启事务 ---");
        Object invoke = method.invoke(target, args);
        System.out.println("--- jdk动态代理：关闭事务 ---");
        return invoke;
    }

    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        InvocationHandlerImpl handler = new InvocationHandlerImpl(userService);
        ClassLoader classLoader = userService.getClass().getClassLoader();
        Class<?>[] interfaces = userService.getClass().getInterfaces();
        UserService proxyInstance = (UserService) Proxy.newProxyInstance(classLoader, interfaces, handler);
        proxyInstance.add();
    }
}
