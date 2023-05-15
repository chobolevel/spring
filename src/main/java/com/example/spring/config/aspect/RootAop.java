package com.example.spring.config.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

@Aspect
@Slf4j
public class RootAop {

    @Around(value = "execution(* com.example.spring.controller.RootController.aopTest(*)")
    public void printCurTime() {
        System.out.println(System.currentTimeMillis());
    }

}
