package com.yangfan.playground.xjb.design.proxy.aop;

import org.springframework.stereotype.Component;

@Component
public class MyService {

    public void performAction() {
        System.out.println("Action performed.");
    }

}
