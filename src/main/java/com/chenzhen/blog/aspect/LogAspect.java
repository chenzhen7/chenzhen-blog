package com.chenzhen.blog.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author ChenZhen
 * @Description
 * @create 2022/9/11 15:08
 * @QQ 1583296383
 * @WeXin(WeChat) ShockChen7
 */
@Aspect
@Component
public class LogAspect {
    // 获取日志信息
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    //定义切面，申明log()是一个切面
    @Pointcut("execution(* com.chenzhen.blog.controller.*.*(..))")
    public void log() {
    }

    // 在切面之前执行
    @Before("log()")
    public void doBefore(JoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //获取URL、IP
        String url = request.getRequestURL().toString();
        String ip = request.getRemoteAddr();
        //获取请求方法
        String classMethod = joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName();
        //获取请求参数
        Object[] args = joinPoint.getArgs();
        logger.info("========================================================");
        logger.info("url : {}", url);
        logger.info("ip : {}", ip);
        logger.info("classMethod : {}", classMethod);
        logger.info("args : {}", args);
    }

    //在切面之后执行
    @After("log()")
    public void doAfter() {
//        logger.info("--------doAfter--------");
    }

    //返回之后拦截
    @AfterReturning(returning = "result", pointcut = "log()")
    public void doAfterReturn(Object result) {

        logger.info("Result : {}", result);
        logger.info("========================================================");
    }


}