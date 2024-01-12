package com.yangfan.playground.design.proxy.aop;

import org.springframework.stereotype.Component;

@Component
public class MyService {

    public void performAction() {
        System.out.println("Action performed.");
    }

}
