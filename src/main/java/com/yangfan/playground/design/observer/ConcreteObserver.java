package com.yangfan.playground.design.observer;

public class ConcreteObserver implements Observer {

    private String name;
    public ConcreteObserver() {}

    public ConcreteObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String updateMessage) {
        System.out.println(this.name + "检测到了异动: " + updateMessage);
    }
}
