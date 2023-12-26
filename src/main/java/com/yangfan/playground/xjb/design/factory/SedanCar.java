package com.yangfan.playground.xjb.design.factory;


public class SedanCar implements Car {

    private String name;

    public SedanCar() {}
    public SedanCar(String name) {
        this.name = name;
    }

    @Override
    public void drive() {
        if(this.name == null) {
            System.out.println("正在驾驶厢式轿车。。。");
            return;
        }
        System.out.printf("正在驾驶[%s]厢式轿车。。。\n", this.name);
    }
}
