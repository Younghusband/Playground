package com.yangfan.leetcode.datastructures.strings;


import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 917. Reverse Only Letters
 * 仅仅反转字母
 *
 * 双指针即可
 */
public class Reverse_Only_Letters {


    /**
     * 双指针
     */
    public String reverseOnlyLetters(String s) {
        int left = 0;
        int right = s.length() - 1;
        char [] arr = s.toCharArray();
        while(left < right) {
            while(left < right && !Character.isLetter(arr[left])) {
                left++;
            }
            while(left < right && !Character.isLetter(arr[right])) {
                right--;
            }
            // 遇到左右都是字母, 交换完下标递进
            swap(arr, left++, right--);
        }
        return new String(arr);
    }

    void swap(char [] arr, int p1, int p2) {
        char tmp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = tmp;
    }

    /**
     * 我的蠢方法 O(n) 但是两次
     */
    public String dummySolution(String s) {
        Map<Integer, Character> map = new HashMap();
        Stack<Character> stack = new Stack();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                stack.push(c);
            } else {
                map.put(i, c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            Character mapC = map.get(i);
            if(mapC != null) {
                sb.append(mapC);
                continue;
            }
            Character az = stack.pop();
            sb.append(az);
        }
        return sb.toString();
    }


}
