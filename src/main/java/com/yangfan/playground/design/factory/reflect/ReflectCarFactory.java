package com.yangfan.playground.design.factory.reflect;

import com.yangfan.playground.design.factory.Car;

import java.lang.reflect.Constructor;

/**
 * 利用反射的方式实现工厂模式
 */
public class ReflectCarFactory {

    public static <T extends Car> T createCar(Class<T> carClass, Object... constructorArgs) {
        try {
            // 获取构造函数
            Class<?>[] parameterTypes = new Class<?>[constructorArgs.length];
            for(int i = 0; i < constructorArgs.length; i++) {
                parameterTypes[i] = constructorArgs[i].getClass();
            }
            Constructor<T> constructor = carClass.getDeclaredConstructor(parameterTypes);
            // 使用反射创建对象
            return constructor.newInstance(constructorArgs);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
