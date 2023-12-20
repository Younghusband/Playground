package com.yangfan.playground.xjb.designpattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicImageProxy implements InvocationHandler {
    private Object realObject;

    public DynamicImageProxy(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method: " + method.getName());
        Object result = method.invoke(realObject, args);
        System.out.println("After method: " + method.getName());
        return result;
    }





}
