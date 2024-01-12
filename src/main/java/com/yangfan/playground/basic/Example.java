package com.yangfan.playground.basic;

/**
 * Java是值传递还是引用传递
 */
public class Example {
    public static void main(String[] args) {
        MyClass obj = new MyClass(5);
        modifyReference(obj);
        System.out.println(obj.getValue());  // 输出结果是 5，因为引用被重新分配了
    }

    static void modifyReference(MyClass myObj) {
        myObj = new MyClass(10); // 这样还是5
//        myObj.setValue(10); // 这样会变10 
    }
}

class MyClass {
    private int value;

    public MyClass(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
