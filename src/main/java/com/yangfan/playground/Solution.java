package com.yangfan.playground;

import java.util.Set;
import java.util.TreeSet;

public class Solution {
    
    public static int[] twoSum(int[] n, int target) {   
        int i = 0;
        int j = n.length-1;
        for(; i<j; i++) {
            for(; j>i; j--) {
                if(target == (n[i] + n[j])) {
                    return new int []{i, j};
                }
                if(j-i == 1) {  //如果j i 相邻且仍不符合条件
                    j = n.length-1;
                    break;
                }
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
        int [] nx = {11, 2, 7, 15};
        int [] result = twoSum(nx,9);
        for(int i:result)
             System.out.println(i);
        Set<Integer> resultSet = new TreeSet<>();
        for(int i=0; i < 64; i ++) {
            resultSet.add(String.valueOf(i).hashCode());
        }
        System.out.println(resultSet);
    }

    public static void bubbleSort(int [] arr) {



    }

    
    
}
