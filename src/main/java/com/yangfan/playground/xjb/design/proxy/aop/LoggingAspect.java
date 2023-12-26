package com.yangfan.playground.xjb.design.proxy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

//    @Before("execution(* com.yangfan.playground.*.*(..))" )
//    public void beforeAdvice() {
//        System.out.println("Before method is called..");
//    }

    @Before("execution(* com.yangfan.playground.xjb.design.proxy..*(..))")
    public void beforeDisplayLogging(JoinPoint joinPoint) {
        System.out.println("Before method: " + joinPoint.getSignature().getName());
    }

    @After("execution(* com.yangfan.playground.xjb.design.proxy..*(..))")
    public void afterDisplayLogging(JoinPoint joinPoint) {
        System.out.println("After method: " + joinPoint.getSignature().getName());
    }

}
