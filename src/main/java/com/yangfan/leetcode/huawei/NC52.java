package com.yangfan.leetcode.huawei;

import java.util.ArrayDeque;
import java.util.Deque;

public class NC52 {

    public boolean isValid (String s) {
        if(s.length() % 2 != 0) return false;
        Deque<Character> stack = new ArrayDeque();
        for(char c : s.toCharArray()) {
            if(c == '(') {
                stack.push(')');
            } else if (c == '{') {
                stack.push('}');
            } else if (c == '[') {
                stack.push(']');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }


}
