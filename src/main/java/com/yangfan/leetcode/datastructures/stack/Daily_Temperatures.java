package com.yangfan.leetcode.datastructures.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 739. Daily Temperatures
 * 每日温度
 *
 * 1. 单调栈
 * 2. 暴力
 *
 * 递增问题，单调递增栈，这里面的递增指的是栈顶 -> 栈底 是递增的。
 *
 * updated. 2024.04.28
 * 不管能不能写出标准解法，暴力解肯定要能写出来，正向的反向的...
 *
 */
public class Daily_Temperatures {

    /**
     * 标准单调栈
     *
     * 利用栈的性质保存遍历过的数据，回头来处理
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < length; i++) {
            int cur = temperatures[i];
            // 当栈不为空且当前温度高于栈顶温度时，循环处理栈顶元素，直至栈内只剩比当前温度高的下标
            while (!stack.isEmpty() && cur > temperatures[stack.peek()]) {
                int prevIndex = stack.pop(); // 逐一弹出栈顶比当前温度低的数组之前的元素的索引
                ans[prevIndex] = i - prevIndex;
            }
            // 将当前温度的索引压入栈中
            stack.push(i);
        }
        return ans;
    }

    /**
     * 正向暴力解
     */
    public int[] frontBrute(int[] temperatures) {
        int [] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length - 1; i++) {
            int cur = temperatures[i];
            for(int j = i + 1; j < temperatures.length; j++) {
                if(temperatures[j] > cur) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }


    /**
     * O(m+n)  n为原本数据集、m为辅助数组
     */
    public int[] cleverBrute(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        // 创建一个数组，用于存储从1到100的每个温度值最近出现的索引。初始化为Integer.MAX_VALUE表示尚未出现
        int[] tempIndex = new int[101];
        Arrays.fill(tempIndex, Integer.MAX_VALUE);

        for (int i = length - 1; i >= 0; --i) {
            // 初始化一个变量，用于记录比当前温度更高的下一个温度值的索引
            int warmerIndex = Integer.MAX_VALUE;
            // 遍历从当前温度加一度开始的所有可能的更高温度，看看哪个下标最小
            for (int t = temperatures[i] + 1; t <= 100; ++t) {
                // 如果某个更高温度值在数组中已经出现，并且其索引比当前记录的索引要小，则更新索引
                if (tempIndex[t] < warmerIndex) {
                    warmerIndex = tempIndex[t];
                }
            }
            // 如果找到了一个更高的温度，则计算等待的天数，并存储在结果数组中
            if (warmerIndex < Integer.MAX_VALUE) {
                ans[i] = warmerIndex - i;
            }
            // 更新当前温度值在数组中的最近出现索引
            tempIndex[temperatures[i]] = i;
        }
        return ans;
    }

}
