package com.liufei.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @Auther: liufei
 * @Date: 2020/07/26/11:54 上午
 * @Description:
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RUNTIME)
public @interface ExResource {
}
