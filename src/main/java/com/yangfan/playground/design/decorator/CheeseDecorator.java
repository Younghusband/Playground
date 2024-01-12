package com.yangfan.playground.design.decorator;

public class CheeseDecorator extends BurgerDecorator {
    public CheeseDecorator(Burger burger) {
        super(burger);
    }

    public String getDesc() {
        return super.getDesc() + ", Cheese";
    }

    public double cost() {
        return super.cost() + 2;
    }

}
