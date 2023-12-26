package com.yangfan.playground.xjb.design.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 尝试破坏单例模式
 *
 */
public class SingletonBreakDemo {


    public static void main(String[] args)
            throws NoSuchMethodException,
            InvocationTargetException,
            InstantiationException,
            IllegalAccessException {
        // 首先用单例模式提供的方法生成所有单例
        SingletonEnum instance1 = SingletonEnum.INSTANCE;
        SingletonHungry instance2 = SingletonHungry.getInstance();
        SingletonLazy instance3 = SingletonLazy.getInstance();
        SingletonInnerClass instance4 = SingletonInnerClass.getInstance();

        System.out.println("------------反射破坏单例实验------------");
        // 用反射的方式进行破坏
        System.out.print("饿汉式破坏结果: ");
        try {
            Class<SingletonEnum> singletonEnumClass = SingletonEnum.class;
            Constructor<SingletonEnum> constructor0 = singletonEnumClass.getDeclaredConstructor();
            constructor0.setAccessible(true);
            SingletonEnum instance11 = constructor0.newInstance();
            if(instance11 == instance1)
                System.out.println("破坏失败");
            else
                System.out.println("破坏成功");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("破坏失败，发生异常");
        }

        System.out.print("饿汉式破坏结果: ");
        try {
            Class<SingletonHungry> singletonHungryClass = SingletonHungry.class;
            Constructor<SingletonHungry> constructor = singletonHungryClass.getDeclaredConstructor();
            constructor.setAccessible(true); // 绕开私有访问限制
            SingletonHungry instance21 = constructor.newInstance();
            if(instance21 == instance2)
                System.out.println("破坏失败");
            else
                System.out.println("破坏成功");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("破坏失败，发生异常");
        }


        System.out.print("懒汉式破坏结果: ");
        try {
            Class<SingletonLazy> singletonLazyClass = SingletonLazy.class;
            Constructor<SingletonLazy> constructor2 = singletonLazyClass.getDeclaredConstructor();
            constructor2.setAccessible(true); // 绕开私有访问限制
            SingletonLazy instance31 = constructor2.newInstance();
            if(instance31 == instance3)
                System.out.println("破坏失败");
            else
                System.out.println("破坏成功");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("破坏失败，发生异常");
        }


        System.out.print("静态内部类破坏结果: ");
        try {
            Class<SingletonInnerClass> singletonInnerClassClass = SingletonInnerClass.class;
            Constructor<SingletonInnerClass> constructor3 = singletonInnerClassClass.getDeclaredConstructor();
            constructor3.setAccessible(true);
            SingletonInnerClass instance41 = constructor3.newInstance();
            System.out.print("内部类破坏结果: ");
            if(instance41 == instance4)
                System.out.println("破坏失败");
            else
                System.out.println("破坏成功");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("破坏失败，发生异常");
        }


        // 用序列化和反序列化的方式进行破坏
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
            out.writeObject(instance3);
        } catch (IOException e) {
            e.printStackTrace();
        }

        SingletonLazy instanceByIO = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.ser"))) {
            instanceByIO = (SingletonLazy) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(instanceByIO == instance3) {
            System.out.println("通过反射破坏单例模式，失败!");
        } else {
            System.out.println("通过反射破坏单例模式，成功!");
        }
    }







}
