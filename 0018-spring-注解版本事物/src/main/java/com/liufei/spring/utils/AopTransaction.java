package com.liufei.spring.utils;

import com.liufei.spring.annotation.ExtTransaction;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.lang.reflect.Method;

/**
 * @Auther: liufei
 * @Date: 2020/07/22/12:22 上午
 * @Description:
 */
//@Component
//@Aspect
public class AopTransaction {

    @Autowired
    private TransactionUtils transactionUtils;

    @Around("execution(* com.liufei.spring.service.*.*.*(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        // 1. 获取代理对象的方法，进而获取方法中的注解
        ExtTransaction methodExtTransaction = getMethodExtTransaction(point);
        // 2. 判断方法中是否含有ExtTransaction注解
        TransactionStatus transactionStatus = null;
        if (methodExtTransaction != null) {
            // 3. 如果含有，则开启事物
            transactionStatus = transactionUtils.begin();
        }
        // 4. 调用目标代理对象
        point.proceed();
        // 5. 判断方法上是否有注解：如果有则提交事物
        if (transactionStatus != null) {
            transactionUtils.commit(transactionStatus);
        }
    }

    @AfterThrowing("execution(* com.liufei.spring.service.*.*.*(..))")
    public void afterThrow() {
        // 回滚事务
        // transactionUtils.rollback();
    }

    public ExtTransaction getMethodExtTransaction(ProceedingJoinPoint point) throws NoSuchMethodException {
        // 获取方法名称
        String methodName = point.getSignature().getName();
        // 获取目标对象
        Class<?> aClass = point.getTarget().getClass();
        // 获取目标对象类型
        Class<?>[] par = ((MethodSignature) point.getSignature()).getParameterTypes();
        // 获取目标对象方法
        Method objMethod = aClass.getMethod(methodName, par);
        // 判断是否有自定义事务注解
        ExtTransaction declaredAnnotation = objMethod.getDeclaredAnnotation(ExtTransaction.class);
        return declaredAnnotation;
    }
}
