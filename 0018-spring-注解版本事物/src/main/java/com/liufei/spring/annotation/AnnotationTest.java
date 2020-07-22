package com.liufei.spring.annotation;

/**
 * @Auther: liufei
 * @Date: 2020/07/21/11:15 下午
 * @Description:
 */
@AddAnnotation
public class AnnotationTest {

    @AddAnnotation(userName = "yiyang")
    public void add() {
    }
}
