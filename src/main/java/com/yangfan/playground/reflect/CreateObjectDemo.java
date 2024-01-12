package com.yangfan.playground.reflect;

import org.springframework.util.SerializationUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CreateObjectDemo {

    public static void main(String[] args) throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException {
        CreateObjectDemo demo = new CreateObjectDemo();
        demo.test();
    }

    public void test() throws
            ClassNotFoundException,
            InstantiationException,
            IllegalAccessException,
            NoSuchMethodException,
            InvocationTargetException {
        // 1. new
        User user1 = new User(1, "fan");
        user1.show();


        // 2. Class.forName().newInstance()
        Class<?> clazz = Class.forName("com.yangfan.playground.reflect.User");
        User user2 = (User) clazz.newInstance();
//        User user2 = User.class.newInstance();
        user2.setId(1);
        user2.setName("fff");
        user2.show();

        System.out.println(user1 == user2);
        // 3. clone
        User user4 = user1.clone();
        System.out.println("user1 == user4: " + (user1 == user4)+"\nuser4:");
        user4.show();


        // 4. Constructor.newInstance()
        Constructor<?>[] declaredConstructors = User.class.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor);
        }
        Constructor<?> constructor = User.class.getDeclaredConstructor(int.class, String.class);
        User user3 = (User) constructor.newInstance(1, "fan");
        user3.show();
        // 5. 反序列化
        byte[] serializeData = SerializationUtils.serialize(user1);


        user1 = null;
        System.gc();
        // TODO
    }

}
