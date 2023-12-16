package com.yangfan.playground.xjb.designpattern.factory.simple;

import com.yangfan.playground.xjb.designpattern.factory.Car;

public interface CarFactory {
    Car createCar();
    Car createCar(String name);
}
