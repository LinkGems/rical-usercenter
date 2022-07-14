package com.whitrue.rical.backend.interceptor;

import com.whitrue.rical.common.domain.ThreadLocalData;
import com.whitrue.rical.common.utils.ThreadLocalUtil;
import org.apache.dubbo.rpc.RpcContext;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: meidanlong
 * @date: 2022/1/21 2:13 PM
 */
@Aspect
@Configuration
public class ControllerInterceptor {

    @Value("${dubbo.application.id}")
    private String appKey;

    @Pointcut("execution(public * com.whitrue..*.controller.*.*(..))")
    public void rpcMethod(){ }

    @Before("rpcMethod()")
    public void before(){
        ThreadLocalData data = new ThreadLocalData();
        RpcContext.getContext().setAttachment("appKey", appKey);
        data.setAppKey(appKey);
        ThreadLocalUtil.setTl(data);
    }

    @AfterReturning("rpcMethod()")
    public void afterReturning(){
        ThreadLocalUtil.removeTl();
    }
 }
