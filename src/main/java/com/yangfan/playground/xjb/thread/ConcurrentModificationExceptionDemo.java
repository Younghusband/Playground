package com.yangfan.playground.xjb.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * 用于演示ConcurrentModificationException的产生
 *
 * Exception in thread "Thread-0" java.util.ConcurrentModificationException
 * 	at java.base/java.util.ArrayList$Itr.checkForComodification(ArrayList.java:1013)
 * 	at java.base/java.util.ArrayList$Itr.next(ArrayList.java:967)
 * 	at com.yangfan.playground.xjb.thread.ConcurrentModificationExceptionDemo.lambda$main$0(ConcurrentModificationExceptionDemo.java:19)
 * 	at java.base/java.lang.Thread.run(Thread.java:833)
 *
 * 	迭代过程中，会检查modCount值是否与开始迭代时一致，不一致就会抛出。
 */
public class ConcurrentModificationExceptionDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");

        // 线程1: 遍历集合
        new Thread(()-> {
            for(String language: list) {
                list.remove(language);
            }

        }).start();

        // 线程2: 修改集合
        new Thread(()->{
            list.add("JavaScript");
        }).start();


    }


}
