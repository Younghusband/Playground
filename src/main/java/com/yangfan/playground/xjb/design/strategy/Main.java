package com.yangfan.playground.xjb.design.strategy;

public class Main {

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
//        cart.setPaymentStrategy(new AlipayPayment());
        cart.setPaymentStrategy(new CreditCardPayment());
        cart.checkout(100);
    }

}
