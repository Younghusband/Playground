package com.yangfan.playground.design.factory;


public class SUVCar implements Car {

    private String name;

    public SUVCar() {}

    public SUVCar(String name) {
        this.name = name;
    }

    @Override
    public void drive() {
        if(this.name == null) {
            System.out.println("您正在驾驶SUV。。。");
            return;
        }
        System.out.printf("您正在驾驶[%s]SUV。。。\n", this.name);
    }
}
