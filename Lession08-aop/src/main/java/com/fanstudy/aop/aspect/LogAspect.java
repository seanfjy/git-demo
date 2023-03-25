package com.fanstudy.aop.aspect;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* com.fanstudy.aop.service..*.*(..))")
    public void poinCut1() {}

    // 功能增加的方法
    @Before(value = "poinCut1()")
    // @After("execution(* com.fanstudy.aop.service..*.*(..))")
    public void sysLog(JoinPoint joinPoint) {
        StringJoiner log = new StringJoiner("|", "{", "}");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        log.add(formatter.format(LocalDateTime.now()));

        // 当前执行业务方法的名称
        String methodName = joinPoint.getSignature().getName();
        log.add(methodName);

        // 方法的参数
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            log.add(arg == null ? "-" : arg.toString());
        }
        System.out.println("日志:" + log);
    }

    @Around(value = "poinCut1()")
    public Object sysLogAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("start");
        Object proceed = joinPoint.proceed();
        System.out.println("end");

        return proceed;
    }
}
