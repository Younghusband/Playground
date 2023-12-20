package com.yangfan.playground.xjb.designpattern.proxy;

import com.yangfan.playground.xjb.designpattern.proxy.dynamic.DynamicImageProxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
//        ProxyImage proxy = new ProxyImage("abc_temp.jpg");
//        proxy.display();
//        proxy.display();

        Image realImage = new RealImage("test_dynamic1.jpg");

        // 参数1 类加载器; 参数2 类数组，传入被代理的接口; 参数3 实现了InvocationHandler的具体类对象
        Image imageProxy = (Image)Proxy.newProxyInstance(Image.class.getClassLoader(),
                new Class[]{Image.class}, new DynamicImageProxy(new RealImage("test_dynamic.jpg")));

        Image imageProxy2 = (Image)Proxy.newProxyInstance(Image.class.getClassLoader(),
                realImage.getClass().getInterfaces(), new DynamicImageProxy(realImage));

        imageProxy.display();

    }

}
