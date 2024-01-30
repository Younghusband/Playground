package com.yangfan.leetcode.datastructures.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyDynamicArray {
    private int[] data;
    private int size;

    public MyDynamicArray() {
        data = new int[2]; // 初始容量设置为2，可以根据需要调整
        size = 0;
    }

    // 添加元素并保持数组有序
    public void add(int val) {
        if (size == data.length) {
            resize(); // 扩容
        }

        int insertIndex = size;
        for (int i = 0; i < size; i++) {
            if (data[i] > val) {
                insertIndex = i;
                break;
            }
        }

        // 将insertIndex之后的元素向后移动一位
        for (int i = size; i > insertIndex; i--) {
            data[i] = data[i - 1];
        }

        // 插入新元素
        data[insertIndex] = val;
        size++;
    }

    // 扩容方法
    private void resize() {
        int[] newData = new int[data.length * 2];
        System.arraycopy(data, 0, newData, 0, data.length);
        data = newData;
    }

    // 获取元素
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return data[index];
    }

    // 获取大小
    public int size() {
        return size;
    }

    // 打印数组内容
    public void printArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        MyDynamicArray array = new MyDynamicArray();
        array.add(5);
        array.add(1);
        array.add(3);
        array.printArray(); // 应输出: 1 3 5

        Map<String, String> xxx = new HashMap<>();
        xxx.put(null, "xxxx");
        xxx.put("xxx", null);

        Map<String, String> ccc = new ConcurrentHashMap();
        ccc.put(null, "xxxx");

        System.out.println(xxx.toString());
        System.out.println(ccc.toString());
    }
}
