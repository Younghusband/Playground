package com.yangfan.playground.xjb.design.factory.simple;


import com.yangfan.playground.xjb.design.factory.Car;
import com.yangfan.playground.xjb.design.factory.SUVCar;

public class SUVCarFactory implements CarFactory {

    @Override
    public Car createCar() {
        return new SUVCar();
    }

    @Override
    public Car createCar(String name) {
        return new SUVCar(name);
    }
}
