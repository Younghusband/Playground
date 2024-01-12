package com.yangfan.playground.design.factory.simple;

import com.yangfan.playground.design.factory.Car;

public interface CarFactory {
    Car createCar();
    Car createCar(String name);
}
