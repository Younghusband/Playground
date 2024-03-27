package com.yangfan.leetcode.algorithms.window;


/**
 * 718. 最长重复子数组
 *
 * Example 1:
 * Input: nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 * Output: 3
 * Explanation: The repeated subarray with maximum length is [3,2,1].
 *
 * 核心: 子串，步长，如何暴力遍历
 *
 */
public class Maximum_Length_of_Repeated_Subarray {


    /**
     * 说实话这个暴力解我一开始都写不出
     *
     */
    public int brute(int[] A, int[] B) {
        int ans = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int k = 0;
                while(i + k < A.length && j + k < B.length && A[i + k] == B[j + k]) {
                    k++;
                }
                ans = Math.max(ans, k);
            }
        }
        return ans;
    }


}
