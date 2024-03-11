package com.yangfan.playground.basic;

/**
 * 测试java8接口的新特性
 * 1. 默认方法，包含具体内容，但可以被重写
 * 2. 静态方法，属于接口，不属于实现类
 *
 * 以上是可以有，而不是默认有
 * default是关键字，无法用于方法的命名
 */
public interface NewInterface {

    default void test() {
        System.out.println("默认方法。");
    }

    static void test1() {
        System.out.println("静态方法。");
    }

}
