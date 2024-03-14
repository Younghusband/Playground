package com.yangfan.leetcode.trick;

import java.util.HashMap;
import java.util.Map;

/**
 * 287. Find The Duplicate Number
 * 寻找重复数
 *
 * 给定一个包含n+1个整数的数组nums，其数字都在[1, n]范围内（包括1和n，可知至少存在一个重复的整数。
 * 假设nums只有一个重复的整数，返回这个重复的数。
 *
 * 你设计的解决方案必须不修改数组nums且只用常量级O(1)的额外空间。
 *
 * 不要和“数组中只有一个数出现了奇数次，其他都出现了偶数次，找到那个出现奇数次的数”混淆
 * 这道题比那个复杂得多。
 *
 * 1. 构造环形链表
 *
 */
public class Find_The_Duplicate_Number {

    public int findDuplicate(int[] nums) {
        int slow = nums[0]; // 注意，这里nums[0] 相当于head.next
        int fast = nums[nums[0]];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0; // 根据上一条注释，你就明白这里为什么是0而不是nums[0]
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int useMap(int[] nums) {
        if(nums == null || nums.length == 1)
            throw new RuntimeException("Caonima!");
        Map<Integer, Integer> cMap = new HashMap();
        for(int num: nums) {
            cMap.put(num, cMap.getOrDefault(num, 0) + 1);
            int current = cMap.get(num);
            if(current > 1)
                return num;
        }
        return 0;
    }


}
