package com.yangfan.playground.xjb.thread;

public class ReentrantLockExample {

    private final Object lock = new Object();

    public void outerMethod() {
        synchronized (lock) {
            innerMethod();
        }
    }


    public void innerMethod() {
        synchronized (lock) {
            // do something
            System.out.println("innerMethod");
        }
    }


    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();
        example.outerMethod();
    }




}
