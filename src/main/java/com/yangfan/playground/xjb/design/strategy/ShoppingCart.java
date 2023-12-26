package com.yangfan.playground.xjb.design.strategy;


/**
 * 持有策略，使用策略
 */
public class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        System.out.println("购物车跳转第三方支付...");
        this.paymentStrategy.pay(amount);
    }


}
