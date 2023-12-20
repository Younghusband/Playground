package com.yangfan.playground.xjb.designpattern.proxy;


/**
 * 静态代理，通过持有被代理类来完成功能的调用
 */
public class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if(realImage == null) {
            realImage = new RealImage(fileName);
        }
        realImage.display();
    }


}
