package com.yangfan.playground.design.factory.simple;

import com.yangfan.playground.design.factory.Car;
import com.yangfan.playground.design.factory.SUVCar;
import com.yangfan.playground.design.factory.SedanCar;

/**
 *  简单工厂实现
 */
public class SimpleFactory {

    private static final String SUV = "SUVCar";
    private static final String SEDAN = "SedanCar";

    private static final String ERROR_MSG = "Invalid car type.";

    public static Car createCar(String type) {
        // 根据类型创建车子对象
        return switch (type) {
            case SUV -> new SUVCar();
            case SEDAN -> new SedanCar();
            default -> throw new IllegalArgumentException(ERROR_MSG);
        };
    }

    public static Car createCar(String type, String name) {
        // 根据类型和名称创建车子对象
        if(null != name && !name.trim().isEmpty()) {
            return switch(type) {
                case SUV -> new SUVCar(name);
                case SEDAN -> new SedanCar(name);
                default -> throw new IllegalArgumentException(ERROR_MSG);
            };
        }
        return createCar(type);
    }

}
