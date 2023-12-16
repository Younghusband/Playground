package com.yangfan.playground.xjb.designpattern.factory.simple;

import com.yangfan.playground.xjb.designpattern.factory.Car;
import com.yangfan.playground.xjb.designpattern.factory.SedanCar;

public class SedanCarFactory implements CarFactory {
    @Override
    public Car createCar() {
        return new SedanCar();
    }

    @Override
    public Car createCar(String name) {
        return new SedanCar(name);
    }


}
