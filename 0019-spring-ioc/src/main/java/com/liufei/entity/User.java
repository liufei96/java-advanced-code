package com.liufei.entity;

/**
 * @Auther: liufei
 * @Date: 2020/07/19/6:36 下午
 * @Description:
 */
public class User {

    String userName = "liufei";

    Integer age;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
