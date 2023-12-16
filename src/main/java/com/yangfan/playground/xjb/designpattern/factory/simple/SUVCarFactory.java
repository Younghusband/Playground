package com.yangfan.playground.xjb.designpattern.factory.simple;


import com.yangfan.playground.xjb.designpattern.factory.Car;
import com.yangfan.playground.xjb.designpattern.factory.SUVCar;

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
