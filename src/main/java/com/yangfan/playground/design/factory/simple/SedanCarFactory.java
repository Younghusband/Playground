package com.yangfan.playground.design.factory.simple;

import com.yangfan.playground.design.factory.Car;
import com.yangfan.playground.design.factory.SedanCar;

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
