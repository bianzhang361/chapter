package com.smart.advice;

import net.sf.cglib.proxy.MethodProxy;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/5/3.
 */
public class GreetingInterceptor implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        String clientName = (String) args[0];
        System.out.println("How are you! Mr." + clientName + ".");

        Object obj = invocation.proceed();
        System.out.println("Please enjoy yourself!");
        return obj;
    }
}
