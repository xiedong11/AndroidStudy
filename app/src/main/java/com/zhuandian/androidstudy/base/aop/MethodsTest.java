package com.zhuandian.androidstudy.base.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * desc :
 * author：xiedong
 * date：2019/8/14
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface MethodsTest {
    int type();
}
