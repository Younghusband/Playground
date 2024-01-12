package com.yangfan.playground.design.decorator;

/**
 * 用于测试装饰器模式
 */
public class Main {

    public static void main(String[] args) {
        Burger basicBurger = new BasicBurger();
        System.out.println(basicBurger.getDesc());
        System.out.println(basicBurger.cost());

        Burger cheeseBaconBurger = new CheeseDecorator(new BaconDecorator(basicBurger));
        System.out.println(cheeseBaconBurger.getDesc());
        System.out.println(cheeseBaconBurger.cost());

    }

}
