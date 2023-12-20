package com.yangfan.playground.xjb.designpattern.proxy;

public class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        load();
    }

    @Override
    public void display() {
        System.out.printf("展示[%s]图片%n", this.fileName);
    }


    public void load() {
        System.out.printf("加载[%s]图片到硬盘%n", this.fileName);
    }

}
