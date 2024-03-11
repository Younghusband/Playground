package com.yangfan.playground.basic;

import com.yangfan.playground.basic.extend.TestAnotherPackageFather;

public class TestAnotherPackageSon extends TestAnotherPackageFather {

    /**
     * 子类不可见父类的testMethod， 自然无法Override
     * 此时的这个是另一个与父类无关的方法
     */

//    @Override
    public void testMethod(String name) {
        System.out.println("父类: " + name);
    }

}
