package com.yangfan.playground.xjb.designpattern.strategy;

public class CreditCardPayment implements PaymentStrategy{

    @Override
    public void pay(int amount) {
        System.out.println("使用信用卡付款【" + amount +"】元");
    }
}
