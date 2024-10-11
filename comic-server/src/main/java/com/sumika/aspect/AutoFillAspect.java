package com.sumika.aspect;

import com.sumika.annotation.AutoFill;
import com.sumika.constant.AutoFillConstant;
import com.sumika.context.BaseContext;
import com.sumika.enumeration.OperationType;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 10:15
 */

@Aspect
@Component
@Slf4j
public class AutoFillAspect {

    @Pointcut("execution(* com.sumika.mapper.*.*(..)) && @annotation(com.sumika.annotation.AutoFill)")
    public void autoFillPointCut(){}


    @Before("autoFillPointCut()")
    public void autoFill(JoinPoint joinPoint){
        log.info("开始公共字段填充...");

        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        AutoFill annotation = signature.getMethod().getAnnotation(AutoFill.class);

        Object[] args = joinPoint.getArgs();

        if(args == null || args.length == 0){
            return;
        }


        LocalDateTime now = LocalDateTime.now();


        Object arg = args[0];

        if(annotation.value().equals(OperationType.INSERT)){
            try {
                arg.getClass().getMethod(AutoFillConstant.SET_CREATE_TIME,LocalDateTime.class).invoke(arg,now);
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        try {
            arg.getClass().getMethod(AutoFillConstant.SET_UPDATE_TIME,LocalDateTime.class).invoke(arg,now);
        }catch (Exception e){
            e.printStackTrace();
        }

        log.info("公共字段填充完毕...");


    }




}
