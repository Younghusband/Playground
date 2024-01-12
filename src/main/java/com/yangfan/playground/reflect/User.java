package com.yangfan.playground.reflect;

import java.io.Serializable;

/**
 * Description:
 * 用于测试反射，克隆，序列化，Object类基本方法的类
 */
public class User implements Cloneable, Serializable {

    private int id;
    private String name;

    public User(){
    }

    public User(int id, String name) {
//        super();
        this.id = id;
        this.name = name;
    }

    public void show() {
        System.out.println("id: " + id + ", name: " + name);
    }

    @Override
    public boolean equals(Object obj) {
        return true;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    @Override
    public User clone() {
        try {
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    /**
     * 不可靠，建议使用try-with-resources
     */
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("草拟吗gc了，打几行日志行不行。");
    }
}
