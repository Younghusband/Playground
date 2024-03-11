package com.yangfan.playground.basic.extend;

public abstract class TestAnotherPackageFather {

    /**
     * 尝试让异包子类继承
     */
    void testMethod(String name) {
        System.out.println("父类: " + name);
    }

}
