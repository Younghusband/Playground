package com.yangfan.playground.xjb.basic;

public class NewInterfaceImpl implements NewInterface {

    public static void main(String[] args) {
        NewInterfaceImpl impl = new NewInterfaceImpl();
        impl.test();
        NewInterface.test1();
    }

//    @Override
//    public void test() {
//        System.out.println("重写默认方法。");
//    }

}
