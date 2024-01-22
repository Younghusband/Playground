package com.yangfan.leetcode.datastructures.linkedlists.lru;

/**
 * 用单链表实现LRU
 *
 */
public class SingleLinkedDemo {

    public SingleLinkedDemo(int capacity) {

    }

    /**
     * 查:
     *  1. 缓存不命中, 返回-1，不做任何操作
     *  2. 缓存命中, 返回值, 并将该值移至链表尾部
     */
    public int get(int key) {
        return -1;
    }

    /**
     * 插:
     *  1. 缓存不命中 & 缓存未满, 直接插入链表尾部
     *              & 缓存已满, 先淘汰链表头部元素, 再插入链表尾部
     *  2. 缓存命中, 更新该值, 并将该值移至链表尾部
     */
    public void put(int key, int value) {


    }


}
