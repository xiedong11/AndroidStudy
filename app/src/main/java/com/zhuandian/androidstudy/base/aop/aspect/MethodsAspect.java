package com.zhuandian.androidstudy.base.aop.aspect;

import com.zhuandian.androidstudy.base.aop.MethodsTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * desc :
 * author：xiedong
 * date：2019/8/14
 */
@Aspect
public class MethodsAspect {
    @Pointcut("execution(@com.zhuandian.androidstudy.base.aop.MethodsTest * *(..))")
    public void pointcut(){}

    @Before("pointcut()")
    public void before(){
        System.out.println("-----------------s------------s-----------------");
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        MethodsTest methodsTest = signature.getMethod().getAnnotation(MethodsTest.class);
        int type = methodsTest.type();
        System.out.println("-----------------s------------s-----------------"+type);
        joinPoint.proceed(); //放行原函数里执行的内容
    }

}
