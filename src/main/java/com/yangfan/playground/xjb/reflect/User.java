package com.yangfan.playground.xjb.reflect;

import java.io.Serializable;

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
            User clone = (User) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("草拟吗gc了，打几行日志行不行。");
    }
}
