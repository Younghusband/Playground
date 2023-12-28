package com.yangfan.playground.xjb.algorithm;

import java.util.Stack;


/**
 * 用两个栈实现能够一直返回最小值的栈
 *
 * 典型的空间换时间
 *
 * 最核心的地方在于压栈的时候，等于stackMin的栈顶值时也要压栈。
 */
public class GetMinStack {
    private Stack<Integer> stackData = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    public void push(int newNum) {
        if(this.stackMin.empty()) {
            this.stackMin.push(newNum);
        } else if(this.stackMin.peek() >= newNum) { // 核心点
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    public Integer pop() {
        if(stackData.empty()) {
            throw new RuntimeException("Stack is Empty!");
        }
        Integer value = this.stackData.pop();
        if(this.stackMin.peek() >= value) {
            this.stackMin.pop();
        }
        return value;
    }

    public int getMin() {
        if(stackMin.empty()) {
            throw new RuntimeException("Illegal operation! Stack is Empty.");
        }
        return this.stackMin.peek();
    }

}
