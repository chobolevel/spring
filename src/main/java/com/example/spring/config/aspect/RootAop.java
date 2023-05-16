package com.example.spring.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class RootAop {

    @Around("execution(* com.example.spring.controller.RootController(*))")
    public Object printCurTime(ProceedingJoinPoint pjp) {
        System.out.println("printCurTimeBefore: " + System.currentTimeMillis());
        // 아래 코드를 기준으로 전후 코드들이 수행됨
        Object proceed = pjp.proceed();
        System.out.println("printCurTimeAfter : " + System.currentTimeMillis());
        return proceed;
    }

}
