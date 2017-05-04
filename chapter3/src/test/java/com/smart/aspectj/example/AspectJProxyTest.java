package com.smart.aspectj.example;

import com.smart.advice.NaiveWaiter;
import com.smart.advice.Waiter;
import com.smart.aspectj.aspectj.PreGreetingAspect;
import org.springframework.aop.aspectj.annotation.AspectJProxyFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/5/4.
 */
public class AspectJProxyTest {
    AspectJProxyFactory factory = null;

    @BeforeClass
    public void init() {
        Waiter target = new NaiveWaiter();
        factory = new AspectJProxyFactory();
        factory.setTarget(target);
        factory.addAspect(PreGreetingAspect.class);
    }

    @Test
    public void aspedtJProxy() {
        Waiter proxy = factory.getProxy();
        proxy.greetTo("John");
        proxy.serveTo("John");
    }
}
