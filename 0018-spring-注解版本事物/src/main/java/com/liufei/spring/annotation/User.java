package com.liufei.spring.annotation;

import java.lang.reflect.Method;

/**
 * @Auther: liufei
 * @Date: 2020/07/21/11:44 下午
 * @Description:
 */
public class User {

    @AddAnnotation(userName = "yiyang")
    public void add() {

    }

    public void delete() {

    }

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.liufei.spring.annotation.User");
        // 获取当前类中的方法（不包含继承父类）
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method: declaredMethods) {
            AddAnnotation annotation = method.getDeclaredAnnotation(AddAnnotation.class);
            if (annotation == null) {
                // 该方法上没有此注解
                System.out.println("method:" + method.getName() + "没有此注解");
                continue;
            }
            System.out.println("userName:" + annotation.userName());
        }
    }
}
