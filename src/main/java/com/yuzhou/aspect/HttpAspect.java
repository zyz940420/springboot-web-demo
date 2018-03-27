package com.yuzhou.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
public class HttpAspect {
    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);
//    @Before("execution(public * com.yuzhou.controller.GirlController.*(..))")
//    public void log() {
//        System.out.println(11111);
//    }

//    @After("execution(public * com.yuzhou.controller.GirlController.*(..))")
//    public void doAfter(){
//        System.out.println(222222);
//    }

    @Pointcut("execution(public * com.yuzhou.controller.GirlController.*(..))")
    public void log() {

    }

    //    @Before("log()")
//    public void doBefore() {
//        logger.info("{}", 11111);
//    }
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //url
        logger.info("url={}", request.getRequestURL());
        //method
        logger.info("method={}", request.getMethod());
        //ip
        logger.info("ip={}", request.getRemoteAddr());
        //类方法
        logger.info("class_method={}", joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        //参数
        logger.info("args={}", joinPoint.getArgs());


    }

    @After("log()")
    public void doAfter() {
        logger.info("{}", 222222);
    }

    @AfterReturning(returning = "object", pointcut = "log()")
    public void doAfterReturning(Object object) {
        logger.info("response={}", object.toString());
    }
}