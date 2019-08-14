package com.zhuandian.androidstudy.base.aop.aspect;

import com.zhuandian.androidstudy.base.aop.ClassTest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

/**
 * desc :
 * author：xiedong
 * date：2019/8/14
 */
@Aspect
public class ClassAspect {

    @Pointcut("execution(@com.zhuandian.androidstudy.base.aop.ClassTest * *(..))")
    public void pointcut(){}


    @Around("pointcut()")
    public void aroound(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        ClassTest annotation = signature.getMethod().getAnnotation(ClassTest.class);
        int type = annotation.type();
        System.out.println("-------------------类上面的注解类型为------"+type);
        //TODO 貌似没找到对单个类植入切点的做法
        joinPoint.proceed();

    }

}
