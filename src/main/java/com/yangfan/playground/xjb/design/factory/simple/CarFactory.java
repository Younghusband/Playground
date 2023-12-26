package com.yangfan.playground.xjb.design.factory.simple;

import com.yangfan.playground.xjb.design.factory.Car;

public interface CarFactory {
    Car createCar();
    Car createCar(String name);
}
