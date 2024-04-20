package com.yangfan.leetcode.algorithms.sorting.fast;


import com.yangfan.playground.util.ArrayUtil;

/**
 * 堆排序
 * 时间复杂度 O(NlogN)
 * 空间复杂度 O(1)
 * 不稳定排序
 * <p>
 * 步骤
 * 1. 构建最大堆
 * 2. 把堆顶弹出放到数组末端，构建新堆，循环直至排序完
 *
 *
 * 第一点尤为重要，需要关注两个问题:
 * 1. 从哪个结点开始构建堆化操作
 * 2. 为什么不能一次堆化完成
 *
 *
 */
public class HeapSort {

    public static void main(String[] args) {
        int [] nums = {9,3,2,1,5,6,18,7,-4};
//        int [] nums = {-4,0,7,4,9,-5,-1,0,-7,-1};
        HeapSort service = new HeapSort();
        service.sort(nums);
        ArrayUtil.printArray(nums);
        System.out.println(1/2 - 1);
    }

    public void sort(int[] nums) {
        int n = nums.length;
        // 构建最大堆 i初始值[n/2 - 1, n - 1] 都是可以的
        // n/2 - 1 是最后一个非叶子节点
        for(int i = n/2 - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }

        // 将堆顶元素弹出
        for(int i = n - 1; i > 0; i--) {
            swap(nums, 0, i); // 不断交换堆顶和堆底
            heapify(nums, 0, i); // 缩堆，重构堆
        }
    }

    /**
     * 方法作用:
     * 选定数组中某个节点的值，
     *
     * 递归的终止条件:
     * 1. 当前子树符合最大堆条件，即根节点为最大节点
     * 2. 不存在子节点，即left >= heapSize
     *
     */
    void heapify(int [] nums, int i, int heapSize) {
        int largest = i;
        int left = i * 2 + 1;
        int right = i * 2 + 2;
        if(left < heapSize && nums[left] > nums[largest]) {
            largest = left;
        }
        if(right < heapSize && nums[right] > nums[largest]) {
            largest = right;
        }
        // 如果最大值不是根节点，递归
        if(largest != i) {
            swap(nums, i, largest);
            heapify(nums, largest, heapSize);
        }
    }

    void swap(int [] arr, int p1, int p2) {
        int temp = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = temp;
    }
}
