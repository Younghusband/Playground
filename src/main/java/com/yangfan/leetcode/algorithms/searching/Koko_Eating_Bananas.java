package com.yangfan.leetcode.algorithms.searching;

/**
 * 875. Koko Eating Bananas
 * 爱吃香蕉的珂珂
 *
 * 学到的:
 * 1. 二分法猜答案基本思路
 * 2. 除法的向上取整
 *
 *
 */
public class Koko_Eating_Bananas {

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = 0;
        for(int pile : piles) {
            high = Math.max(pile, high); // 最大的速度为最大的那堆香蕉
        }

        while(low < high) {
            int speed = (low + high) >>> 1;
            int k = calculateTime(piles, speed);
            if(k <= h) {
                high = speed;
            } else {
                // 速度慢了，要加速
                low = speed + 1;
            }
        }
        return low;
    }

    private int calculateTime(int [] piles, int speed) {
        int time = 0;
        for(int pile : piles) {
//            time += (pile + speed - 1) / speed;
            time += (int)(Math.ceil((double)pile / speed)); // 另一种方法
        }
        return time;
    }

}
