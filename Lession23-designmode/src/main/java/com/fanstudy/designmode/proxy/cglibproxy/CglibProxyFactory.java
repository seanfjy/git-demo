package com.fanstudy.designmode.proxy.cglibproxy;

import org.springframework.cglib.proxy.Enhancer;

public class CglibProxyFactory {
    public static Object getProxy(Class<?> clazz){
        Enhancer enhancer = new Enhancer();

        enhancer.setClassLoader(clazz.getClassLoader());

        enhancer.setSuperclass(clazz);

        enhancer.setCallback(new DebugMethodIntercepter());
        return enhancer.create();
    }
}
