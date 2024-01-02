package com.yangfan.playground.xjb;

import com.yangfan.playground.util.ArrayUtil;

/**
 * 临时区，不存储任何代码
 *
 */
public class Main {
    public static void main(String[] args) {
        int [] arr1 = {1,2,3,4,5,6,6,8,7};
        int [] arr2 = ArrayUtil.copyArray(arr1);

        ArrayUtil.printArray(arr2);


    }

}
