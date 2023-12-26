package com.yangfan.playground.xjb.design.strategy;

public class AlipayPayment implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("使用支付宝付款【"+amount+"】元");
    }
}
