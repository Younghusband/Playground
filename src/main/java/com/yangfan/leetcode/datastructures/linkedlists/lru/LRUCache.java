package com.yangfan.leetcode.datastructures.linkedlists.lru;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * 1. int get(int key) Return the value of the key if the key exists, otherwise return -1.
 *
 * 2. void put(int key, int value) Update the value of the key if the key exists.
 * Otherwise, add the key-value pair to the cache.
 * If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 *
 * The functions get and put must each run in O(1) average time complexity.
 *
 * 查:
 * 1. 缓存不命中, 返回-1，不做任何操作
 * 2. 缓存命中, 返回值, 并将该值移至链表尾部
 *
 * 插:
 * 1. 缓存不命中 & 缓存未满, 直接插入链表尾部
 *             & 缓存已满, 先淘汰链表头部元素, 再插入链表尾部
 * 2. 缓存命中, 更新该值, 并将该值移至链表尾部
 *
 * Q:
 * 1. 移除头还是移除尾
 * A: 头尾都行，但一般默认是尾，头始终存放最新的元素，尾即最远端存放最老的元素。
 *
 * 2. 双向链表相对于单链表优化了什么步骤的效率
 * A: 优化了节点删除后链表拼接的效率，可以直接找到删除节点的头尾然后组合起来。
 *
 * 3. 为什么Node对象里也要重复存储key值
 * A: 为了通过节点值反向映射到map具体的位置从而进行移除操作。
 *
 * 其实，LRU的代码一共练习了几个双向链表的常见原子操作。
 * 1. 头结点插入
 * 2. 移除尾结点
 * 3. 移除中间节点
 *
 */

public class LRUCache {
    class DLinkedNode {
        int key; // 核心，用于反向映射map中的位置
        int value;
        DLinkedNode prev;
        DLinkedNode next;
        public DLinkedNode() {}
        public DLinkedNode(int _key, int _value) {key = _key; value = _value;}
    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        // 如果 key 存在，先通过哈希表定位，再移到头部
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            // 如果 key 不存在，创建一个新的节点
            DLinkedNode newNode = new DLinkedNode(key, value);
            // 添加进哈希表
            cache.put(key, newNode);
            // 添加至双向链表的头部
            addToHead(newNode);
            ++size;
            if (size > capacity) {
                // 如果超出容量，删除双向链表的尾部节点
                DLinkedNode tail = removeLast();
                // 删除哈希表中对应的项
                cache.remove(tail.key);
                --size;
            }
        }
        else {
            // 如果 key 存在，先通过哈希表定位，再修改 value，并移到头部
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToHead(DLinkedNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(DLinkedNode node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedNode removeLast() {
        DLinkedNode res = tail.prev;
        removeNode(res);
        return res;
    }

}