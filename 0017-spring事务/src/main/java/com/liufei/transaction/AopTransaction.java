//package com.liufei.transaction;
//
//import com.liufei.utils.TransactionUtils;
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.TransactionStatus;
//import org.springframework.transaction.interceptor.TransactionAspectSupport;
//
////@Component
////@Aspect
//public class AopTransaction {
//
//    @Autowired
//    private TransactionUtils transactionUtils;
//
//    @Around("execution(* com.liufei.spring.service.UserService.*(..))")
//    public void around(ProceedingJoinPoint point) throws Throwable {
//        System.out.println("开启事务");
//        TransactionStatus transactionStatus = transactionUtils.begin();
//        point.proceed();
//        System.out.println("提交事务");
//        transactionUtils.commit(transactionStatus);
//    }
//
//    @AfterThrowing("execution(* com.liufei.spring.service.UserService.*(..))")
//    public void afterThrow() {
//        System.out.println("回滚事务");
//        TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
//    }
//}
