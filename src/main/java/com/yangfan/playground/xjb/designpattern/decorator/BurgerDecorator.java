package com.yangfan.playground.xjb.designpattern.decorator;

public class BurgerDecorator implements Burger {

    private Burger decoratedBurger;

    public BurgerDecorator(Burger burger) {
        this.decoratedBurger = burger;
    }

    @Override
    public String getDesc() {
        return decoratedBurger.getDesc();
    }

    @Override
    public double cost() {
        return decoratedBurger.cost();
    }
}
