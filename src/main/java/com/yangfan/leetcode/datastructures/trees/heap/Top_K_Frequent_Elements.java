package com.yangfan.leetcode.datastructures.trees.heap;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 *
 * 1. brute force 主要是map的应用
 * 2. 堆排序 PriorityQueue的应用
 * 3. 计数排序
 *
 * 大根堆小根堆都可以解决top-k问题， n大k小时用小根堆更划算。
 */
public class Top_K_Frequent_Elements {

    /**
     * 标准解法，利用小根堆。
     * 毕竟该题目放在堆排序的章节下
     * 小根堆求top-k的方法
     * 1. 堆没满的情况下一直放入
     * 2. 堆满了的话，如果元素大于堆顶则弹出堆顶，加入新的元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<>((m, n) -> m[1] - n[1]);
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            int [] queueData = new int[]{num, count};
            if (queue.size() == k) {
                // 值大于小根堆的堆顶，则弹出堆顶，加入新的值
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(queueData);
                }
            } else {
                queue.offer(queueData);
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }


    /**
     * 暴力法
     */
     public int[] brute(int[] nums, int k) {
         int [] result = new int[k];
         Map<Integer, Integer> fmap =  new HashMap();
         for(int num: nums) {
             fmap.put(num, fmap.getOrDefault(num, 0) + 1);
         }

         // map转list
         List<Map.Entry<Integer, Integer>> data = new ArrayList(fmap.entrySet());
         Collections.sort(data, (a, b) -> b.getValue() - a.getValue());

         for(int i = 0; i < k; i++) {
             result[i] = data.get(i).getKey();
         }
         return result;
     }

     /**
      * 计数排序 往往是最快的
      */
    public int[] topKByCounting(int[] nums, int k) {
        // 1. 准备计数排序的数组
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int num: nums) {
            if(num > max)
                max = num;
            if(num < min)
                min = num;
        }
        if (max == min) return new int[] {nums[0]};
        int [] count = new int[max - min + 1];
        for(int num: nums) {
            count[num - min]++;
        }

        // 2. 将计数排序数组转化为 存放频率的桶
        List<Integer> [] bucket = new ArrayList[nums.length + 1]; // 这个数组的大小有待商榷
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                if(bucket[count[i]] == null) {
                    bucket[count[i]] = new ArrayList();
                }
                bucket[count[i]].add(i + min);
            }
        }
        // 3. 从高频率往低频率遍历，构造结果数组
        int [] res = new int[k];
        for(int i = bucket.length - 1, j = 0; j < k && i >= 0; i--) {
            List<Integer> fdata = bucket[i];
            if(fdata != null) {
                int size = fdata.size();
                for(int index = size - 1; index >= 0; index--) {
                    res[j++] = fdata.get(index);
                }
            }
        }
        return res;
    }



}
