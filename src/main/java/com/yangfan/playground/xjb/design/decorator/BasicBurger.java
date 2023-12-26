package com.yangfan.playground.xjb.design.decorator;

public class BasicBurger implements Burger {

    @Override
    public String getDesc() {
        return "汉堡";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}
