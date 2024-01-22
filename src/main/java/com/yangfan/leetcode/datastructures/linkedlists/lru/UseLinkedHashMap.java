package com.yangfan.leetcode.datastructures.linkedlists.lru;

import java.util.LinkedHashMap;
import java.util.Map;

public class UseLinkedHashMap extends LinkedHashMap<Integer, Integer> {
    private int capacity;

    public UseLinkedHashMap(int capacity) {
        super(capacity, 0.75f, true);
        this.capacity = capacity;
    }

    public int get(int key) {
        return super.getOrDefault(key, -1);
    }

    public void put(int key, int value) {
        super.put(key, value);
    }

    protected boolean removeEldestEntry(Map .Entry<Integer, Integer> eldest) {
        return size() > capacity;
    }

}
