package com.yangfan.playground.xjb.designpattern.singleton;
/**
 * @description 
 * @author vermouth.Mac
 * @version 2018年1月21日 下午9:14:34
 * 
 * 
 * 用枚举写单例实在太简单了！这也是它最大的优点。下面这段代码就是声明枚举实例的通常做法。
   我们可以通过EasySingleton.INSTANCE来访问实例，由于是饿汉式，也不存在线程安全问题。
   而且JVM不允许通过反射创建枚举实例，不会被反射破坏
 * 
 */

 public enum SingletonEnum {
     INSTANCE;
}
