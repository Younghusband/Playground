package com.yangfan.playground.xjb.designpattern.factory.reflect;

public class SedanCar implements Car {

    private String name;
    public SedanCar(String name) {
        this.name = name;
    }

    @Override
    public void drive() {
        System.out.printf("正在驾驶[%s]厢式轿车。。。%n\n", this.name);
    }
}
