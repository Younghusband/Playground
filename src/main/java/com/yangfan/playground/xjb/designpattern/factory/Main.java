package com.yangfan.playground.xjb.designpattern.factory;

import com.yangfan.playground.xjb.designpattern.factory.reflect.ReflectCarFactory;
import com.yangfan.playground.xjb.designpattern.factory.simple.SUVCarFactory;
import com.yangfan.playground.xjb.designpattern.factory.simple.SimpleFactory;

/**
 * 用于测试该包下的所有工厂模式实现方法
 *
 */
public class Main {

    public static void main(String[] args) {

        // 测试静态工厂方法
        Car SUVCar = SimpleFactory.createCar("SUVCar");
        Car sedanCar = SimpleFactory.createCar("SedanCar");
        Car SUVCarWithName = SimpleFactory.createCar("SUVCar", "SUV 棒棒棒!");
        Car sedanCarWithName = SimpleFactory.createCar("SedanCar", "Sedan是什么鬼？");

        SUVCar.drive();
        sedanCar.drive();
        SUVCarWithName.drive();
        sedanCarWithName.drive();

        // 测试工厂方法模式
        SUVCarFactory SUVCarFactory = new SUVCarFactory();
        SUVCar suv1 = (SUVCar)SUVCarFactory.createCar();
        suv1.drive();

        // 测试反射工厂模式
        Car suvCar1 = ReflectCarFactory.createCar(SUVCar.class);
        suvCar1.drive();

        Car sedanCar1 = ReflectCarFactory.createCar(SedanCar.class, "反射SedanCar");
        sedanCar1.drive();

    }


}
