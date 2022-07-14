package com.whitrue.rical.backend.interceptor;

import com.whitrue.rical.common.domain.ThreadLocalData;
import com.whitrue.rical.common.utils.StringUtil;
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
public class ProviderInterceptor {

    @Value("${dubbo.application.id}")
    private String appKey;

    /**
     * RPC包拦截
     *
     * execution(modifiers-pattern? ret-type-pattern declaring-type-pattern? name-pattern(param-pattern)throws-pattern?)
     *
     * 修饰符匹配（modifier-pattern?）
     * 返回值匹配（ret-type-pattern）可以为*表示任何返回值,全路径的类名等
     * 类路径匹配（declaring-type-pattern?）
     * 方法名匹配（name-pattern）可以指定方法名 或者 *代表所有, set* 代表以set开头的所有方法
     * 参数匹配（(param-pattern)）可以指定具体的参数类型，多个参数间用“,”隔开，各个参数也可以用“*”来表示匹配任意类型的参数，如(String)表示匹配一个String参数的方法；(*,String) 表示匹配有两个参数的方法，第一个参数可以是任意类型，而第二个参数是String类型；可以用(..)表示零个或多个任意参数
     * 异常类型匹配（throws-pattern?）
     * 其中后面跟着“?”的是可选项
     */
    @Pointcut("execution(public * com.whitrue..*.provider.*.*(..))")
    public void rpcMethod(){ }

    @Before("rpcMethod()")
    public void before(){
        ThreadLocalData data = new ThreadLocalData();
        String curAppKey = RpcContext.getContext().getAttachment("appKey");
//        if(StringUtil.isEmpty(curAppKey)){
//            curAppKey = appKey;
//            RpcContext.getContext().setAttachment("appKey", curAppKey);
//        }
        data.setAppKey(curAppKey);
        ThreadLocalUtil.setTl(data);
    }

    @AfterReturning("rpcMethod()")
    public void afterReturning(){
        ThreadLocalUtil.removeTl();
    }
 }
