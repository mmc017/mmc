package com.example.bootstudy.aop.datasource;

import com.example.bootstudy.config.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
@Slf4j
public class DataSourceAspect implements Ordered {
 

    @Pointcut("@annotation(com.example.bootstudy.aop.datasource.DataSource)")
    public void dataSourcePointCut(){
 
    }
 
    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point)throws  Throwable{
        MethodSignature signature = (MethodSignature)point.getSignature();
        Method method = signature.getMethod();
        DataSource ds = method.getAnnotation(DataSource.class);
        if(ds == null){
            DynamicDataSource.setDataSource(DataSourceConstants.testOne);
            log.info("set mysql");
        }else{
//            DataSourceConstants.testTwo;
            DynamicDataSource.setDataSource(ds.name());
            log.info("set datasource");
        }
 
        try{
           return point.proceed();
        }finally {
            DynamicDataSource.clearDataSource();
            log.info("clear datasource");
        }
    }
    @Override
    public int getOrder() {
        return 1;
    }
}