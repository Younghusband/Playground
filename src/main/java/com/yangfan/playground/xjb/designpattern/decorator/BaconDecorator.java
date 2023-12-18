package com.yangfan.playground.xjb.designpattern.decorator;

public class BaconDecorator extends BurgerDecorator {

    public BaconDecorator(Burger burger) {
        super(burger);
    }

    public String getDesc() {
        return super.getDesc() + ", Bacon";
    }

    public double cost() {
        return super.cost() + 5.0;
    }


}
