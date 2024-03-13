package com.yangfan.leetcode.datastructures.arrays;

/**
 * 11. Container With Most Water
 * 盛最多水的容器
 *
 * 1. 如何计算面积
 * 2. 如何计算最大面积
 *
 * 这题属于套路题，不用深思，记住即可。
 */
public class Container_With_Most_Water {

    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length - 1;

        while(left < right) {
            int area = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(area, max);
            if(height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }

    /**
     * 效率更高，避免无效的比较
     * 每次移动都找到最近的，比之前高的那根
     */
    public int fast(int[] height) {
        int left = 0, right = height.length-1;
        int area = 0;
        while(left < right){
            int h = Math.min(height[left], height[right]);
            area = Math.max(area, (right-left) * h);
            while(left < right && height[left] <= h){
                left++;
            }
            while(left < right && height[right] <= h){
                right--;
            }
        }
        return area;
    }


}
