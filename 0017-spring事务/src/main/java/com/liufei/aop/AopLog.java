package com.liufei.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 切面类
//@Component
//@Aspect
public class AopLog {

    // aop中的通知，前置通知，后置通知，运行通知，异常通知，环绕通知
    @Before("execution(* com.liufei.spring.service.UserService.insert(..))")
    public void before() {
        System.out.println("前置通知");
    }

    @After("execution(* com.liufei.spring.service.UserService.insert(..))")
    public void after() {
        System.out.println("后置通知");
    }

    @AfterReturning("execution(* com.liufei.spring.service.UserService.insert(..))")
    public void afterReturning() {
        System.out.println("运行结束后通知");
    }

    @AfterThrowing("execution(* com.liufei.spring.service.UserService.insert(..))")
    public void afterThrowing() {
        System.out.println("异常通知");
    }

    @Around("execution(* com.liufei.spring.service.UserService.insert(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕前通知");
        // 这里如果跑出异常，不会走下面的
        point.proceed();
        System.out.println("环绕后通知");
    }
}
