package com.zhuandian.androidstudy.base.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * desc :
 * author：xiedong
 * date：2019/8/14
 */
@Aspect
public class TestAnnoAspect {


//    /**
//     * 该切点会直接入侵到业务代码中去，无需单独配置，会在所有public修饰的方法执行前完成操作
//     * @param point
//     */
//    @Before("execution(public * *(..))")
//    public void before(JoinPoint point) {
//        System.out.println("-------------------before ----"+ point.getSignature().getName());
//    }


//    @Around("execution(* test(..))")
//    public void after(ProceedingJoinPoint point) throws Throwable {
//        System.out.println("-------------------after ----"+ point.getSignature().getName());
//        point.proceed();
//    }


    /**
     * 切点表达式：execution (* com.lqr..*.*(..))。切点表达式的组成如下
     *
     * execution(<修饰符模式>? <返回类型模式> <方法名模式>(<参数模式>) <异常模式>?)
     *
     * 除了返回类型模式、方法名模式和参数模式外，其它项都是可选的。
     * 修饰符模式指的是public、private、protected，异常模式指的是NullPointException等。
     *
     */


    /**
     * 以下切点定义所有以te结尾，并且返回值为void的方法为切入点
     */
    @Pointcut("execution(void *te(..))")
    public void pointcut() {

    }

    @Before("pointcut()")
    public void before(JoinPoint point) {
        System.out.println("--------------------------@Before------" + point.getSignature().getName());
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("---------------------------@Around");
        joinPoint.proceed(); //在@Around环绕通知会拦截原方法内容的执行，我们需要手动放行才可以。否则原方法后续相关代码都不能执行
    }

    @After("pointcut()")
    public void after(JoinPoint point) {
        System.out.println("-----------------------@After");
    }

    @AfterReturning("pointcut()")
    public void afterReturning(JoinPoint point, Object returnValue) {
        System.out.println("-----------------------@AfterReturning");
    }

    @AfterThrowing(value = "pointcut()", throwing = "ex")
    public void afterThrowing(Throwable ex) {
        System.out.println("----------------------------@afterThrowing");
        System.out.println("--------------------------ex = " + ex.getMessage());
    }
}
