package com.yangfan.leetcode.datastructures.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 155. Min Stack
 * 最小栈
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * Implement the MinStack class:
 *
 * MinStack() initializes the stack object.
 * void push(int val) pushes the element val onto the stack.
 * void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack.
 * int getMin() retrieves the minimum element in the stack.
 * You must implement a solution with O(1) time complexity for each function.
 *
 * 两种实现思路
 * 1. 压栈时，最小栈在所有情况都有压栈动作。但是出栈无脑出
 * 2. 压栈时，最小栈只有在值小于等于的时候才压栈。出栈的时候，如果值等于最小栈的栈顶，最小栈也出栈
 *
 * 或者 使用链表实现栈
 */

/**
 * 方法一 用链表实现栈
 * 链表的每个节点都有一个min值，代表当前节点为栈顶时的最小值
 */
class MinStack {

    private MinNode node;
    public MinStack() {}
    public void push(int x) {
        if (node == null) {
            node = new MinNode(x, x, null);
        } else {
            int min = node.min <= x ? node.min : x;
            node = new MinNode(x, min, node);
        }
    }

    public void pop() {
        if (node != null) {
            node = node.next;
        }
    }

    public int top() {
        return node != null ? node.val : -1;
    }

    public int getMin() {
        return node != null ? node.min : -1;
    }

    class MinNode {

        int val;
        int min;
        MinNode next;

        MinNode(int val, int min, MinNode next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}



/**
 * 标准解法
 * 从中学不到啥
 */
public class Min_Stack {

    Deque<Integer> minHelper;
    Deque<Integer> store;

    public Min_Stack() {
        this.minHelper = new ArrayDeque<>();
        this.store = new ArrayDeque<>();
    }

    public void push(int val) {
        // 核心是: 等于也要push
        if(minHelper.isEmpty() || val <= minHelper.peek()) {
            minHelper.push(val);
        } else {
            minHelper.push(minHelper.peek());
        }
        store.push(val);
    }

//    public void push(int newNum) {
//        if(minHelper.isEmpty()) {
//            minHelper.push(newNum);
//        } else if(minHelper.peek() >= newNum) { // 核心点
//            minHelper.push(newNum);
//        }
//        store.push(newNum);
//    }

    public void pop() {
        if(!store.isEmpty()) {
            store.pop();
        }
        if(!minHelper.isEmpty()) {
            minHelper.pop();
        }
    }

//    public void pop() {
//        if(store.isEmpty()) {
//            throw new RuntimeException("Stack is Empty!");
//        }
//        Integer value = store.pop();
//        if(minHelper.peek() >= value) {
//            minHelper.pop();
//        }
//    }

    public int top() {
        return store.peek();
    }

    public int getMin() {
        return minHelper.peek();
    }


}



