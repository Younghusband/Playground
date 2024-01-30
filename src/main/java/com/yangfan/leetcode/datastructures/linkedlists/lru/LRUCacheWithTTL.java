package com.yangfan.leetcode.datastructures.linkedlists.lru;

import java.util.*;

public class LRUCacheWithTTL {
    private final LinkedHashMap<Integer, CacheItem> cacheMap;
    private final int capacity;

    public LRUCacheWithTTL(int capacity) {
        this.capacity = capacity;
        this.cacheMap = new LinkedHashMap<Integer, CacheItem>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<Integer, CacheItem> eldest) {
                return size() > LRUCacheWithTTL.this.capacity || isExpired(eldest.getValue());
            }
        };
    }

    public Integer get(int key) {
        CacheItem item = cacheMap.get(key);
        if (item == null || isExpired(item)) {
            return null;
        }
        return item.value;
    }

    public void put(int key, int value, long ttlMillis) {
        cacheMap.put(key, new CacheItem(value, ttlMillis));
    }

    private boolean isExpired(CacheItem item) {
        return System.currentTimeMillis() - item.createdAt > item.ttlMillis;
    }

    private static class CacheItem {
        int value;
        long ttlMillis;
        long createdAt;

        CacheItem(int value, long ttlMillis) {
            this.value = value;
            this.ttlMillis = ttlMillis;
            this.createdAt = System.currentTimeMillis();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        LRUCacheWithTTL cache = new LRUCacheWithTTL(2);
        cache.put(1, 1, 1000); // 1秒后过期
        cache.put(2, 2, 5000); // 5秒后过期
        System.out.println(cache.get(1)); // 返回 1
        Thread.sleep(2000); // 等待2秒
        System.out.println(cache.get(1)); // 返回 null，因为已过期
        System.out.println(cache.get(2)); // 返回 2，因为未过期
    }
}

