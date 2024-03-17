package com.yangfan.leetcode.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * n sum问题通解
 *
 * 入参: 数组nums, n个数, 目标和target
 *
 * 核心思路就是把问题降维到n-1, 直到2个数, 转化为 two sum问题
 *
 */
public class N_Sum {

    class Solution {

        // 主方法，求解3Sum问题
        public List<List<Integer>> threeSum(int[] nums) {
            // 调用通用的nSum方法，其中k=3，target=0
            return nSum(nums, 3, 0);
        }

        // 通用的nSum方法
        public List<List<Integer>> nSum(int[] nums, int k, int target) {
            // 使用匿名内部类来定义返回值的类型
            return new java.util.AbstractList<List<Integer>>() {
                final List<List<Integer>> res = new ArrayList<>(); // 存储最终结果
                final List<Integer> path = new ArrayList<>(); // 存储当前路径
                long min; // 存储数组中的最小值

                public List<Integer> get(int index) {
                    // 获取结果集中的某个解
                    init();
                    return res.get(index);
                }

                public int size() {
                    // 获取结果集的大小
                    init();
                    return res.size();
                }

                public void init() {
                    // 初始化函数，用于计算结果集
                    if (res.isEmpty()) {
                        int n = nums.length;
                        long[] Arr = new long[n];
                        Arrays.sort(nums); // 对数组进行排序
                        min = nums[0];
                        for (int i = 0; i < n; i++) {
                            Arr[i] = nums[i] - min;
                        }
                        long NewTarget = (long) target - (long) k * min;
                        C(false, Arr, n, k, NewTarget);
                    }
                }

                // 主要的递归函数，用于计算nSum问题
                public void C(boolean T, long[] a, int n, int k, long target) {
                    if (n == 0 || k == 0) {
                        // 递归终止条件
                        if (target == 0 && k == 0) {
                            res.add(new ArrayList<>(path));
                        }
                        return;
                    }
                    if (k == 2) {
                        // 当问题降解为2Sum时，使用双指针法求解
                        twoSum(a, 0, n - 1, target);
                        return;
                    }
                    if (n == k) {
                        // 当数组中的元素个数等于k时，直接判断是否满足条件
                        sumArr(a, n, target);
                        return;
                    }
                    if (check(a, n, k, target)) {
                        // 检查是否有解
                        return;
                    }
                    // 递归计算(n-1)Sum问题
                    C(false, a, n - 1, k, target);
                    if (!T && n != a.length && a[n] == a[n - 1]) {
                        return;
                    }
                    if (target - a[n - 1] >= 0) {
                        path.add((int) (a[n - 1] + min));
                        C(true, a, n - 1, k - 1, target - a[n - 1]);
                        path.remove(path.size() - 1);
                    }
                }

                // 用于求解2Sum问题的函数
                void twoSum(long[] a, int l, int r, long target) {
                    while (r > l) {
                        long sum = a[l] + a[r];
                        if (sum < target) {
                            l++;
                        } else if (sum > target) {
                            r--;
                        } else {
                            path.add((int) (a[l] + min));
                            path.add((int) (a[r] + min));
                            res.add(new ArrayList<>(path));
                            path.remove(path.size() - 1);
                            path.remove(path.size() - 1);
                            while (r > l && a[l] == a[l + 1]) {
                                l++;
                            }
                            while (r > l && a[r] == a[r - 1]) {
                                r--;
                            }
                            l++;
                            r--;
                        }
                    }
                }

                // 用于求解nSum问题的函数
                void sumArr(long[] a, int n, long target) {
                    for (int i = n - 1; i > -1; i--) {
                        target -= a[i];
                        path.add((int) (a[i] + min));
                    }
                    if (target == 0) {
                        res.add(new ArrayList<>(path));
                    }
                    for (int i = n - 1; i > -1; i--) {
                        target += a[i];
                        path.remove(path.size() - 1);
                    }
                }

                // 检查是否有解的函数
                boolean check(long[] a, int n, int k, long target) {
                    if (n - k < 0) {
                        return true;
                    }
                    long max = 0;
                    long min = 0;
                    for (int i = 0; i < k; i++) {
                        min += a[i];
                        max += a[n - i - 1];
                    }
                    if (target < min || target > max) {
                        return true;
                    }
                    return false;
                }
            };
        }
    }

}
