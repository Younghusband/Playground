package com.yangfan.playground.xjb.designpattern.observer;

import com.yangfan.playground.xjb.designpattern.observer.jdk.MyObserver;
import com.yangfan.playground.xjb.designpattern.observer.jdk.Staff;

public class Main {

    private static final String Q1 = "强奸犯1号";
    private static final String Q2 = "强奸犯2号";

    public static void main(String[] args) {
        // 1. 自定义观察者模式
        ConcreteSubject subject = new ConcreteSubject();

        ConcreteObserver observer1 = new ConcreteObserver(Q1);
        ConcreteObserver observer2 = new ConcreteObserver(Q2);

        subject.registerObserver(observer1, Q1);
        subject.registerObserver(observer2, Q2);

        subject.notifyObservers("驷马少女在疯狂挣扎!");

        subject.removeObserver(observer1, Q1);
        subject.removeObserver(observer2, Q2);


        // 2. 使用jdk实现的Observer-Subject
//        Staff s1 = new Staff();
//        s1.addObserver(new MyObserver());
//        s1.changeStaffSomeState("去你妈的老子不干了");


    }
    
}
