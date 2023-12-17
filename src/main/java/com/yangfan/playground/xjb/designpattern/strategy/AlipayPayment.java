package com.yangfan.playground.xjb.designpattern.strategy;

public class AlipayPayment implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("使用支付宝付款【"+amount+"】元");
    }
}
