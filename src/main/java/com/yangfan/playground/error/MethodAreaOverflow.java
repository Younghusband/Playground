package com.yangfan.playground.error;

import java.lang.reflect.Proxy;


/**
 * 尝试让方法区boom
 *
 */
public class MethodAreaOverflow {
    public static void main(String[] args) {
        int count = 0;
        while (true) {
            MyInterface proxy = (MyInterface) Proxy.newProxyInstance(
                    MethodAreaOverflow.class.getClassLoader(),
                    new Class<?>[]{MyInterface.class},
                    (proxy1, method, args1) -> null
            );
            count++;
            System.out.println("Generated classes: " + count);
        }
    }

    interface MyInterface {
    }
}
